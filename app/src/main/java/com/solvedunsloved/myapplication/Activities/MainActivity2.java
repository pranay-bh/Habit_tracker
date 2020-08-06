package com.solvedunsloved.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.solvedunsloved.myapplication.Data.HabitDatabase;
import com.solvedunsloved.myapplication.Model.Habit;
import com.solvedunsloved.myapplication.R;

public class MainActivity2 extends AppCompatActivity {
    EditText Name,Description,Duration;
    Button save,cancel,delete;
    HabitDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findview();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Habit habit = new Habit();
                habit.setName(Name.getText().toString());
                habit.setDuration(Duration.getText().toString());
                habit.setDescription(Description.getText().toString());
                //Save to DB
                db.addHabit(habit);
                Snackbar.make(v, "Information Saved!", Snackbar.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity2.this, MainActivity.class));     //start a new activity
                        finish();
                    }
                }, 1000); //  1 second.
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HabitDatabase db = new HabitDatabase(MainActivity2.this);
//                db.deleteHabit(id);
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                finish();
            }
        });
    }
    void findview(){
        getWindow().setStatusBarColor(Color.parseColor("#000000"));
        Name = findViewById(R.id.inputname);
        Description = findViewById(R.id.inputdescription);
        Duration = findViewById(R.id.inputduration);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        delete = findViewById(R.id.deletehabit);
        db = new HabitDatabase(this);
    }
}