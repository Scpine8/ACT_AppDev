package com.example.techgadgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lView;
    ArrayList<String> gadgets = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lView=findViewById(R.id.lView);
        gadgets.add("Gadget 1");
        gadgets.add("Gadget 2");
        gadgets.add("Gadget 3");

        arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.activity_main, R.id.lView, gadgets);
        lView.setAdapter(arrayAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent= new Intent(MainActivity.this, GadgetView.class);
                intent.putExtra("gadget", position);
                startActivity(intent);
            }
        });

    }
}
