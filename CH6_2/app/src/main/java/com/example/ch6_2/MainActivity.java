package com.example.ch6_2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener , TextWatcher {
    TextView txv;
    EditText edtA,edtH,edtM;
    Spinner volts;
    Double V[] = {110.0,220.0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txv = findViewById(R.id.txv);
        edtA = findViewById(R.id.edtA);
        edtH = findViewById(R.id.edtH);
        edtM = findViewById(R.id.edtM);
        volts = findViewById(R.id.volts);

        volts.setOnItemSelectedListener(this);
        edtA.addTextChangedListener(this);
        edtH.addTextChangedListener(this);
        edtM.addTextChangedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        calc();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

    public void calc(){

        String A = edtA.getText().toString();
        String H = edtH.getText().toString();
        String M = edtM.getText().toString();
//        String[] volt = getResources().getStringArray(R.array.volt);
        int index = volts.getSelectedItemPosition();

        if (A.isEmpty() || H.isEmpty() || M.isEmpty()) {
            txv.setText("請輸入完整資訊");
            return;
        }

        try {
            double a = Double.parseDouble(A);
            double h = Double.parseDouble(H);
            double m = Double.parseDouble(M);

            double total = V[index] * a * h * m * 30 / 1000;
            txv.setText("$"+String.format("%.1f", total));

        } catch (Exception e) {
            txv.setText("請輸入完整資訊");
        }
    }

}
