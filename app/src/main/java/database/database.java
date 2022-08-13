package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import info.info;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context) {
        super(context, info.DATABASE_NAME, null, info.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(id integer primary key," +
                "fname text,lname text,pass text,email text,birthdate text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }

    public void adduser(String fn, String ln, String pw, String email, String bd) {
        ContentValues data = new ContentValues();
        data.put("fname", fn);
        data.put("lname", ln);
        data.put("pass", pw);
        data.put("email", email);
        data.put("birthdate", bd);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, data);
        db.close();
    }

    public Boolean test(String email, String password) {
        SQLiteDatabase dbs = getReadableDatabase();
        Cursor hehe = dbs.query("users", new String[]{"email", "pass"}, "email" + "=" + "'" + email + "'" + "AND " + "pass" +
                "=" + "'" + password + "'", null, null, null, null, null);
        if (hehe.moveToFirst()) {
            return true;
        }
        return false;
    }
}
