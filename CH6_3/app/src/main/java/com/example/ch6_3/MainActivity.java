package com.example.ch6_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    TextView msgTxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        msgTxv = (TextView)findViewById(R.id.msgTxv) ;
        ListView Iv = (ListView)findViewById(R.id.Iv);
        Iv.setOnItemClickListener(this);
    }
    ArrayList<String> selected = new ArrayList<>();
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView txv = (TextView) view;
        String item = txv.getText().toString();

        if(selected.contains(item))
            selected.remove(item);
        else
            selected.add(item);

        String msg = "";
        if(selected.size()>0){
            msg = "你夾了";
            for(String str:selected)
                msg+=" "+str;
        }else{
            msg="請選擇";
        }
        msgTxv.setText(msg);
    }
}