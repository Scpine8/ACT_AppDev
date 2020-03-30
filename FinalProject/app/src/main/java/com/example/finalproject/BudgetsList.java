package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class BudgetsList extends AppCompatActivity {
    LightSensor lightSensor;
    SimpleCursorAdapter simpleCursorAdapter;
    ListView bList;
    Cursor cursor;
//    DBManager dbManager;
    Intent intent;
    Button eraseDBBtn, addBudgetBtn;
    static boolean visited = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_list);

        eraseDBBtn = findViewById(R.id.eraseDBBtn);
        addBudgetBtn = findViewById(R.id.addBudgetBtn);

//        dbManager=new DBManager(getApplicationContext());
//        cursor= dbManager.showdata();
        BudgetData.connectToDB(getApplicationContext());
        cursor= BudgetData.dbManager.showdata();

        bList = findViewById(R.id.bList);
//
//        if (!visited) {
//            Budget b = new Budget("Food", 100);
////            dbManager.insertBudget(b);
//            BudgetData.dbManager.addBudget("BUDGET", b);
//            visited = true;
//        }

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
                Cursor cursorUser = (Cursor)bList.getItemAtPosition(position);
                int budgetID = cursorUser.getInt(cursorUser.getColumnIndex("_id"));
                String budgetName = cursorUser.getString(cursorUser.getColumnIndex("NAME"));
                int budgetMax = cursorUser.getInt(cursorUser.getColumnIndex("MAX"));
                int budgetBalance = cursorUser.getInt(cursorUser.getColumnIndex("BALANCE"));

                // Pass the budget data to ViewBudget
                intent = new Intent(BudgetsList.this, ViewBudget.class);
                intent.putExtra("id", budgetID);
                intent.putExtra("name", budgetName);
                intent.putExtra("max", budgetMax);
                intent.putExtra("balance", budgetBalance);

                startActivity(intent);
            }
        });

        eraseDBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dbManager.eraseDB();
                BudgetData.dbManager.eraseDB();
                refreshCursor();
            }
        });

        addBudgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(BudgetsList.this, AddBudget.class);
                startActivity(intent);
            }
        });


    }

    public void refreshCursor() {

        simpleCursorAdapter.notifyDataSetChanged();

        finish();
        startActivity(getIntent());
    }
}
