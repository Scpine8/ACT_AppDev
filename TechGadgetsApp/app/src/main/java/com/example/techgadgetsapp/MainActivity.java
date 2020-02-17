package com.example.techgadgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lView;
//    ArrayList<TechGadget> gadgets = new ArrayList<>();
    ArrayAdapter<TechGadget> arrayAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lView=findViewById(R.id.lView);

//        gadgets.add("Gadget 1");
//        gadgets.add("Gadget 2");
//        gadgets.add("Gadget 3");

        // Fill TechData:
        TechGadgetData.addData();

        arrayAdapter = new ArrayAdapter<TechGadget>(this, R.layout.show_gadgets, R.id.gadgets, TechGadgetData.techGadgets);
        lView.setAdapter(arrayAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent= new Intent(MainActivity.this, ShowTechGadget.class);
                intent.putExtra("gadget", position);
                startActivity(intent);
            }
        });

    }
}
