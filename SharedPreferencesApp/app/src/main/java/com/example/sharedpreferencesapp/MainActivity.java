package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    EditText usernameInput, passwordInput;
    TextView createAcc;
    SharedPreferences sharedPreferences; // connect to file
    SharedPreferences.Editor editor; // edit file
//    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.loginBtn);
//        editText2=findViewById(R.id.editText2);
        createAcc = findViewById(R.id.createAcc);


        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameInput != null && passwordInput != null) {
                    sharedPreferences = getApplicationContext().getSharedPreferences("LoginData", 0);
                    editor = sharedPreferences.edit();
                    String username = usernameInput.getText().toString();
                    String password = passwordInput.getText().toString();

                    editor.putString(username, password);
                    editor.commit(); // could also be editor.apply()

                    Toast.makeText(MainActivity.this, "Account Created!", Toast.LENGTH_SHORT).show();
                } else {
                    logError();
                }

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameInput != null && passwordInput != null) {
                    sharedPreferences = getApplicationContext().getSharedPreferences("LoginData", 0);
                    String username = usernameInput.getText().toString();
                    String password = passwordInput.getText().toString();

                    String account = sharedPreferences.getString(username, null);

                    if (account != null) {
                        Toast.makeText(MainActivity.this, "Login Successful for " + username + "!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Credentials do not exist", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    logError();
                }

            }
        });

    }

    public void logError() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }


}
