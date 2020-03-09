package com.example.bookmanagementappdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView title;
    ImageView coverIMG;
    Button viewBooks, addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        coverIMG=findViewById(R.id.coverIMG);
        viewBooks=findViewById(R.id.viewBooks);
        addBook=findViewById(R.id.addBook);






    }
}
