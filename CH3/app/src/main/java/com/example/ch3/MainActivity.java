package com.example.ch3;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    // 寫在這會一直占用記憶體
    // EditText a,b,c,d;
    // TextView txv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        a = findViewById(R.id.a);
//        b = findViewById(R.id.b);
//        c = findViewById(R.id.c);
//        d = findViewById(R.id.d);
//        txv = findViewById(R.id.txv);
    }
    public void onclick(View v){  //舊方法 突然生成再選取 //EditText a = findViewById(R.id.a); //TextView txv = findViewById(R.id.txv);

        EditText a = findViewById(R.id.a);
        EditText b = findViewById(R.id.b);
        EditText c = findViewById(R.id.c);
        EditText d = findViewById(R.id.d);
        TextView txv = findViewById(R.id.txv);

        String correctPassword = "1234";
        String inputPassword = d.getText().toString();
        if (inputPassword.equals(correctPassword)) {
            txv.setText(
                    a.getText().toString() + b.getText().toString() + "的電話是" + c.getText().toString());}
        else {txv.setText("密碼錯誤，請重新輸入");}
    }
}