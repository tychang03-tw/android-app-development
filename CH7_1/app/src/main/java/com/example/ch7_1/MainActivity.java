package com.example.ch7_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv;
    String[] Q = {"誰是萬獸之王","什麼死後還會出現","什麼帽不能帶","什麼桶子裝不滿","什麼車最長","什麼地方自討苦吃","甚麼人最不聽話","甚麼牛不會吃草","什麼地方看月亮最大","什麼東西比細菌還小"};
    String[] A = {"動物園園長","電影中的人","螺帽","馬桶","塞車","藥局","籠子","蝸牛","月亮上","細菌的兒子"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , Q);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Snackbar.make(view,"答案 :　"+ A[position],Snackbar.LENGTH_SHORT).show();
    }
}