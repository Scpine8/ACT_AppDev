package com.example.finalproject;

import androidx.annotation.NonNull;

public class Budget {
    private String __name;
    private int __balance;
    private int __max;

    public Budget (String name, int max) {
        this.__name = name;
        this.__balance = 0;
        this.__max = max;
    }

    public String getName() {
        return __name;
    }

    public void setName(String name) {
        this.__name = name;
    }

    public int getBalance() {
        return __balance;
    }

    public void setBalance(int balance) {
        this.__balance = balance;
    }

    public int getMax() {
        return __max;
    }

    public void setMax(int max) {
        this.__max = max;
    }

    @NonNull
    @Override
    public String toString() {
        return this.__name;
    }
}
