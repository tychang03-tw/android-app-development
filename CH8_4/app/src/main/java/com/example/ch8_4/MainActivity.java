package com.example.ch8_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {
    String[] aMemo = {"1. 按一下可以編輯備忘","2. 長按可以清除備忘" , "3. " , "4. " , "5. " , "6. "};
    ListView lv;
    ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,aMemo);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent it2) {
        super.onActivityResult(requestCode, resultCode, it2);
        if(resultCode == RESULT_OK){ // 3. result
            aMemo[requestCode] = it2.getStringExtra("備忘");
            aa.notifyDataSetChanged();
            Toast.makeText(this,"於"
                    + it2.getStringExtra("日期") + "修改",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent(this, MainActivity2.class);
        // it.putExtra("編號",position+1);
        it.putExtra("備忘", aMemo[position]);
        startActivityForResult(it,position); // 1. result
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        aMemo[position] = (position+1) + "." ;
        aa.notifyDataSetChanged();
        return true;
    }

}