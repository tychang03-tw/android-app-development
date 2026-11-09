package com.example.ch4_5hw;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView txv = (TextView) findViewById(R.id.txv);
        View main = (View) findViewById(R.id.main);

        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    vb.vibrate(1000);
                    txv.setText("七彩霓虹燈\n   震動中");
                    txv.setTextSize(60);
                }
                else if(event.getAction()==MotionEvent.ACTION_MOVE){
                    vb.vibrate(1000);
                    txv.setText("七彩霓虹燈\n   震動中");
                    txv.setTextSize(60);
                    Random x = new Random();
                    int r1 = x.nextInt(256);
                    int g1 = x.nextInt(256);
                    int b1 = x.nextInt(256);
                    txv.setTextColor(Color.rgb(r1, g1, b1));
                    int r2 = x.nextInt(256);
                    int g2 = x.nextInt(256);
                    int b2 = x.nextInt(256);
                    main.setBackgroundColor(Color.rgb(r2, g2, b2));
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    vb.cancel();
                    txv.setText("動霓虹");
                    txv.setTextColor(Color.WHITE);
                    txv.setTextSize(40);
                    main.setBackgroundColor(Color.BLACK);
                }
                return true;
            }
        });
    }
}