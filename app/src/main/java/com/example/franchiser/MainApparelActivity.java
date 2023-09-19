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

public class MainApparelActivity extends AppCompatActivity {

//    ImageView back, lee, siyaram, f_studio, dblm;
    ImageView back;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_apparel);

        // Recycler view code by own
//        RecyclerView apparelCo = this.<RecyclerView>findViewById(R.id.apparelCompanies);
//        apparelCo.setLayoutManager(new LinearLayoutManager(this));
//        String[] Coname = {"Lee", "Siyaram", "F-Studio", "DBLM"};
//        apparelCo.setAdapter(new foodApdapter(Coname));

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainApparelActivity.this, homepage.class);
                startActivity(intent);
            }
        });

        // From Chat GPT

        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        // Populate the itemList with some data (you can replace this with your data source)
        itemList.add(new Item("Lee", R.drawable.lee));
        itemList.add(new Item("Siyaram", R.drawable.siyaram));
        itemList.add(new Item("F-Studio", R.drawable.f_studio));
        itemList.add(new Item("DBLM", R.drawable.dblm));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(itemList,getApplicationContext());
//        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(adapter);

//        lee = findViewById(R.id.lee);
//        siyaram = findViewById(R.id.siyaram);
//        f_studio = findViewById(R.id.f_studio);
//        dblm = findViewById(R.id.dblm);


//        lee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainApparelActivity.this, lee.class);
//                startActivity(intent);
//            }
//        });
//
//        siyaram.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainApparelActivity.this, lee.class);
//                startActivity(intent);
//            }
//        });
//
//        f_studio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainApparelActivity.this, lee.class);
//                startActivity(intent);
//            }
//        });

//        dblm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainApparelActivity.this, lee.class);
//                startActivity(intent);
//            }
//        });
    }
}