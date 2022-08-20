package com.example.lamaison;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import Categories.Clothes;
import Categories.Groceries;

public class Home extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String x = (getIntent().getExtras().getString("email"));
        ImageButton imgbtn = (ImageButton) findViewById(R.id.fpagebtn);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Groceries.class);
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


