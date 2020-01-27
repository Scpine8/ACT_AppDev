package com.example.radioactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton rb1;
    RadioButton rb2;
    CheckBox cbox1;
    RatingBar rt1;
    Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1=findViewById(R.id.rg1);
        btn1=findViewById(R.id.btn1);
        cbox1=findViewById(R.id.cbox1);
        rt1=findViewById(R.id.rt1);

        // Handle Btn1 Clicks:

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadioBtn = rg1.getCheckedRadioButtonId();
                rb1 = findViewById(checkedRadioBtn);
                if (rb1!=null) {
                    Toast.makeText(MainActivity.this, rb1.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle RG1 selection changes:

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb1 = findViewById(checkedId);
                if (rb1!=null) {
                    Toast.makeText(MainActivity.this, rb1.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Handle check boxes:
        cbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Checkbox is Checked!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle ratings bar changes:
        rt1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               
            }
        });
    }
}
