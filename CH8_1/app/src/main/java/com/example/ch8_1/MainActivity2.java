package com.example.ch8_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button demo,ee,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        demo = (Button) findViewById(R.id.demo);
        ee = (Button) findViewById(R.id.ee);
        back = (Button) findViewById(R.id.back);
        demo.setOnClickListener(this);
        ee.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.demo){
            startActivity(new Intent(this,MainActivity3.class));
        }
        if(v.getId()==R.id.ee){
            startActivity(new Intent(this,MainActivity4.class));
        }
        if(v.getId()==R.id.back){
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}