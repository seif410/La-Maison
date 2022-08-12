package com.example.lamaison;

public class SignUp {
    private String fname, lname, pass, Cpass, email, birthdate;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpass() {
        return Cpass;
    }

    public void setCpass(String cpass) {
        Cpass = cpass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}


