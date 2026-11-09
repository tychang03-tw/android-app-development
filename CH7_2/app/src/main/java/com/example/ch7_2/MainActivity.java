package com.example.ch7_2;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener , View.OnClickListener {
    TextView txv;
    Button btn;
    ImageView f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = findViewById(R.id.answer);
        btn = findViewById(R.id.btn);
        f = findViewById(R.id.f);

        btn.setOnClickListener(this);

    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setMessage("你打算念研究所嗎")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_menu_edit)
                .setTitle("畢業問卷調查")
                .setPositiveButton("打算", this)
                .setNegativeButton("不打算", this)
                .setNeutralButton("考慮中", this)
                .show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            txv.setText("長庚五年一貫便宜又快速");
            f.setVisibility(VISIBLE);
            f.setImageResource(R.drawable.frenchfry);
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            txv.setText("可以慢慢找工作了");
            f.setVisibility(VISIBLE);
            f.setImageResource(R.drawable.burger);
        } else if (which == DialogInterface.BUTTON_NEUTRAL) {
            txv.setText("祝你有很好的決定");
            f.setVisibility(VISIBLE);
            f.setImageResource(R.drawable.softdrink);
        }
        btn.setText("再問一次");
    }

    @Override
    public void onClick(View v) {
         showDialog();
    }
}
