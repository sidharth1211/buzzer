package com.sid.commu.buzzer;

import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    Vibrator v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        boolean clicked=false;

        //my button clic
        button = (Button)findViewById(R.id.button);
        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        final long[] pattern={1000,2000};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //change boolean value
                clicked=true;
            }
        });


        if((distance(lat1,lon1,lat2,lon2)<0.01)&&clicked==false)
        {


                v.vibrate(pattern,0);

                button.setVisibility(View.VISIBLE);

        }
        if(clicked==true)
        {
            v.cancel();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
