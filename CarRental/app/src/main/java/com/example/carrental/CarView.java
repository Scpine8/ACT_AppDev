package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CarView extends AppCompatActivity {
    TextView title;
    ImageView cover;
    TextView price;
    TextView description;
    Bundle bundle;
    Intent intent;
    Car currentCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_view);

        title=findViewById(R.id.title);
        cover=findViewById(R.id.coverImg);
        price=findViewById(R.id.price);
        description=findViewById(R.id.description);

        intent=getIntent();
        bundle=intent.getExtras();

        int car = bundle.getInt("car");

        // get selected car
        currentCar=CarData.cars.get(car);

        // configure view based on car
        title.setText(currentCar.getName());
        cover.setImageResource(currentCar.getImg());
        String carPrice = Integer.toString(currentCar.getDailyPrice());
        price.setText(carPrice+" Euros");
        description.setText(currentCar.getDescription());





    }
}
