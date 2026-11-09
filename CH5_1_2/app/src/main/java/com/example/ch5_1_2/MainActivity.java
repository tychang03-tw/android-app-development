package com.example.ch5_1_2;

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
    RadioGroup unit;
    EditText value;
    TextView degF;
    TextView degC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        unit = (RadioGroup) findViewById(R.id.unit);
        unit.setOnCheckedChangeListener(this);

        value = (EditText) findViewById(R.id.value);
        value.addTextChangedListener(this);

        degF =(TextView) findViewById(R.id.degF);
        degC =(TextView) findViewById(R.id.degC);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        calc();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calc();
    }
    protected void calc(){
        double val,f,c;
        String str = value.getText().toString();
        try{
            val = Double.parseDouble(str);
        }catch(Exception e){
            val = 0;
        }

        if(unit.getCheckedRadioButtonId()==R.id.unitF){
            f = val;
            c = (f-32)*5/9;
        }else{
            c = val;
            f = c*9/5+32;
        }
        degC.setText(String.format("%.1f",c) + getResources().getString(R.string.charC));
        degF.setText(String.format("%.1f",f) + getResources().getString(R.string.charF));
    }
}