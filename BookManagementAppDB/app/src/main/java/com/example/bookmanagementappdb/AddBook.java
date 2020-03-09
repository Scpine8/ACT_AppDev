package com.example.bookmanagementappdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBook extends AppCompatActivity {
    EditText inputTitle;
    EditText inputAuthor;
    Button addBookbtn;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        inputTitle = findViewById(R.id.inputTitle);
        inputAuthor = findViewById(R.id.inputAuthor);
        addBookbtn = findViewById(R.id.addBookbtn);

        dbManager = new DBManager(this);

        addBookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
            }
        });
    }


    public void addBook() {
        String title = inputTitle.getText().toString();
        String author = inputAuthor.getText().toString();

        if (!title.equals("") && !author.equals("")) {
            dbManager.insertBook(title, author);
        }
    }
}
