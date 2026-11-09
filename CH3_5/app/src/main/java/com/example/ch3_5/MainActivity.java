package com.example.ch3_5;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    TextView txvR, txvG, txvB;
    View colorBlock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txvR = (TextView) findViewById(R.id.txvR);
        txvG = (TextView) findViewById(R.id.txvG);
        txvB = (TextView) findViewById(R.id.txvB);
        colorBlock = findViewById(R.id.colorBlock);}
    public void changeColor(View v){
        Random x = new Random(); //取得亂數物件，產生亂數值
        int red = x.nextInt(256); //取0~255之間的亂數
        txvR.setText("紅:" + red);
        txvR.setTextColor(Color.rgb(red, 0, 0));
        int green = x.nextInt(256); //"再"取0~255之間的亂數
        txvG.setText("綠:" + green);
        txvG.setTextColor(Color.rgb(0, green, 0));
        int blue = x.nextInt(256); //"再"取0~255之間的亂數
        txvB.setText("藍:" + blue);
        txvB.setTextColor(Color.rgb(0, 0, blue));
        colorBlock.setBackgroundColor(Color.rgb(red, green, blue));}}
