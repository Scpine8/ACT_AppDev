package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;

import java.util.ArrayList;
import java.util.List;

public class AllRecipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipes);

        // Configure Recipe Data
        // (1) Beef Wellington



        String wellington_title = "Beef Wellington";
        String wellington_img_src = "@drawable/beefwellington";
        String wellington_desc = getString(R.string.wellington_desc);

        ArrayList<String> wellington = [wellington_title, wellington_img_src, wellington_desc];


    }
}
