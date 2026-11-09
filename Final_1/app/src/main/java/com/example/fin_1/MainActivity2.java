package com.example.fin_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    String[] q = {"內用","外帶"};
    TextView showOrder,showHereOrGo;
    ListView ForHereOrToGo;
    String HereOrGo = "";
    Button checkTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        checkTotal = findViewById(R.id.checkTotal);
        checkTotal.setOnClickListener(this);
        showOrder = findViewById(R.id.showOrder);
        showHereOrGo = findViewById(R.id.showHereOrGo);

        ForHereOrToGo = findViewById(R.id.ForHereOrToGo);
        ForHereOrToGo.setOnItemClickListener(this);

        Intent it = getIntent();
        if (it.getStringExtra("飲料") != null &&  it.getStringExtra("溫度") != null) {
            showOrder.setText( it.getStringExtra("溫度")  + it.getStringExtra("飲料"));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,q);
        ForHereOrToGo.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HereOrGo = q[position];
        showHereOrGo.setText(HereOrGo);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.checkTotal) {
            Intent it2 = new Intent();
            it2.putExtra("result", HereOrGo);
            it2.putExtra("result2", showOrder.getText().toString());

            setResult(RESULT_OK, it2);
            finish();
        }
    }
}