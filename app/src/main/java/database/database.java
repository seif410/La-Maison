package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Adapter;

import info.info;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context) {
        super(context, info.DATABASE_NAME, null, info.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(id integer primary key," +
                "fname text,lname text,pass text,email text,birthdate text)");
        sqLiteDatabase.execSQL("create table cart(itemid integer primary key," +
                "itemname text,price integer,userid integer,FOREIGN KEY(userid) REFERENCES user(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        sqLiteDatabase.execSQL("drop table if exists cart");
        onCreate(sqLiteDatabase);
    }

    public void adduser(String fn, String ln, String pw, String email, String bd) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("fname", fn);
        data.put("lname", ln);
        data.put("pass", pw);
        data.put("email", email);
        data.put("birthdate", bd);
        db.insert("users", null, data);
        db.close();
    }

    public String CheckLogin(String email, String password) {
        SQLiteDatabase dbs = getReadableDatabase();
        Cursor data = dbs.query("users", new String[]{"id", "email", "pass"}, "email" + "=" + "'" + email + "'" + "AND " + "pass" +
                "=" + "'" + password + "'", null, null, null, null, null);
        data.moveToFirst();
        dbs.close();
        return data.getString(0);


    }

    public void AddtoCart(String userid, String item_name, String price) {
        SQLiteDatabase dbb = getWritableDatabase();
        ContentValues da = new ContentValues();
        da.put("itemname", item_name);
        da.put("price", price);
        da.put("userid", userid);
        dbb.insert("cart", null, da);
        dbb.close();
    }

    public Cursor getdata(String id) {
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM cart where userid=" + id, null);
        return cursor;
    }

    public void CheckoutCart(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "userid='" + id + "'", null);
        db.close();
    }

    public void DeleteItem(String id, String itemname) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "userid='" + id + "'" + " and itemname='" +
                itemname + "'", null);
        db.close();
    }

    public Cursor getuserdata(String id) {
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM users where id=" + id, null);
        return cursor;
    }
}
