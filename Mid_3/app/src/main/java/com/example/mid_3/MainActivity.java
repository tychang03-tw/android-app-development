package com.example.mid_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements // (A)
        RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener ,
        View.OnClickListener, View.OnLongClickListener {
    TextView txvS,txvNT,txvC,txvM;
    View InL1;
    Button btn0,btnM;
    int sum = 0;
    int price[] = {150,230,510,620};
    int priceT[] ={0,0,0,0};
    int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};
    RadioGroup currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txvS = (TextView) findViewById(R.id.txvS);
        txvNT = (TextView) findViewById(R.id.txvNT);
        txvC = (TextView) findViewById(R.id.txvC);
        txvM = (TextView) findViewById(R.id.txvM);

        btn0 = (Button) findViewById(R.id.btn0);
        btnM = (Button) findViewById(R.id.btnM);
        InL1 = (View) findViewById(R.id.InL1);
        currency = (RadioGroup) findViewById(R.id.currency);

        // (B)
        btn0.setOnClickListener(this);
        btnM.setOnClickListener(this);
        btn0.setOnLongClickListener(this);
        btnM.setOnLongClickListener(this);
        currency.setOnCheckedChangeListener(this);
        for (int id : chk_id) {
            CheckBox chk = findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        // (C)
        if(v.getId()==R.id.btn0){
            if (count == 0)
                txvS.setText("購物車是空的");
            else
                txvNT.setText("總金額:NTD"+ total);
                txvC.setText("付款金額:NTD");
                txvM.setText(String.valueOf(total));
        }
        if(v.getId()==R.id.btnM){
            InL1.setBackgroundColor(Color.WHITE);
            txvS.setVisibility(View.VISIBLE);
            txvNT.setVisibility(View.VISIBLE);
            txvC.setVisibility(View.VISIBLE);
            txvM.setVisibility(View.VISIBLE);
            currency.setVisibility(View.VISIBLE);
            for (int id : chk_id) {
                CheckBox chk = findViewById(id);
                chk.setVisibility(View.VISIBLE);
            }
            btn0.setText("訂購");
            btnM.setText("長按關閉購物車");
        }
    }
    @Override
    public boolean onLongClick(View v) {
        // (D)
        if(v.getId()== R.id.btn0){
            for (int id : chk_id) {
                CheckBox chk = findViewById(id);
                chk.setChecked(false);
            }
            txvS.setText("購物車是空的");
        }
        if(v.getId() ==  R.id.btnM){
            InL1.setBackgroundColor(Color.BLACK);
            txvS.setVisibility(View.INVISIBLE);
            txvNT.setVisibility(View.INVISIBLE);
            txvC.setVisibility(View.INVISIBLE);
            txvM.setVisibility(View.INVISIBLE);
            currency.setVisibility(View.INVISIBLE);
            for (int id : chk_id) {
                CheckBox chk = findViewById(id);
                chk.setVisibility(View.INVISIBLE);
            }
            btn0.setText("請開啟購物車");
            btnM.setText("開啟購物車");
        }
        return true;
    }
    // (E)
    int count =0;
    int total = 0;
    String msg = "" ;
    CheckBox chk;
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // (F)
        if (isChecked)
            count++;
        else
            count--;
        msg = ""; // reset
        total = 0;
        for (int i = 0; i < chk_id.length; i++) {
            chk = findViewById(chk_id[i]);
            if (chk.isChecked()) {
                msg += "\n" + chk.getText() + "元";
                priceT[i] = price[i];
            } else
                priceT[i] = 0;
            total += priceT[i];
        }
        txvS.setText(msg+"\n總金額:NTD"+total);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // (G)
        if(currency.getCheckedRadioButtonId() == R.id.rNtd) {
            txvC.setText("付款金額:NTD");
            txvM.setText(String.valueOf(total));
        }
        if(currency.getCheckedRadioButtonId() == R.id.rUsd) {
            calc();
            txvC.setText("付款金額:USD");
            txvM.setText(String.valueOf(total_U));
        }
        if(currency.getCheckedRadioButtonId() == R.id.rKrw) {
            calc();
            txvC.setText("付款金額:KRW");
            txvM.setText(String.valueOf(total_K));
        }
    }

    // (H)
    int total_K = 0;
    int total_U = 0;
    protected void calc(){
        total_K = total *40;
        total_U = total /30;
    }
}