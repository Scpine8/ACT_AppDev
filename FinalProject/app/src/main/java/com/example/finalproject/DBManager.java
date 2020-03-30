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
        // SQL Table for Budgets
        db.execSQL("CREATE TABLE BUDGET ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "BALANCE INTEGER,"
                + "MAX INTEGER);");
        // SQL Table for Transactions
        db.execSQL("CREATE TABLE TRANSACTIONS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "BUDGETID INTEGER, "
                + "AMOUNT INTEGER, "
                + "DESCRIPTION TEXT);");

    }
    public SQLiteDatabase open(){
        SQLiteDatabase db=getWritableDatabase();
        return db;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addBudget(String table, Budget budget){

        SQLiteDatabase db=open();

        ContentValues budgetValues = new ContentValues();

        budgetValues.put("NAME", budget.getName());
        budgetValues.put("BALANCE", budget.getBalance());
        budgetValues.put("MAX", budget.getMax());

        db.insert("BUDGET",null,budgetValues);
    }

    public void addTransaction(String table, Transaction transaction, int oldBalance) {

        SQLiteDatabase db=open();

        ContentValues transactionValues = new ContentValues();

        transactionValues.put("BUDGETID", transaction.getBudgetID());
        transactionValues.put("AMOUNT", transaction.getAmount());
        transactionValues.put("DESCRIPTION", transaction.getDescription());

        db.insert("TRANSACTIONS",null,transactionValues);

        updateBalanceByID("BUDGET", transaction.getBudgetID(), oldBalance+transaction.getAmount());
    }

    public void eraseDB() {
        SQLiteDatabase db=open();
        db.delete("BUDGET", null, null);
    }

    public void deleteById(String table, int id) {
        SQLiteDatabase db=open();
        String where = "_id="+String.valueOf(id);
        db.delete(table, where, null);

    }

    public void updateBudgetById(String table, int id, Budget budget) {
        SQLiteDatabase db=open();

        String budgetId = "_id="+String.valueOf(id);

        ContentValues budgetValues = new ContentValues();
        budgetValues.put("NAME", budget.getName());
        budgetValues.put("MAX", budget.getMax());
        budgetValues.put("BALANCE", budget.getBalance());

        db.update(table, budgetValues, budgetId, null);
    }

    public void updateBalanceByID(String table, int id, int newBalance) {
        SQLiteDatabase db=open();

        String budgetId = "_id="+String.valueOf(id);

        ContentValues budgetValues = new ContentValues();
        budgetValues.put("BALANCE", newBalance);

        db.update(table, budgetValues, budgetId, null);
    }

    public Cursor showdata(){
        SQLiteDatabase db=open();
        Cursor cursor=   db.query("BUDGET",new String[]{"_id","NAME","BALANCE", "MAX"},null,null,null,null,null);
        return cursor;

    /*cursor.moveToFirst();

    while(!cursor.isAfterLast()){
        Log.v("sql",cursor.getString(cursor.getColumnIndex("NAME")));
        Log.v("sql",cursor.getString(cursor.getColumnIndex("EMAIL")));

        cursor.moveToNext();
    }*/

    }
}
