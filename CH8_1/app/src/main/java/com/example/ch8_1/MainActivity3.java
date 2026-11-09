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

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        back3 = (Button) findViewById(R.id.back3);
        back3.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(v.getId()==R.id.back3){
            startActivity(new Intent(this,MainActivity2.class));
        }
    }
}