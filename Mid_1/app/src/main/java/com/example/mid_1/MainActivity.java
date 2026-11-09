package com.example.mid_1;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, View.OnLongClickListener,
        CompoundButton.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener,
        TextWatcher {
    View bg;
    Button btn, light;
    TextView txv, txvR, txvG;
    RadioGroup choose;
    RadioButton check3, check5;
    int CheckCount = 3;
    int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4,
            R.id.chk5, R.id.chk6, R.id.chk7, R.id.chk8, R.id.chk9}; // 宣告陣列
    int[] random_num = new int[9]; // 宣告整數陣列 長度為 9，表示這個陣列可以儲存 9 個整數，預設為 0
    EditText randomN, goalN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg = findViewById(R.id.bg);
        btn = findViewById(R.id.btn);
        light = findViewById(R.id.light);
        light.setOnClickListener(this);
        light.setOnLongClickListener(this);

        txv = findViewById(R.id.txv);
        txvR = findViewById(R.id.txvR);
        txvG = findViewById(R.id.txvG);

        choose = findViewById(R.id.choose);
        choose.setOnCheckedChangeListener(this);

        check3 = findViewById(R.id.check3);
        check5 = findViewById(R.id.check5);

        for (int id : chk_id) {
            CheckBox chk = findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }
        randomN = findViewById(R.id.randomN);
        goalN = findViewById(R.id.goalN);
        goalN.addTextChangedListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.check3)
            CheckCount = 3;
        else if (checkedId == R.id.check5)
            CheckCount = 5;

        for (int id : chk_id) {
            CheckBox chk = findViewById(id);
            chk.setChecked(false);
            chk.setText("0");
        }
        txv.setText("0");
    }
    // 設置 OnClick 的
    public void randn(View v) {
        int RN ;
        try {
            RN = Integer.parseInt(randomN.getText().toString());
            if (RN < chk_id.length) // 9
                RN = chk_id.length;
        } catch (Exception e) {
            RN = 50;
        }

        Random x = new Random();
        for (int i = 0; i < 9; i++) {
            int rand;
            boolean duplicate;
            do {
                rand = x.nextInt(RN); // 產生一個亂數
                duplicate = false;
                // 檢查是否與前面已存在的數字重複
                for (int j = 0; j < i; j++) {
                    if (random_num[j] == rand) {
                        duplicate = true;
                        break;
                    }
                }
            } while (duplicate);
            random_num[i] = rand; // 如果沒重複才存進去
            CheckBox chk = findViewById(chk_id[i]);
            chk.setText(String.valueOf(random_num[i]));
        }
        ShowResult();
    }


    ArrayList<CompoundButton> selected = new ArrayList<>(); // 建立一個 ArrayList 來存放已被勾選的 CheckBox（CompoundButton 是 CheckBox 的父類）
    boolean check = true;
    int count = 0; // 用來計算目前被勾選的 CheckBox 數量
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { // 當某個 CheckBox 被勾選或取消勾選時，就會觸發這個函式
        if (isChecked) { // 如果使用者勾選了某個選項：
            selected.add(buttonView);  // 把這個 CheckBox 加到已勾選的列表中
            count++;  // 勾選數量加一
        } else { // 如果使用者取消勾選某個選項：
            selected.remove(buttonView);  // 從列表中移除這個 CheckBox
            count--;  // 勾選數量減一
        }
        if (count > CheckCount) { // 如果使用者勾選的數量超過設定的上限（CheckCount）：
            buttonView.setChecked(false);  // 取消剛剛的這次勾選
            selected.remove(buttonView);   // 移除這個按鈕
            count--;  // 數量也要減回來
        }
    }

    @Override // 用不到
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override// 用不到
    public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override
    public void afterTextChanged(Editable s) {
        ShowResult();
    }
    protected void ShowResult() {
        // (E)
        int total = 0;
        for (int id : chk_id) {
            CheckBox chk = findViewById(id);
            if (chk.isChecked()) {
                total += Integer.parseInt(chk.getText().toString());
            }
        }
        int GN = 100;
        try {
            GN = Integer.parseInt(goalN.getText().toString());
        } catch (Exception e) {
            GN = 100;
        }
        if (total >= GN)
            txv.setText("總和:" + total + "\n贏了！");
        else
            txv.setText("總和:" + total + "\n輸了！");
    }
    // 監聽的
    int w=255,b=0;
    @Override
    public void onClick(View v) {
        ColorChange(w,b);
        light.setText("目前: 短按淺色模式");
    }
    @Override
    public boolean onLongClick(View v) {
        ColorChange(b,w);
        light.setText("目前: 長按深色模式");
        return true;
    }

    protected void ColorChange(int bgColor, int txtColor) {
        bg.setBackgroundColor(Color.rgb(bgColor,bgColor,bgColor));
        txv.setTextColor(Color.rgb(txtColor,txtColor,txtColor));
        txvR.setTextColor(Color.rgb(txtColor,txtColor,txtColor));
        txvG.setTextColor(Color.rgb(txtColor,txtColor,txtColor));
        check3.setTextColor(Color.rgb(txtColor,txtColor,txtColor));
        check5.setTextColor(Color.rgb(txtColor,txtColor,txtColor));
        for (int id : chk_id) {
            CheckBox chk = findViewById(id);
            chk.setTextColor(Color.rgb(txtColor,txtColor,txtColor));
        }
    }
}