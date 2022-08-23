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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
    Button checkout;
    TextView textview, textView1, textView2, textView3;
    BottomNavigationView btv;
    int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        String x = (getIntent().getExtras().getString("email"));
        ids = x;
        db = new database(this);
        name = new ArrayList<>();
        price = new ArrayList<>();
        recyclerview = findViewById(R.id.recyclerview1);
        checkout = (Button) findViewById(R.id.Checkout_btn);
        textview = (TextView) findViewById(R.id.textView3);
        textView1 = (TextView) findViewById(R.id.textView8);
        textView2 = (TextView) findViewById(R.id.textView4);
        textView3 = (TextView) findViewById(R.id.textView9);
        btv = findViewById(R.id.bottom_navigation);

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
                        finish();
                        return true;
                    case R.id.cart:
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Profile:
                        Intent profile = new Intent(getApplicationContext(), Profile.class);
                        profile.putExtra("email", x);
                        startActivity(profile);
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                }
                return false;
            }
        });
        if (displaydata()) {
            recyclerview.setVisibility(View.VISIBLE);
            textview.setVisibility(View.GONE);
            textView1.setText(String.valueOf(total));
            adapter = new MyAdapter(this, name, price, ids);
            recyclerview.setAdapter(adapter);
            recyclerview.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerview.setVisibility(View.GONE);
            textview.setVisibility(View.VISIBLE);
            checkout.setVisibility(View.GONE);
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
        }

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.CheckoutCart(ids);
                Toast.makeText(Cart.this, "You Bought Items Successfully", Toast.LENGTH_LONG).show();
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
    }

    private boolean displaydata() {
        Cursor cursor = db.getdata(ids);
        if (cursor.getCount() == 0) {
            return false;
        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(1));
                price.add(cursor.getString(2));
                total = total + cursor.getInt(2);
            }
            return true;
        }
    }
}