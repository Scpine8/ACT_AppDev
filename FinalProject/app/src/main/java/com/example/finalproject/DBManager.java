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
        db.execSQL("CREATE TABLE BUDGET ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "BALANCE INTEGER,"
                + "MAX INTEGER);");


    }
    public SQLiteDatabase open(){
        SQLiteDatabase db=getWritableDatabase();
        return db;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertBudget(Budget budget){

        SQLiteDatabase db=open();

        ContentValues budgetValues = new ContentValues();

        budgetValues.put("NAME", budget.getName());
        budgetValues.put("BALANCE", budget.getBalance());
        budgetValues.put("MAX", budget.getMax());

        db.insert("BUDGET",null,budgetValues);
    }

    public void eraseDB() {
        SQLiteDatabase db=open();
        db.delete("BUDGET", null, null);
    }

    public Cursor showdata(){
        SQLiteDatabase db=open();
        Cursor cursor=   db.query("BUDGET",new String[]{"_id","NAME","BALANCE"},null,null,null,null,null);
        return cursor;

    /*cursor.moveToFirst();

    while(!cursor.isAfterLast()){
        Log.v("sql",cursor.getString(cursor.getColumnIndex("NAME")));
        Log.v("sql",cursor.getString(cursor.getColumnIndex("EMAIL")));

        cursor.moveToNext();
    }*/

    }
}
