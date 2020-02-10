package com.example.techgadgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class GadgetView extends AppCompatActivity {
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadget_view);

        intent = getIntent();
        bundle = new Bundle(intent.getExtras());

        int passedPos = bundle.getInt("gadget");



    }
}
