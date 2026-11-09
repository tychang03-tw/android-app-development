package com.example.ch8_3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener , DatePickerDialog.OnDateSetListener {
    EditText edtD,edtS;
    Button confirm,cancel;
    Calendar c = Calendar.getInstance();
    TextView txvDDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        txvDDD = (TextView) findViewById(R.id.txvDDD);
        edtD = (EditText) findViewById(R.id.edtD);
        edtS = (EditText) findViewById(R.id.edtS);

        confirm = (Button) findViewById(R.id.confirm);
        cancel = (Button) findViewById(R.id.cancel);

        confirm.setOnClickListener(this);
        cancel.setOnClickListener(this);
        txvDDD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input1 = edtD.getText().toString();
        String input2 = edtS.getText().toString();
        if (v.getId() == R.id.confirm) {
            if (input1.isEmpty()) {
                Snackbar.make(v, "請輸入日期", Snackbar.LENGTH_SHORT).show();
                return;
            }
            if (input2.isEmpty()) {
                Snackbar.make(v, "請輸入金額", Snackbar.LENGTH_SHORT).show();
                return;
            }
            Intent it2 = new Intent();
            it2.putExtra("result1", input1);
            it2.putExtra("result2", input2);
            setResult(RESULT_OK, it2); // 2.result
            finish();
        }
        if(v.getId()==R.id.cancel){
            finish();
        }
        if(v.getId()==R.id.txvDDD){
            new DatePickerDialog(this,this,
                    c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        edtD.setText(year + "/" + (month+1) + "/" + dayOfMonth);
    }
}