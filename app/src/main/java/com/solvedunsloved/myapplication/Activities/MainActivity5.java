package com.solvedunsloved.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.solvedunsloved.myapplication.R;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

    }
}