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
    SignUp su;
    database db;
    EditText fname, lname, pass, cpass, email, birthdate;
    Button btn, logbtn;
    String emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new database(this);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                su = new SignUp();
                fname = ((EditText) findViewById(R.id.editTextTextPersonName));
                lname = ((EditText) findViewById(R.id.editTextTextPersonName2));
                pass = ((EditText) findViewById(R.id.editTextTextPassword2));
                cpass = ((EditText) findViewById(R.id.editTextTextPassword3));
                email = ((EditText) findViewById(R.id.editTextTextEmailAddress));
                birthdate = ((EditText) findViewById(R.id.editTextDate));

                su.setFname(fname.getText().toString());
                su.setLname(lname.getText().toString());
                su.setBirthdate(birthdate.getText().toString());
                su.setPass(pass.getText().toString());
                su.setEmail(email.getText().toString());
                if ((su.getFname().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter first name", Toast.LENGTH_LONG).show();
                } else if ((su.getLname().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter last name", Toast.LENGTH_LONG).show();
                } else if ((su.getEmail().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_LONG).show();
                } else if ((su.getPass().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter a Password", Toast.LENGTH_LONG).show();
                } else if ((cpass.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please Confirm Password", Toast.LENGTH_LONG).show();
                }
                if (!(su.getPass().equals(cpass.getText().toString()))) {
                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                }
                if (isValidEmail((EditText) findViewById(R.id.editTextTextEmailAddress))) {
                    db.adduser(su.getFname(), su.getLname(), su.getPass(), su.getEmail(), su.getBirthdate());
                    Toast.makeText(Register.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                    fname.setText("");
                    lname.setText("");
                    pass.setText("");
                    cpass.setText("");
                    email.setText("");
                    birthdate.setText("");
                } else if (!(isValidEmail((EditText) findViewById(R.id.editTextTextEmailAddress))) && !(su.getEmail().isEmpty())) {
                    Toast.makeText(Register.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                }

            }
        });
        logbtn = (Button) findViewById(R.id.loginbtn);
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });
    }

    public boolean isValidEmail(EditText email) {
        emailInput = email.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;
        } else {
            return false;
        }
    }
}