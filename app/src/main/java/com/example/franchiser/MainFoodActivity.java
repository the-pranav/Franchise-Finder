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

public class MainFoodActivity extends AppCompatActivity {

//    ImageView back,monginis, chocoRoom, openMagick, chicagoPizza;
    ImageView back;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> itemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food);

        // Recycler view code by own
//        RecyclerView foodCo = this.<RecyclerView>findViewById(R.id.foodCompanies);
//        foodCo.setLayoutManager(new LinearLayoutManager(this));
//        String[] Coname = {"Monginis", "Chocolate Room", "Oven Magick", "Chicago Pizza"};
//        foodCo.setAdapter(new foodApdapter(Coname));

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainFoodActivity.this, homepage.class);
                startActivity(intent);
            }
        });

        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        // Populate the itemList with some data (you can replace this with your data source)
        itemList.add(new Item("Monginis", R.drawable.monginis));
        itemList.add(new Item("Chocolate Room", R.drawable.chocolate_room));
        itemList.add(new Item("Oven Magick", R.drawable.open_magick));
        itemList.add(new Item("Chicago Pizza", R.drawable.chicago_pizza));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(itemList,getApplicationContext());
        recyclerView.setAdapter(adapter);

//        monginis = findViewById(R.id.monginis);
//        chocoRoom = findViewById(R.id.chocoRoom);
//        openMagick = findViewById(R.id.openMagick);
//        chicagoPizza = findViewById(R.id.chicagoPizza);


//        monginis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainFoodActivity.this, demoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        chocoRoom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainFoodActivity.this, demoActivity.class);
//                startActivity(intent);
//            }
//        });
//        openMagick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainFoodActivity.this, demoActivity.class);
//                startActivity(intent);
//            }
//        });
//        chicagoPizza.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainFoodActivity.this, demoActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}