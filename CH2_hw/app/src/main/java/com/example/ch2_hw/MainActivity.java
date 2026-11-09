package com.example.ch2_hw;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView Txv;
    EditText Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Txv = (TextView) findViewById(R.id.txv);
        Name = (EditText) findViewById(R.id.name);
    }
    int size = 22;
    public void bigger(View v){
        Txv.setTextSize(++size);}
    public void smaller(View v){
        Txv.setTextSize(--size);}
    public void sayHello(View v){
        Txv.setText(Name.getText().toString()+"您好");}
}
