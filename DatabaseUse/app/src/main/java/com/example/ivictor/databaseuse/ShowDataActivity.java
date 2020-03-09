package com.example.ivictor.databaseuse;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ShowDataActivity extends AppCompatActivity {
ListView list;
SimpleCursorAdapter simpleCursorAdapter;
Cursor cursor;
DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        list=findViewById(R.id.list);
        databaseManager=new DatabaseManager(getApplicationContext());
        cursor= databaseManager.showdata();

        simpleCursorAdapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.adapterlayout,cursor,new String[]{"NAME","EMAIL"},new int[]{R.id.name,R.id.email});
        list.setAdapter(simpleCursorAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Cursor cursorUser = (Cursor)list.getItemAtPosition(position);
                String username = cursorUser.getString(cursorUser.getColumnIndex("NAME"));
                String useremail = cursorUser.getString(cursorUser.getColumnIndex("EMAIL"));

                Toast.makeText(getApplicationContext(),username, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowDataActivity.this, ShowUserDataActivity.class);

                intent.putExtra("username", username);
                intent.putExtra("email", useremail);

                startActivity(intent);
            }
        });

   list.setAdapter(simpleCursorAdapter);
    }
}
