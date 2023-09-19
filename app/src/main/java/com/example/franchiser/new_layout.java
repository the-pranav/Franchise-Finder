package com.example.franchiser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class new_layout extends AppCompatActivity {

    ImageView img;
    TextView tv1, desc,contact;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_layout);

        img = (ImageView) findViewById(R.id.desc_img);
        tv1 = (TextView) findViewById(R.id.desc_header);
        desc = (TextView) findViewById(R.id.description);
        contact = (TextView) findViewById(R.id.contactnow);

        img.setImageResource(getIntent().getIntExtra("Imagename",0));
        tv1.setText(getIntent().getStringExtra("Title"));
        desc.setText(R.string.description);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:6359292256"));
                startActivity(intent);
            }
        });

    }
}