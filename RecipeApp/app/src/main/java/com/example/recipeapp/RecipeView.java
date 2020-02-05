package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class RecipeView extends AppCompatActivity {
    TextView title;
    ImageView recipeIMG;
    TextView description;
    Button videoBtn;
    HashMap<Integer, String> titles = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        title=findViewById(R.id.title);
        recipeIMG=findViewById(R.id.recipeIMG);
        description=findViewById(R.id.description);
        videoBtn=findViewById(R.id.videoBtn);



    }


}
