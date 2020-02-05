package com.example.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count=0;
    Button btn1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        tv1=findViewById(R.id.tv1);
        tv1.setText(String.valueOf(count));

        if (savedInstanceState != null) {
            count=savedInstanceState.getInt("count");
            tv1.setText(String.valueOf(count));
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tv1.setText(String.valueOf(count));
            }
        });

        Log.v("ActivityLifeCycle", "onCreate Runs!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ActivityLifeCycle", "onStart Runs!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ActivityLifeCycle", "onResume Runs!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("ActivityLifeCycle", "onPause Runs!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ActivityLifeCycle", "onRestart Runs!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ActivityLifeCycle", "onDestroy Runs!");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Saves the value of count in case of app failure
        outState.putInt("count", count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // retrieves value of count from the savedInstanceState
        count=savedInstanceState.getInt("count");
    }
}
