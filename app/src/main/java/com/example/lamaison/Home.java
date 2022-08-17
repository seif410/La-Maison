package com.example.lamaison;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String x = (getIntent().getExtras().getString("email"));
        /*Toast.makeText(Home.this, x, Toast.LENGTH_LONG).show();*/
        ImageButton imgbtn = (ImageButton) findViewById(R.id.fpagebtn);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, MainActivity2.class);
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
                Intent i = new Intent(Home.this, MainActivity3.class);
                startActivity(i);
            }
        });
        Button logout = (Button) findViewById(R.id.button3);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Login.class);
                startActivity(i);
            }
        });


    }
}