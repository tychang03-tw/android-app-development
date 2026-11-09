package com.example.fin_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DialogInterface.OnClickListener, View.OnClickListener {
    String[] d = {"奶茶","抹茶","水果茶","奶昔"};
    Spinner drink,temp;
    TextView showResult;
    String[] tempset1 = {"冰","去冰","溫","熱"};
    String[] tempset2 = {"冰","去冰"};
    String OrderStuff = "";
    int[] price = {70,55,60,65};
    int total = 0;
    String HereOrGo = "您尚未選內用或外帶";
    Button order,gocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        temp = (Spinner) findViewById(R.id.temp);
        drink = (Spinner) findViewById(R.id.drink);
        drink.setOnItemSelectedListener(this);
        showResult = (TextView) findViewById(R.id.showResult);
        order = (Button) findViewById(R.id.order);
        gocart = (Button) findViewById(R.id.gocart);
        order.setOnClickListener(this);
        gocart.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,d);
        drink.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.drink){
            String[] t = {};
            if(position==0)
                t = tempset1;
            if(position==1)
                t = tempset1;
            if(position==2)
                t = tempset2;
            if(position==3)
                t = tempset2;
            ArrayAdapter<String> adapter2 = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1,t);
            temp.setAdapter(adapter2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    String selectedDrink = "";
    String selectedTemp = "";
    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==DialogInterface.BUTTON_POSITIVE){
            Toast.makeText(this,"已加入購物車",Toast.LENGTH_SHORT).show();
            selectedDrink = drink.getSelectedItem().toString();
            selectedTemp = temp.getSelectedItem().toString();
        }
        if (which==DialogInterface.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.order){
            new AlertDialog.Builder(this)
                    .setMessage("確認是否加入購物車")
                    .setCancelable(false)
                    .setPositiveButton("確認",this)
                    .setNegativeButton("取消",this).show();
        }
        if(v.getId()==R.id.gocart){
            Intent it = new Intent(this, MainActivity2.class);
            if (selectedDrink.isEmpty() || selectedTemp.isEmpty()){
                startActivity(it);
            }else {
                it.putExtra("飲料", selectedDrink);
                it.putExtra("溫度", selectedTemp);
                startActivityForResult(it,drink.getSelectedItemPosition());
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent it2) {
        super.onActivityResult(requestCode, resultCode, it2);
        if(resultCode == RESULT_OK){ // 3. result
            showResult.setText("總價 : "+price[requestCode]+"\n"
                    + it2.getStringExtra("result2") + it2.getStringExtra("result"));
        }
    }
}




















