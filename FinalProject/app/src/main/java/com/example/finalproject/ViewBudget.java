package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewBudget extends AppCompatActivity implements HandleBudget {
    EditText insertName, insertMax;
    TextView viewBalance, title;
    Button updateBtn, backBtn, deleteBtn, addTransaction;
    Intent intent;
    Bundle bundle;
    Budget curBudget;
    int budgetID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_budget);

        title=findViewById(R.id.title);

        insertName=findViewById(R.id.insertName);
        insertMax=findViewById(R.id.insertMax);
        viewBalance=findViewById(R.id.viewBalance);

        updateBtn=findViewById(R.id.updateBtn);
        backBtn=findViewById(R.id.backBtn);
        deleteBtn=findViewById(R.id.deleteBtn);
        addTransaction=findViewById(R.id.addTransaction);

        // (1) create Budget object (curBudget) from bundle
        setBudget();

        // (2) input data from curBudget
        inputDataFromBudget();

        // (3) Configure onClickListeners

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okayToSubmit(insertName, insertMax)) {
                    // update local Budget object (curBudget)
                    updateCurBudget();
                    // update database
                    BudgetData.dbManager.updateBudgetById("BUDGET", budgetID, curBudget);
                    // Toast success
                    Toast.makeText(getApplicationContext(), "Updated "+curBudget+"!", Toast.LENGTH_LONG).show();

                    // go back
                    returnToBudgetsList();
                    Log.v("UPDATE_BUDGET", "OKAY TO SUBMIT");
                } else {
                    Log.v("UPDATE_BUDGET", "NOT OKAY TO SUBMIT");
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToBudgetsList();
            }
        });

        addTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ViewBudget.this, AddTransaction.class);
                intent.putExtra("id", budgetID);
                intent.putExtra("balance", curBudget.getBalance());
                intent.putExtra("budgetName", curBudget.getName());
                startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete budget from database
                BudgetData.dbManager.deleteById("BUDGET", budgetID);
                // Go back to BudgetsList
                returnToBudgetsList();
            }
        });

    }

    private void setBudget() {
        intent = getIntent();
        bundle = intent.getExtras();

        int id = bundle.getInt("id");
        String name = bundle.getString("name");
        int max = bundle.getInt("max");
        int balance = bundle.getInt("balance");

        budgetID = id;
        curBudget = new Budget(name, max);
        curBudget.setBalance(balance);

        Log.v("curBudget", String.valueOf(budgetID));
        Log.v("curBudget", curBudget.getName());
        Log.v("curBudget", String.valueOf(curBudget.getMax()));
        Log.v("curBudget", String.valueOf(curBudget.getBalance()));

    }

    public void inputDataFromBudget() {
        title.setText(curBudget.getName());
        insertName.setText(curBudget.getName());
        insertMax.setText(String.valueOf(curBudget.getMax()));
        viewBalance.setText(String.valueOf(curBudget.getBalance()));
    }

    public void updateCurBudget() {
        curBudget.setName(insertName.getText().toString());
        curBudget.setMax(Integer.parseInt(insertMax.getText().toString()));
    }

    public void returnToBudgetsList() {
        intent = new Intent(ViewBudget.this, BudgetsList.class);
        startActivity(intent);
    }

    public boolean okayToSubmit(EditText insertString, EditText insertInt) {
        int max = -1;

        // try to give the insertMax to b
        try
        {
            max = Integer.parseInt(insertInt.getText().toString());
        } catch (Exception e) {
            Log.v("Budget", "A non-integer was passed to the insertMax EditText");
            Log.v("Budget", e.toString());
        }

        return max != -1 && insertString.getText().toString() != "";
    }
    // ------------------------------------------------------------------------------------------
}
