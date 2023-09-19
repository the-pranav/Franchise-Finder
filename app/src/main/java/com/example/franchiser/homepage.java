package com.example.franchiser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class homepage extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    Button food, sneaker, apparel, jewellery, logout;
//    ImageView p1, p2, p3, p4;
    TextView userDetails;

//    List<String> Coname;
//    SearchView searchView;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> itemList;
    private SearchView searchView;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        user = auth.getCurrentUser();
        userDetails = findViewById(R.id.userDetails);

        // from Chat GPT


        recyclerView = this.<RecyclerView>findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
//
        itemList = new ArrayList<>();
        // Populate the itemList with some data (you can replace this with your data source)
        itemList.add(new Item("Monginis", R.drawable.monginis));
        itemList.add(new Item("Blafar", R.drawable.blafar));
        itemList.add(new Item("Sangini", R.drawable.sangini));
        itemList.add(new Item("Lee", R.drawable.lee));

        // Add more items as needed

        // Initialize RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(itemList,getApplicationContext());
        recyclerView.setAdapter(adapter);

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            userDetails.setText(user.getEmail());
        }
        // Set up SearchView listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the RecyclerView data based on the search query
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String text) {
        // Create a new list to store the filtered items
        List<Item> filteredList = new ArrayList<>();

        // Iterate through the original list and add matching items to the filtered list
        for (Item item : itemList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        // Update the RecyclerView with the filtered data
        adapter.filterList(filteredList);

        // Till here

        // Recycler View
//        RecyclerView popCo = this.<RecyclerView>findViewById(R.id.recyclerView);
//        popCo.setLayoutManager(new LinearLayoutManager(this));
//        String[] Coname = {"Monginis", "Blafar", "Sangini", "Lee"};
//        popCo.setAdapter(new foodApdapter(Coname));




        food = findViewById(R.id.food);
        sneaker = findViewById(R.id.sneaker);
        apparel = findViewById(R.id.apparel);
        jewellery = findViewById(R.id.jewellery);

//        p1 = findViewById(R.id.p1);
//        p2 = findViewById(R.id.p2);
//        p3 = findViewById(R.id.p3);
//        p4 = findViewById(R.id.p4);

        // On click Listeners Events for the Categories

        food.setOnClickListener(v -> {
            Intent intent = new Intent(homepage.this, MainFoodActivity.class);
            startActivity(intent);
        });

        sneaker.setOnClickListener(v -> {
            Intent intent = new Intent(homepage.this, MainSneakerActivity.class);
            startActivity(intent);
        });

        apparel.setOnClickListener(v -> {
            Intent intent = new Intent(homepage.this , MainApparelActivity.class);
            startActivity(intent);
        });

        jewellery.setOnClickListener(v -> {
            Intent intent = new Intent(homepage.this, MainJewelleryActivity.class);
            startActivity(intent);
        });

        // On Click Listeners Events for the companies (Popular)

//        p1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(homepage.this, demoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        p2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(homepage.this, blafar.class);
//                startActivity(intent);
//            }
//        });
//
//        p3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(homepage.this, sangini.class);
//                startActivity(intent);
//            }
//        });
//
//        p4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(homepage.this, lee.class);
//                startActivity(intent);
//            }
//        });

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(homepage.this, MainActivity.class);
            startActivity(intent);
        });
    }
}