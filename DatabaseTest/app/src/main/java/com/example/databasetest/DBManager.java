package com.example.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context) {
        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BOOK ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "TITLE TEXT, "
                + "AUTHOR TEXT);");
    }

    public SQLiteDatabase openDB() {
        try {
            SQLiteDatabase db = getWritableDatabase();
            Log.v("sql", "Database opened");
            return db;
        } catch (Exception e) {
            return null;
        }
    }

    public void insertData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TITLE", "My first title");
        contentValues.put("AUTHOR", "My first author");

        SQLiteDatabase db = openDB();

        if (db != null) {
            db.insert("BOOK", null, contentValues);
        }
    }

    public void getData() {
        // connect w db object
        SQLiteDatabase db = openDB();
        // make query
        Cursor cursor = db.query("BOOK", new String[]{"_id", "TITLE", "AUTHOR"}, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            String title = cursor.getString(cursor.getColumnIndex("TITLE"));
            Log.v("TITLE", title);
            cursor.moveToNext();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
