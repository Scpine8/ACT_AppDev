package com.example.bookfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookView extends AppCompatActivity {

    ImageView bookCover;
    TextView bookDesc;
    Button moreBtn;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        bookCover=findViewById(R.id.bookCover);
        bookDesc=findViewById(R.id.bookDesc);
        moreBtn=findViewById(R.id.moreBtn);

        intent = getIntent();
        bundle = intent.getExtras();

        int bookPos = bundle.getInt("book");
        final Book curBook = BookData.books.get(bookPos);

        bookCover.setImageResource(curBook.getImg());
        bookDesc.setText(curBook.getDesc());

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookUrl = curBook.getLink();

                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(bookUrl));
                startActivity(urlIntent);
            }
        });

    }
}
