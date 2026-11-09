package com.example.ch5_1_hw;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    RadioGroup pound1,pound2;
    EditText enterPrice,enterPound;
    TextView money1,money2,last1,last2,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pound1 = (RadioGroup) findViewById(R.id.pound1);
        pound2 = (RadioGroup) findViewById(R.id.pound2);
        pound1.setOnCheckedChangeListener(this);
        pound2.setOnCheckedChangeListener(this);

        enterPrice = (EditText) findViewById(R.id.enterPrice);
        enterPrice.addTextChangedListener(this);

        enterPound = (EditText) findViewById(R.id.enterPound);
        enterPound.addTextChangedListener(this);

        money1 =(TextView) findViewById(R.id.money1);
        money2 =(TextView) findViewById(R.id.money2);

        last1 =(TextView) findViewById(R.id.last1);
        last2 =(TextView) findViewById(R.id.last2);

        total =(TextView) findViewById(R.id.total);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
    @Override
    public void afterTextChanged(Editable s) {
        calc();
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calc();
    }

    protected void calc(){
        double val1,val2,chinP,konchinP,chinW,konchinW,t;
        String str1 =  enterPrice.getText().toString();
        try{
            val1 = Double.parseDouble(str1);
        }catch(Exception e){
            val1 = 0;
        }
        String str2 =  enterPound.getText().toString();
        try{
            val2 = Double.parseDouble(str2);
        }catch(Exception e){
            val2 = 0;
        }
        if(pound1.getCheckedRadioButtonId()==R.id.a){
            if(pound2.getCheckedRadioButtonId()==R.id.c){
                chinP = val1;
                konchinP = val1/0.6;
                chinW = val2;
                konchinW = val2*0.6;
                t = chinP * chinW;
            }else{
                chinP = val1;
                konchinP = val1/0.6;
                konchinW =  val2;
                chinW = val2/0.6;
                t = chinP * chinW;
            }
            money1.setText(String.format("每斤價錢 : "+"%.1f",chinP));
            money2.setText(String.format("每公斤價錢: "+"%.1f",konchinP));
            last1.setText(String.format("%.1f",chinW) + "斤");
            last2.setText(String.format("%.1f", konchinW) + "公斤");
            total.setText(String.format("總共"+"%.1f", t) + "元");
        }
        else if(pound1.getCheckedRadioButtonId()==R.id.b){
            if(pound2.getCheckedRadioButtonId()==R.id.c){
                konchinP = val1;
                chinP = val1*0.6;
                chinW = val2;
                konchinW = val2*0.6;
                t = chinP * chinW;
            }else{
                konchinP = val1;
                chinP = val1*0.6;
                konchinW =  val2;
                chinW = val2/0.6;
                t = chinP * chinW;
            }
            money1.setText(String.format("每斤價錢 : "+"%.1f",chinP));
            money2.setText(String.format("每公斤價錢 : "+"%.1f",konchinP));
            last1.setText(String.format("%.1f",chinW) + "斤");
            last2.setText(String.format("%.1f", konchinW) + "公斤");
            total.setText(String.format("總共"+"%.1f", t) + "元");
        }
    }
}