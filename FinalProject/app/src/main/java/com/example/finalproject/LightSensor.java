package com.example.finalproject;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.SENSOR_SERVICE;

public class LightSensor extends AppCompatActivity implements SensorEventListener{
    SensorManager sMgr;
    TextView lightsensordata;
    Sensor lightsensor;
    RelativeLayout rl;
    float lightvalue=20000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        lightsensordata=findViewById(R.id.lightsensordata);
        rl=findViewById(R.id.rl);
        sMgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        lightsensor = sMgr.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            lightvalue = sensorEvent.values[0];
            lightsensordata.setText(String.valueOf(lightvalue));
            if (lightvalue < 5000) {
                rl.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            } else if (lightvalue < 25000) {
                rl.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                rl.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onPause() {
        super.onPause();
        sMgr.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sMgr.registerListener(this, lightsensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

}
