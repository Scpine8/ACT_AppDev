package com.example.finalproject;

import androidx.annotation.NonNull;

public class Transaction {
    private int __budgetID;
    private String __description;
    private int __amount;

    public Transaction (int budgetID, String description, int amount) {
        this.__budgetID = budgetID;
        this.__description = description;
        this.__amount = amount;
    }

    public int getBudgetID() {
        return __budgetID;
    }

    public void setBudgetID(int budgetID) {
        this.__budgetID = budgetID;
    }

    public String getDescription() {
        return __description;
    }

    public void setDescription(String description) {
        this.__description = description;
    }

    public int getAmount() {
        return __amount;
    }

    public void setAmount(int amount) {
        this.__amount = amount;
    }
}