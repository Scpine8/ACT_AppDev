package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ViewBudget extends AppCompatActivity {
    EditText insertName, insertMax, insertBalance;
    Button updateBtn, backBtn, deleteBtn;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_budget);


    }

    private void getBudgetData() {

    }
}
