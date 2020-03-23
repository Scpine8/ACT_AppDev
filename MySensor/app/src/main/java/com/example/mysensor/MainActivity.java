package com.example.mysensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor temperatureSensor;
    float temperature;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.txt);
        sensorManager = (SensorManager) getApplicationContext().getSystemService(SENSOR_SERVICE);
//        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE); // can be any sensor
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // whenever a sensor changes, this is called

        // FOR TEMPERATURE:
        temperature = event.values[0];
        txt.setText(String.valueOf(temperature));

        Log.v("temperature",String.valueOf(temperature));

        // FOR ACCELEROMETER

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        Log.v("accelerometer", String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(z));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        // called when app loads
        super.onResume();
        sensorManager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        // anytime app is closed (e.g. sleeping, switched to another app, etc.)
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
