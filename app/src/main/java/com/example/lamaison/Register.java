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

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database db = new database(this);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp su = new SignUp();
                String fname = ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString();
                String lname = ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString();
                String pass = ((EditText) findViewById(R.id.editTextTextPassword2)).getText().toString();
                String cpass = ((EditText) findViewById(R.id.editTextTextPassword3)).getText().toString();
                String email = ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
                String birthdate = ((EditText) findViewById(R.id.editTextDate)).getText().toString();

                su.setFname(fname);
                su.setLname(lname);
                su.setBirthdate(birthdate);
                su.setPass(pass);
                su.setCpass(cpass);
                su.setEmail(email);
                if ((fname.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter first name", Toast.LENGTH_LONG).show();
                } else if ((lname.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter last name", Toast.LENGTH_LONG).show();
                } else if ((email.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_LONG).show();
                } else if ((pass.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter a Password", Toast.LENGTH_LONG).show();
                } else if ((cpass.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please Confirm Password", Toast.LENGTH_LONG).show();
                }
                if (!(pass.equals(cpass))) {
                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                }
                if (isValidEmail((EditText) findViewById(R.id.editTextTextEmailAddress))) {
                    db.adduser(fname, lname, pass, email, birthdate);
                    Toast.makeText(Register.this, "User Created Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Register.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Button logbtn = (Button) findViewById(R.id.loginbtn);
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
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