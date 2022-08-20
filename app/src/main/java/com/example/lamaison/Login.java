package com.example.lamaison;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.database;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database log = new database(this);
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
                    if (log.CheckLogin(loged.getemail(), loged.getPassword()) != null) {
                        Intent i = new Intent(Login.this, Home.class);
                        i.putExtra("email", log.CheckLogin(loged.getemail(), loged.getPassword()));
                        startActivity(i);
                        finish();
                    } else if (!isValidEmail(email)) {
                        Toast.makeText(Login.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Incorrect Email or Password!", Toast.LENGTH_LONG).show();
                    }

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

    public boolean isValidEmail(EditText email) {
        String emailInput = email.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;
        } else {
            return false;
        }
    }
}
