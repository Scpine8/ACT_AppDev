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

public class AddTransaction extends AppCompatActivity implements HandleBudget {
    Button addBtn, cancelBtn;
    EditText insertAmount, insertDesc;
    TextView viewBudget;
    Transaction newTransaction;
    Intent intent;
    Bundle bundle;
    int budgetID;
    int oldBalance;
    String budgetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        intent = getIntent();
        bundle = intent.getExtras();
        budgetID = bundle.getInt("id");
        oldBalance = bundle.getInt("balance");
        budgetName = bundle.getString("budgetName");

        addBtn = findViewById(R.id.addBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
        insertDesc = findViewById(R.id.insertDesc);
        insertAmount = findViewById(R.id.insertAmount);
        viewBudget=findViewById(R.id.viewBudget);
        viewBudget.setText(budgetName);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okayToSubmit(insertDesc, insertAmount)) {
                    // create newBudget object based on inputs
                    newTransaction = new Transaction(budgetID, insertDesc.getText().toString(), Integer.parseInt(insertAmount.getText().toString()));

                    // add newBudget object to the database
                    BudgetData.dbManager.addTransaction("TRANSACTION", newTransaction, oldBalance);

                    // Toast the user that the budget has been added
                    String message = newTransaction +" has been recorded!";
                    Toast.makeText(AddTransaction.this, message, Toast.LENGTH_LONG).show();

                    // Return to BudgetsList
                    returnToBudgetsList();
                }
            }
        });
    }
    public void returnToBudgetsList() {
        intent = new Intent(AddTransaction.this, BudgetsList.class);
        startActivity(intent);
    }

    public boolean okayToSubmit(EditText insertString, EditText insertInt) {
        int max = -1;

        // try to give the insertMax to b
        try
        {
            max = Integer.parseInt(insertInt.getText().toString());
        } catch (Exception e) {
            Log.v("Budget", "A non-integer was passed to the insertInt EditText");
        }

        return max != -1 && !insertString.getText().toString().equals("");
    }
    // ------------------------------------------------------------------------------------------
}
