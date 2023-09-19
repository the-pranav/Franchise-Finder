package com.example.franchiser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainSneakerActivity extends AppCompatActivity {

//    ImageView back, blafar,m_b, bigshoe,tresmode ;
        ImageView back;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> itemList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sneaker);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSneakerActivity.this, homepage.class);
                startActivity(intent);
            }
        });

        // Recycler view code by own
//        RecyclerView sneakerCo = this.<RecyclerView>findViewById(R.id.sneakerCompanies);
//        sneakerCo.setLayoutManager(new LinearLayoutManager(this));
//        String[] Coname = {"Blafar", "M & B", "Bigshoe", "Tresmode"};
//        sneakerCo.setAdapter(new foodApdapter(Coname));

        // From Chat GPT

        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        // Populate the itemList with some data (you can replace this with your data source)
        itemList.add(new Item("Blafar", R.drawable.blafar));
        itemList.add(new Item("M & B", R.drawable.m_b));
        itemList.add(new Item("BigShoe", R.drawable.bigshoe));
        itemList.add(new Item("Tresmode", R.drawable.tresmode));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(itemList, getApplicationContext());
        recyclerView.setAdapter(adapter);

//        blafar = findViewById(R.id.blafar);
//        m_b = findViewById(R.id.m_b);
//        bigshoe = findViewById(R.id.bigshoe);
//        tresmode = findViewById(R.id.tresmode);

//
//        blafar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainSneakerActivity.this, blafar.class);
//                startActivity(intent);
//            }
//        });
//
//        m_b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainSneakerActivity.this, blafar.class);
//                startActivity(intent);
//            }
//        });
//
//        bigshoe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainSneakerActivity.this, blafar.class);
//                startActivity(intent);
//            }
//        });
//        tresmode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainSneakerActivity.this, blafar.class);
//                startActivity(intent);
//            }
//        });

    }
}