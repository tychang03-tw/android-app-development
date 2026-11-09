package com.example.ch6_3_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, View.OnClickListener {

    String[] north = {"宜蘭","台北","基隆","桃園","新竹","苗栗"};
    String[] mid = {"台中","彰化","南投"};
    String[] south = {"高雄","雲林","嘉義","台南","屏東"};
    String[] east = {"花蓮","台東"};

    TextView txv;
    Button btn;
    Spinner region, region2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txv = findViewById(R.id.txv);
        btn = findViewById(R.id.btn);
        region = findViewById(R.id.region);
        region2 = findViewById(R.id.region2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.regions, android.R.layout.simple_spinner_item);
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        region.setAdapter(adapter);

        btn.setOnClickListener(this);
        region.setOnItemSelectedListener(this);
        region2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.region) {

            String[] cities = {};
            if (position == 0)
                cities = north;
            else if (position == 1)
                cities = mid;
            else if (position == 2)
                cities = south;
            else if (position == 3)
                cities = east;

            ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
            // cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            region2.setAdapter(cityAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        String area = region.getSelectedItem().toString();
        String city = region2.getSelectedItem().toString();
        txv.setText("您住在" + area + "的" + city);
    }
}
