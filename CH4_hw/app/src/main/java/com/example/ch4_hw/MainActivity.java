package com.example.ch4_hw;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
public class MainActivity extends AppCompatActivity
        implements OnClickListener , OnLongClickListener {
    TextView txv,txv2,txv3,txv4;
    View main;
    Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txv = (TextView) findViewById(R.id.textView);
        txv2 = (TextView) findViewById(R.id.textView2);
        txv3 = (TextView) findViewById(R.id.textView3);
        txv4 = (TextView) findViewById(R.id.textView4);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        main = findViewById(R.id.main);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
        btn2.setOnClickListener(this);
        btn2.setOnLongClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            main.setBackgroundColor(Color.argb(0,38, 36, 36));
            txv.setTextColor(Color.argb(255,38, 36, 36));
            txv2.setTextColor(Color.argb(0,38, 36, 36));
            txv3.setTextColor(Color.argb(0,38, 36, 36));
            txv4.setTextColor(Color.argb(0,38, 36, 36));
            btn.setTextColor(Color.argb(0,38, 36, 36));
            btn2.setTextColor(Color.argb(255,252, 245, 253));}
        else if (v.getId() == R.id.button2){
            main.setBackgroundColor(Color.argb(255,38, 36, 36));
            txv.setTextColor(Color.argb(0,38, 36, 36));
            txv2.setTextColor(Color.argb(255,252, 245, 253));
            txv3.setTextColor(Color.argb(0,38, 36, 36));
            txv4.setTextColor(Color.argb(0,38, 36, 36));
            btn.setTextColor(Color.argb(255,252, 245, 253));
            btn2.setTextColor(Color.argb(0,38, 36, 36));}}
    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.button){
            Random x = new Random();
            int r = x.nextInt(256);
            int g = x.nextInt(256);
            int b = x.nextInt(256);
            main.setBackgroundColor(Color.rgb(r, g, b));
            txv.setTextColor(Color.rgb(r, g, b));
            txv2.setTextColor(Color.rgb(r, g, b));
            txv3.setTextColor(Color.rgb(r, g, b));
            int r2 = x.nextInt(256);
            int g2 = x.nextInt(256);
            int b2 = x.nextInt(256);
            txv4.setTextColor(Color.rgb(r2, g2, b2));
            btn.setTextColor(Color.argb(0,38, 36, 36));
            btn2.setTextColor(Color.argb(255,252, 245, 253));}
        else if (v.getId() == R.id.button2){
            main.setBackgroundColor(Color.argb(255,38, 36, 36));
            txv.setTextColor(Color.argb(0,38, 36, 36));
            txv2.setTextColor(Color.argb(0,38, 36, 36));
            txv3.setTextColor(Color.argb(255,252, 245, 253));
            txv4.setTextColor(Color.argb(0,38, 36, 36));
            btn.setTextColor(Color.argb(255,252, 245, 253));
            btn2.setTextColor(Color.argb(0,38, 36, 36));}
        return true;}}