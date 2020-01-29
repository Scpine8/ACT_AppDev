package com.example.screenchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.button);
        Intent intent = getIntent();
        Bundle bundle = new Bundle(intent.getExtras());
        int passedNum = bundle.getInt("Extra 1");
        final String out = String.valueOf(passedNum);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                Toast.makeText(MainActivity2.this, out, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
