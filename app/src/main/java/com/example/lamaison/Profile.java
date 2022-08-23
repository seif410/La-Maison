package com.example.lamaison;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import database.database;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {
    ImageButton logoutbtn;
    database db;
    TextView textView1, textView2, textView3, textView4;
    String id, fName, lName, Email, Birthdate;
    BottomNavigationView bottomnavigationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        id = (getIntent().getExtras().getString("email"));
        bottomnavigationview = findViewById(R.id.bottom_navigation);
        bottomnavigationview.setSelectedItemId(R.id.Profile);
        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent home = new Intent(getApplicationContext(), Home.class);
                        home.putExtra("email", id);
                        startActivity(home);
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.cart:
                        Intent cart = new Intent(getApplicationContext(), Cart.class);
                        cart.putExtra("email", id);
                        startActivity(cart);
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.Profile:
                        return true;
                }
                return false;
            }
        });
        logoutbtn = (ImageButton) findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivity(login);
                finish();
            }
        });

        textView1 = (TextView) findViewById(R.id.textView12);
        textView2 = (TextView) findViewById(R.id.textView14);
        textView3 = (TextView) findViewById(R.id.textView17);
        textView4 = (TextView) findViewById(R.id.textView19);
        db = new database(this);
        getdata();
        textView1.setText(fName);
        textView2.setText(lName);
        textView3.setText(Email);
        textView4.setText(Birthdate);

    }

    public void getdata() {
        Cursor cursor = db.getuserdata(id);
        if (cursor.getCount() == 0) {
            return;
        } else {
            while (cursor.moveToNext()) {
                fName = cursor.getString(1);
                lName = cursor.getString(2);
                Email = cursor.getString(4);
                Birthdate = cursor.getString(5);
            }
        }
    }
}