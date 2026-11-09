package com.example.ch6_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txv;
    Spinner cinema,time;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txv = findViewById(R.id.txv);
        btn = findViewById(R.id.btn);
        cinema = findViewById(R.id.cinema);
        time = findViewById(R.id.time);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] c = getResources().getStringArray(R.array.cinemas);
                String[] t = getResources().getStringArray(R.array.times);
                int index1 = cinema.getSelectedItemPosition();
                int index2 = time.getSelectedItemPosition();

                txv.setText("訂"+c[index1]+t[index2]+"的票");
            }
        });
    }
}