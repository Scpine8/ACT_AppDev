package com.example.bookfinder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Books extends AppCompatActivity {

    ListView bookList;
    ArrayAdapter<Book> arrayAdapter;
    Button sortBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        BookData.getData();

        bookList = findViewById(R.id.bookList);
        sortBtn = findViewById(R.id.sortBtn);

        arrayAdapter=new ArrayAdapter<Book>(this, R.layout.show_books, R.id.booksTextView, BookData.books);

        bookList.setAdapter(arrayAdapter);

        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(Books.this, BookView.class);
                intent.putExtra("book", position);
                startActivity(intent);
            }
        });

        sortBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                BookData.sortData();
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
