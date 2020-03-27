package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleCursorAdapter;

public class BudgetsList extends AppCompatActivity {
    SimpleCursorAdapter simpleCursorAdapter;
    ListView bList;
    Cursor cursor;
    DBManager dbManager;
    static boolean visited = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgets);


        dbManager=new DBManager(getApplicationContext());
        cursor= dbManager.showdata();

        bList = findViewById(R.id.bList);

        if (!visited) {
            dbManager.insertBudget("Food", 100);
            dbManager.insertBudget("Travel", 50);
            dbManager.insertBudget("Mortgage", 200);
            visited = true;
        }

        // change the data
        // make a new query
        // reconnect cursor to adapter
        // simpleCursorAdapter.notifyDataSetChanged()




        simpleCursorAdapter = new SimpleCursorAdapter(
                getApplicationContext(), R.layout.budgetsadapter, cursor,
                new String[]{"NAME", "BALANCE"}, new int[]{R.id.bName, R.id.bBalance});

        bList.setAdapter(simpleCursorAdapter);



        bList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
}
