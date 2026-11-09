package com.example.ch8_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt;
    Button btn;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edt = (EditText) findViewById(R.id.edt);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn){
            calc();
        }
    }
    double height = 0;
    double idealWeight = 0;
    void calc() {
        String str = "";
        try {
            height = Double.parseDouble(edt.getText().toString());
        } catch (Exception e) {}
        if (radioGroup.getCheckedRadioButtonId() == R.id.male) {
            idealWeight = (height - 80) * 0.7;
            str = "你是一位男生\n身高為 " + height + "\n標準體重為 " + String.format("%.1f", idealWeight);
        }
        if (radioGroup.getCheckedRadioButtonId() == R.id.female) {
            idealWeight = (height - 70) * 0.6;
            str = "你是一位女生\n身高為 " + height + "\n標準體重為 " + String.format("%.1f", idealWeight);
        }
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", str);
        startActivity(intent);
    }
}