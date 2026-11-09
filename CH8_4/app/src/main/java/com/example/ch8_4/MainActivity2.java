package com.example.ch8_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button cancel,save;
    TextView txv;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        cancel = (Button) findViewById(R.id.cancel);
        save = (Button) findViewById(R.id.save);
        txv = (TextView) findViewById(R.id.textView);
        edt = (EditText) findViewById(R.id.editText);
        cancel.setOnClickListener(this);
        save.setOnClickListener(this);

        Intent it = getIntent();
        String s = it.getStringExtra("備忘");
        txv.setText(s.substring(0,2));
        if(s.length()>3){
            edt.setText(s.substring(3));
        }
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cancel){
            setResult(RESULT_CANCELED);
            finish();
        }
        if(v.getId()==R.id.save){
            Intent it2 = new Intent();
            it2.putExtra("備忘",txv.getText() + " " + edt.getText());
            it2.putExtra("日期",new Date().toString());
            setResult(RESULT_OK,it2); // 2. result
            finish();
        }
    }
}