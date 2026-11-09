package com.example.ch3_5_hw;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText Red,Gre,Blu;
    TextView txvR,txvG,txvB;
    View BackG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txvR = (TextView) findViewById(R.id.txvR);
        txvG = (TextView) findViewById(R.id.txvG);
        txvB = (TextView) findViewById(R.id.txvB);
        Red = (EditText) findViewById(R.id.Red);
        Blu = (EditText) findViewById(R.id.Blu);
        Gre = (EditText) findViewById(R.id.Gre);
        BackG = findViewById(R.id.BackG);}
    public void changeWord(View v) {
        // 取得使用者輸入的 RGB 數值
        int red = Integer.parseInt(Red.getText().toString());
        int green = Integer.parseInt(Gre.getText().toString());
        int blue = Integer.parseInt(Blu.getText().toString());
        txvR.setTextColor(Color.rgb(red, green, blue));
        txvG.setTextColor(Color.rgb(red, green, blue));
        txvB.setTextColor(Color.rgb(red, green, blue));}
    public void changeBack(View v) { // 取得使用者輸入的 RGB 數值
        int red = Integer.parseInt(Red.getText().toString());
        int green = Integer.parseInt(Gre.getText().toString());
        int blue = Integer.parseInt(Blu.getText().toString());
        BackG.setBackgroundColor(Color.rgb(red, green, blue));}
    public void changeRand(View v) {
        Random x = new Random();
        int red = x.nextInt(256);
        txvR.setTextColor(Color.rgb(red, 0, 0));
        int green = x.nextInt(256);
        txvG.setTextColor(Color.rgb(0, green, 0));
        int blue = x.nextInt(256);
        txvB.setTextColor(Color.rgb(0, 0, blue));

        int red1 = x.nextInt(256);
        txvR.setTextColor(Color.rgb(red, 0, 0));
        int green1 = x.nextInt(256);
        txvG.setTextColor(Color.rgb(0, green, 0));
        int blue1 = x.nextInt(256);
        txvB.setTextColor(Color.rgb(0, 0, blue));

        int red2 = x.nextInt(256);
        txvR.setTextColor(Color.rgb(red, 0, 0));
        int green2 = x.nextInt(256);
        txvG.setTextColor(Color.rgb(0, green, 0));
        int blue2 = x.nextInt(256);
        txvB.setTextColor(Color.rgb(0, 0, blue));

        int red3 = x.nextInt(256);
        txvR.setTextColor(Color.rgb(red, 0, 0));
        int green3 = x.nextInt(256);
        txvG.setTextColor(Color.rgb(0, green, 0));
        int blue3 = x.nextInt(256);
        txvB.setTextColor(Color.rgb(0, 0, blue));

        txvR.setTextColor(Color.rgb(red, green, blue));
        txvG.setTextColor(Color.rgb(red1, green1, blue1));
        txvB.setTextColor(Color.rgb(red2, green2, blue2));
        BackG.setBackgroundColor(Color.rgb(red3, green3, blue3));}}