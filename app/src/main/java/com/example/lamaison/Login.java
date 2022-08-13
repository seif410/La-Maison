package com.example.lamaison;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn = (Button) findViewById(R.id.login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin loged = new signin();
                EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
                EditText pw = (EditText) findViewById(R.id.editTextTextPassword2);
                loged.setemail(email.getText().toString());
                loged.setPassword(pw.getText().toString());
                if (loged.getemail().isEmpty() && loged.getPassword().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLease Enter Your Email and Password!", Toast.LENGTH_LONG).show();
                } else if (loged.getPassword().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLease Enter Your Password!", Toast.LENGTH_LONG).show();
                } else if (loged.getemail().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLease Enter Your Email!", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(Login.this, Home.class);
                    startActivity(i);
                }

            }
        });
        Button signupbtn = (Button) findViewById(R.id.reg_btn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
    }
}