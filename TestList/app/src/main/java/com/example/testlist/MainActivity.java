package com.example.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> foods = new ArrayList<>();
    ListView lView;
    ArrayAdapter arrayAdapter;
    Button btn;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lView=findViewById(R.id.lView);
        foods.add("pizza");
        foods.add("pork");
        foods.add("pie");

        arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.adapter_layout, R.id.tView, foods);
        lView.setAdapter(arrayAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemText = lView.getItemAtPosition(position).toString();
                foods.remove(position);
                Toast.makeText(MainActivity.this, itemText, Toast.LENGTH_SHORT).show();
                arrayAdapter.notifyDataSetChanged();
            }
        });
        btn=findViewById(R.id.btn);
        edit=findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable editText = edit.getText();
                if (editText != null) {
                    foods.add(editText.toString());
                    edit.setText("");
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
