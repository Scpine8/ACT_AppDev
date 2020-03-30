package com.example.finalproject;

import android.content.Context;

import java.util.ArrayList;

public class BudgetData {

    public static ArrayList<Budget> budgets = new ArrayList<>();
    public static DBManager dbManager;

    public static void getBudget(int id) {
    }

    public static void connectToDB(Context context) {
        dbManager = new DBManager(context);
    }
}