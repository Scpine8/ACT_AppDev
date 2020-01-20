package com.example.travelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btn1;
    TextView txtview1;
    TextView txtview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Playing w connecting java and xml
        btn1 = findViewById(R.id.btn1);
        txtview1 = findViewById(R.id.title);
        txtview2 = findViewById(R.id.baliText);

    }

    public void makeToastBali(View view) {
        // Toast makes a banner display
        Toast.makeText(this.getApplicationContext(), "CLICKED ON BALI", Toast.LENGTH_SHORT).show();
    }
    public void makeToastNY(View view) {
        // Toast makes a banner display
        Toast.makeText(this.getApplicationContext(), "CLICKED ON NEW YORK", Toast.LENGTH_SHORT).show();
    }
    public void makeToastBTN(View view) {
        // Toast makes a banner display
        Toast.makeText(this.getApplicationContext(), "CLICKED ON BUTTON", Toast.LENGTH_SHORT).show();
    }
}
