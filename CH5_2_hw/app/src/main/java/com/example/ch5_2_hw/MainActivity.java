package com.example.ch5_2_hw;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{
    int items =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        int[] chk_id={R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};
        for(int id:chk_id)
            ((CheckBox)findViewById(id)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int visible;
                    if(isChecked){
                        items+=1;
                        visible = View.VISIBLE;}
                    else {
                        items-=1;
                        visible = View.GONE;}
                    int id = buttonView.getId();
                    if (id == R.id.chk1)
                        findViewById(R.id.output1).setVisibility(visible);
                    else if (id == R.id.chk2)
                        findViewById(R.id.output2).setVisibility(visible);
                    else if (id == R.id.chk3)
                        findViewById(R.id.output3).setVisibility(visible);
                    else if (id == R.id.chk4)
                        findViewById(R.id.output4).setVisibility(visible);
                    String msg;
                    if(items>0){
                        msg="您的餐點如下";}
                    else{
                        msg="請點餐";}
                    ((TextView)findViewById(R.id.showOrder)).setText(msg);
                }
            });
    }
}