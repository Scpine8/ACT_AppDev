package com.example.techgadgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShowTechGadget extends AppCompatActivity {
    Intent intent;
    Bundle bundle;
    ImageView cover;
    Button viewBtn;
    Button backBtn;
    TechGadget currentGadget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_techgadget);

        intent = getIntent();
        bundle = new Bundle(intent.getExtras());
        cover=findViewById(R.id.cover);
        viewBtn=findViewById(R.id.viewBtn);
        backBtn=findViewById(R.id.backBtn);

        int passedPos = bundle.getInt("gadget");
        currentGadget = TechGadgetData.techGadgets.get(passedPos);
        int gadgetImg = currentGadget.getImage();
        final String gadgetURL = currentGadget.getUrl();

        // Set Image
        cover.setImageResource(gadgetImg);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowTechGadget.this, MainActivity.class);
                startActivity(intent);
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gadgetURL));
                startActivity(urlIntent);
            }
        });



    }
}
