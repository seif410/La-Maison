package com.example.lamaison;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import database.database;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<String> name, price;
    database db;
    MyAdapter adapter;
    String ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        String x = (getIntent().getExtras().getString("email"));
        ids = x;
        BottomNavigationView btv = findViewById(R.id.bottom_navigation);
        btv.setSelectedItemId(R.id.cart);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent home = new Intent(getApplicationContext(), Home.class);
                        home.putExtra("email", x);
                        startActivity(home);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.cart:
                        return true;
                    case R.id.Profile:
                        Intent profile = new Intent(getApplicationContext(), Profile.class);
                        profile.putExtra("email", x);
                        startActivity(profile);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        db = new database(this);
        name = new ArrayList<>();
        price = new ArrayList<>();
        recyclerview = findViewById(R.id.recyclerview1);
        adapter = new MyAdapter(this, name, price);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = db.getdata(ids);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Items Added to Cart", Toast.LENGTH_LONG).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(1));
                price.add(cursor.getString(2));
            }
        }
    }
}