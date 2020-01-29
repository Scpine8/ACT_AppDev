package com.example.intentscourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String x= bundle.getString(Intent.EXTRA_TEXT);
        Toast.makeText(getApplicationContext(),x,Toast.LENGTH_LONG).show();
    }
}
