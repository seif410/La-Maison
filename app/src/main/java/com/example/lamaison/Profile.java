package com.example.lamaison;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String x = (getIntent().getExtras().getString("email"));
        BottomNavigationView btv = findViewById(R.id.bottom_navigation);
        btv.setSelectedItemId(R.id.Profile);
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
                        Intent cart = new Intent(getApplicationContext(), Cart.class);
                        cart.putExtra("email", x);
                        startActivity(cart);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Profile:
                        return true;
                }
                return false;
            }
        });
    }
}