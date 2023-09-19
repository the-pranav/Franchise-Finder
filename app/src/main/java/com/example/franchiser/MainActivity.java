package com.example.franchiser;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {


    FirebaseAuth mAuth;

    Button button1,move;

    EditText inputEmail, inputPassword;
    TextView forgotPass;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            Intent intent = new Intent(getApplicationContext(), homepage.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        forgotPass = findViewById(R.id.forgotpassword);

        forgotPass.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,reset_password.class);
            startActivity(intent);
        });

        button1= findViewById(R.id.btn1); // Signup Button
        move= findViewById(R.id.btn); // login Button

        // Input details in the variables

        inputEmail = findViewById(R.id.email);
        inputPassword= findViewById(R.id.password);



        button1.setOnClickListener(v -> {

            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });
        move.setOnClickListener(v -> {

            // Intent just to redirect without authentication and validation

            String email,password;

            email = String.valueOf(inputEmail.getText());
            password = String.valueOf(inputPassword.getText());

            if(TextUtils.isEmpty(email)  || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(MainActivity.this, "Enter E-mail ID Properly", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(password)){
                Toast.makeText(MainActivity.this, "Enter Credentials", Toast.LENGTH_SHORT).show();
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "Login Successful",
                                        Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(MainActivity.this, homepage.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        });
    }
}