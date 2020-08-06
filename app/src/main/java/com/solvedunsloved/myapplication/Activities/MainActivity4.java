package com.solvedunsloved.myapplication.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.solvedunsloved.myapplication.Data.HabitDatabase;
import com.solvedunsloved.myapplication.Model.Habit;
import com.solvedunsloved.myapplication.R;
import com.solvedunsloved.myapplication.Ui.Taskrva;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {


    ConstraintLayout bottom_sheet;
    ImageView imageView;
    private BottomSheetBehavior sheetBehavior;
    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        bottom_sheet = findViewById(R.id.bottom_sheet);
        imageView = findViewById(R.id.tick);
        close = findViewById(R.id.imageView9);

        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        createRVA();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, MainActivity5.class));
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, MainActivity.class));
            }
        });

        // click event for show-dismiss bottom sheet
        bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });


        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                       bottom_sheet.setBackgroundResource(R.drawable.curve);
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        bottom_sheet.setBackgroundResource(R.drawable.plain);
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

    public void createRVA(){
        HabitDatabase db = new HabitDatabase(this);
        List<Habit> habitList = db.getAllHabits();
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Taskrva taskrva = new Taskrva(this, habitList);
        recyclerView.setAdapter(taskrva);
        taskrva.notifyDataSetChanged();
    }
}