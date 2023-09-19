package com.example.franchiser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainJewelleryActivity extends AppCompatActivity {

//    ImageView back,sangini, sia, khanna, kalyan;
    ImageView back;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jewellery);

//            Recycler view code by own
//        RecyclerView JewelCo = this.<RecyclerView>findViewById(R.id.jewelCompanies);
//        JewelCo.setLayoutManager(new LinearLayoutManager(this));
//        String[] Coname = {"Sangini", "Sia", "Khanna", "Kalyan"};
//        JewelCo.setAdapter(new foodApdapter(Coname));

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainJewelleryActivity.this, homepage.class);
                startActivity(intent);
            }
        });

        // From Chat GPT
        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        // Populate the itemList with some data (you can replace this with your data source)
        itemList.add(new Item("Sangini", R.drawable.sangini));
        itemList.add(new Item("Sia", R.drawable.sia));
        itemList.add(new Item("Khanna", R.drawable.khanna));
        itemList.add(new Item("Kalyan", R.drawable.kalyan));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(itemList , getApplicationContext());
        recyclerView.setAdapter(adapter);


//        sangini = findViewById(R.id.sangini);
//        sia = findViewById(R.id.sia);
//        khanna = findViewById(R.id.khanna);
//        kalyan = findViewById(R.id.kalyan);


//        sangini.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainJewelleryActivity.this, sangini.class);
//                startActivity(intent);
//            }
//        });
//
//        sia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainJewelleryActivity.this, sangini.class);
//                startActivity(intent);
//            }
//        });
//
//        khanna.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainJewelleryActivity.this, sangini.class);
//                startActivity(intent);
//            }
//        });
//
//        kalyan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainJewelleryActivity.this, sangini.class);
//                startActivity(intent);
//            }
//        });
    }
}