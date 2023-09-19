package com.example.franchiser;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

public class MainActivity2 extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText inputEmail, inputPassword, fullname, phone;
    Button registration;
    TextView loginRedirect;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            Intent intent = new Intent(MainActivity2.this, homepage.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        registration = findViewById(R.id.registerbutton);
        loginRedirect = findViewById(R.id.createtext);
        fullname = findViewById(R.id.fullname);
        phone = findViewById(R.id.phone);


        loginRedirect.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });

        registration.setOnClickListener(v -> {
            String email, password,full_name, phone_input;
            full_name = String.valueOf(fullname.getText());
            phone_input = String.valueOf(phone.getText());
            email = String.valueOf(inputEmail.getText());
            password = String.valueOf(inputPassword.getText());

            if(TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(MainActivity2.this, "Enter E-mail ID Properly", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(full_name)){
                Toast.makeText(MainActivity2.this, "Enter Credentials Properly", Toast.LENGTH_SHORT).show();
            }

            if(TextUtils.isEmpty(phone_input) ){
                Toast.makeText(MainActivity2.this, "Enter Credentials Properly", Toast.LENGTH_SHORT).show();
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(MainActivity2.this, "Enter Credentials Properly", Toast.LENGTH_SHORT).show();
            }


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity2.this, "Registration Successfull.",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity2.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
        });
    }
}