package com.example.ivictor.databaseuse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowUserDataActivity extends AppCompatActivity {
    TextView name,email;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_data);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);

        bundle=getIntent().getExtras();
        String username=bundle.getString("NAME");
        String useremail=bundle.getString("EMAIL");

        name.setText(username);
        email.setText(useremail);
    }
}
