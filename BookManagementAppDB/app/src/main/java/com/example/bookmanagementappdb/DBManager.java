package com.example.bookmanagementappdb;

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
        db.execSQL("CREATE TABLE BOOK ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "TITLE TEXT, "
                + "AUTHOR TEXT);");


    }
    public SQLiteDatabase open(){
        SQLiteDatabase db=getWritableDatabase();
        return db;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertBook(String title, String author) {
        SQLiteDatabase db=open();
        ContentValues bookvalues=new ContentValues();
        bookvalues.put("TITLE",title);
        bookvalues.put("AUTHOR",author);
        db.insert("BOOK",null,bookvalues);
    }


    public void insertdata(){

        SQLiteDatabase db=open();
        ContentValues bookvalues=new ContentValues();
        bookvalues.put("TITLE","The Great Gatsby");
        bookvalues.put("AUTHOR","F. Scott Fitzgerald");
        db.insert("BOOK",null,bookvalues);
        bookvalues.put("TITLE","Green Eggs and Ham");
        bookvalues.put("AUTHOR","Dr. Seuss");
        db.insert("BOOK",null,bookvalues);
    }

    public Cursor showdata(){
        SQLiteDatabase db=open();
        Cursor cursor=   db.query("BOOK",new String[]{"_id","TITLE","AUTHOR"},null,null,null,null,null);
        return cursor;

    /*cursor.moveToFirst();

    while(!cursor.isAfterLast()){
        Log.v("sql",cursor.getString(cursor.getColumnIndex("NAME")));
        Log.v("sql",cursor.getString(cursor.getColumnIndex("EMAIL")));

        cursor.moveToNext();
    }*/

    }
}
