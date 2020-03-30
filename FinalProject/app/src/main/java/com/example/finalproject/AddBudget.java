package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBudget extends AppCompatActivity implements HandleBudget {
    Button addBtn, cancelBtn;
    EditText insertName, insertMax;
    Budget newBudget;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        addBtn = findViewById(R.id.addBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
        insertName = findViewById(R.id.insertName);
        insertMax = findViewById(R.id.insertMax);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okayToSubmit(insertName, insertMax)) {
                    // create newBudget object based on inputs
                    newBudget = new Budget(insertName.getText().toString(), Integer.parseInt(insertMax.getText().toString()));

                    // add newBudget object to the database
                    BudgetData.dbManager.addBudget("BUDGET", newBudget);

                    // Toast the user that the budget has been added
                    String message = newBudget +" has been added to the Budget Database!";
                    Toast.makeText(AddBudget.this, message, Toast.LENGTH_LONG).show();

                    // Return to BudgetsList
                    returnToBudgetsList();
                }
            }
        });
    }
    public void returnToBudgetsList() {
        intent = new Intent(AddBudget.this, BudgetsList.class);
        startActivity(intent);
    }

    public boolean okayToSubmit(EditText insertName, EditText insertMax) {
        int max = -1;

        // try to give the insertMax to b
        try
        {
            max = Integer.parseInt(insertMax.getText().toString());
        } catch (Exception e) {
            Log.v("Budget", "A non-integer was passed to the insertMax EditText");
        }

        return max != -1 && !insertName.getText().toString().equals("");
    }
    // ------------------------------------------------------------------------------------------
}
