package com.example.intentscourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"sakias");
                Intent choosenintent=Intent.createChooser(intent,Intent.ACTION_SEND);
          startActivity(choosenintent);
          /* email example
String email="viktorat85@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "message");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Helloo");

                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));*/
            }
        });
    }
}
