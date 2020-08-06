package com.solvedunsloved.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.solvedunsloved.myapplication.R;

public class MainActivity3 extends AppCompatActivity {
    TextView cancel;
    ImageButton imgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.activity3));
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.activity3));

        cancel = findViewById(R.id.cancel_button);
        imgbtn = findViewById(R.id.start_button);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, MainActivity.class));
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, MainActivity4.class));
            }
        });
    }
}