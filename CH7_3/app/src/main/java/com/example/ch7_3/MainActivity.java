package com.example.ch7_3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Calendar c = Calendar.getInstance();
    TextView txDate;
    TextView txTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txDate = (TextView) findViewById(R.id.textView1);
        txTime = (TextView) findViewById(R.id.textView2);

        txDate.setOnClickListener(this);
        txTime.setOnClickListener(this);

        txDate.setTextColor(Color.RED);
        txTime.setTextColor(Color.RED);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        txDate.setText("您設定的日期為"+ year + "/" + (month+1) + "/" + dayOfMonth);
        txDate.setTextColor(Color.BLUE);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        txTime.setText("您設定的時間為"+ hourOfDay + ":" + minute);
        txTime.setTextColor(Color.BLUE);
    }

    @Override
    public void onClick(View v) {
        if(v==txDate){
            new DatePickerDialog(this,this, c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
        }else if(v==txTime){
            new TimePickerDialog(this,this,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true).show();
        }
    }

}