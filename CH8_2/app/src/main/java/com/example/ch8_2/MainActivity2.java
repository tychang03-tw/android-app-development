package com.example.ch8_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView txv;
    Button again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        txv = (TextView) findViewById(R.id.txv);
        again = (Button) findViewById(R.id.again);
        again.setOnClickListener(this);

        String result = getIntent().getStringExtra("result");
        txv.setText(result);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.again){
            finish();
        }
    }
}