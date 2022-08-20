package com.example.lamaison;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Cart extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        String x = (getIntent().getExtras().getString("email"));
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
    }
}