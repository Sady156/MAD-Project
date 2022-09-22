package com.example.project12;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        // MyDB.execSQL("create Table doctors(hospitalname TEXT primary key, doctorsname TEXT, speciality TEXT, date TEXT, time TEXT  )");
    }



    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists doctors");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertHospital(String hospitalName,String doctorsName,String speciality,String date,String time){
        SQLiteDatabase MyDB1 = this.getWritableDatabase();
        ContentValues contentValues1= new ContentValues();
        contentValues1.put("hospitalname",hospitalName);
        contentValues1.put("doctorsname",doctorsName);
        contentValues1.put("speciality",speciality);
        contentValues1.put("date",date);
        contentValues1.put("time",time);
        long result = MyDB1.insert("doctors", null, contentValues1);
        if(result==-1) return false;
        else
            return true;


    }



    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}