package com.example.lamaison;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import Categories.Clothes;
import Categories.Electronics;
import Categories.Groceries;

public class Home extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String x = (getIntent().getExtras().getString("email"));
        BottomNavigationView btv = findViewById(R.id.bottom_navigation);
        btv.setSelectedItemId(R.id.home);
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cart:
                        Intent cart = new Intent(getApplicationContext(), Cart.class);
                        cart.putExtra("email", x);
                        startActivity(cart);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
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
        ImageButton imgbtn = (ImageButton) findViewById(R.id.fpagebtn);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Groceries.class);
                i.putExtra("homeid", x);
                startActivity(i);
            }
        });
        ImageButton imgbtn2 = (ImageButton) findViewById(R.id.spagebtn);
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Clothes.class);
                i.putExtra("homeid", x);
                startActivity(i);
            }
        });
        ImageButton imgbtn3 = (ImageButton) findViewById(R.id.tpagebtn);
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Electronics.class);
                i.putExtra("homeid", x);
                startActivity(i);
            }
        });
        int imgArr[] = {R.drawable.adidas, R.drawable.adidas2, R.drawable.heels4};
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        for (int i = 0; i < imgArr.length; i++) {
            showImg(imgArr[i]);
        }

    }

    public void showImg(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out);
    }

}


