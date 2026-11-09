package com.example.ch8_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button add,delete;
    TextView txvD,txvS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        txvD = (TextView) findViewById(R.id.txvD);
        txvS = (TextView) findViewById(R.id.txvS);
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent it2) {
        super.onActivityResult(requestCode, resultCode, it2);
        if (resultCode == RESULT_OK && it2 != null) { // 3.result
            String result1 = it2.getStringExtra("result1");
            String result2 = it2.getStringExtra("result2");

            String originalD = txvD.getText().toString();
            String originalS = txvS.getText().toString();

            txvD.setText(originalD + "\n" + result1);
            txvS.setText(originalS + "\n" + result2);
        }
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivityForResult(intent, 1); // 1.result
        }
        if(v.getId() == R.id.delete){
            txvD.setText("");
            txvS.setText("");
        }
    }
}