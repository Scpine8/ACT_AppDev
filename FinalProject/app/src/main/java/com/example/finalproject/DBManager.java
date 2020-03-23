package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBManager extends SQLiteOpenHelper{


    public DBManager(Context context) {
        super(context, "MyDB",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "EMAIL TEXT);");


    }
    public SQLiteDatabase open(){
        SQLiteDatabase db=getWritableDatabase();
        return db;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertdata(){

        SQLiteDatabase db=open();
        ContentValues uservalues=new ContentValues();
        uservalues.put("NAME","iosif");
        uservalues.put("EMAIL","iosif");
        db.insert("USER",null,uservalues);
        uservalues.put("NAME","iosif2");
        uservalues.put("EMAIL","@iosif2");
        db.insert("USER",null,uservalues);
    }

    public Cursor showdata(){
        SQLiteDatabase db=open();
        Cursor cursor=   db.query("USER",new String[]{"_id","NAME","EMAIL"},null,null,null,null,null);
        return cursor;

    /*cursor.moveToFirst();

    while(!cursor.isAfterLast()){
        Log.v("sql",cursor.getString(cursor.getColumnIndex("NAME")));
        Log.v("sql",cursor.getString(cursor.getColumnIndex("EMAIL")));

        cursor.moveToNext();
    }*/

    }
}
