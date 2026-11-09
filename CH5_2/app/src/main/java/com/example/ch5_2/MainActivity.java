package com.example.ch5_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CheckBox chk;
                String msg="";
                int[] id={R.id.chk1,R.id.chk2,R.id.chk3,R.id.chk4,R.id.chk5,R.id.chk6,R.id.chk7,R.id.chk8};
                for(int i:id){
                    chk = (CheckBox) findViewById(i);
                    if(chk.isChecked())
                        msg+="\n"+chk.getText();
                }
                if(msg.length()>0)
                    msg="你點購的餐點是 :"+msg;
                else
                    msg="請點餐";
                ((TextView)findViewById(R.id.showOrder)).setText(msg);
            }
        });
    }
//    public void takeOrder(View v){
//        CheckBox chk;
//        String msg="";
//        int[] id={R.id.chk1,R.id.chk2,R.id.chk3,R.id.chk4,R.id.chk5,R.id.chk6,R.id.chk7,R.id.chk8};
//        for(int i:id){
//            chk = (CheckBox) findViewById(i);
//            if(chk.isChecked())
//                msg+="\n"+chk.getText();
//        }
//        if(msg.length()>0)
//            msg="你點購的餐點是 :"+msg;
//        else
//            msg="請點餐";
//        ((TextView)findViewById(R.id.showOrder)).setText(msg);
//    }
}