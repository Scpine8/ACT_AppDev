package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> myData = new ArrayList<>();
    ListView listView;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        myData.add("Option 1");
        myData.add("Option 2");
        myData.add("Option 3");
        myData.add("Option 4");
        myData.add("Option 5");



        arrayAdapter=new ArrayAdapter(getApplicationContext(), R.layout.adapter_layout, R.id.tview1, myData);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = listView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), selectedItem,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
