package com.example.finalproject;

import android.widget.EditText;

// This is implemented by the AddBudget, ViewBudget, and ViewTransaction classes
interface HandleBudget {
    boolean okayToSubmit(EditText insertString, EditText insertInt);
}
