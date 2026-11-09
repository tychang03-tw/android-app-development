package com.example.ch4_5;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView txv = (TextView) findViewById(R.id.txv);

        txv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    vb.vibrate(5000);
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    vb.cancel();
                }
                return true;
            }
        });
    }
}













