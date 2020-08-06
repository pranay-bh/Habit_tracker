package com.solvedunsloved.myapplication.Ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.solvedunsloved.myapplication.Activities.MainActivity2;
import com.solvedunsloved.myapplication.Model.Habit;
import com.solvedunsloved.myapplication.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Habit> habitList;

    public RecyclerViewAdapter(Context context, List<Habit> habitList) {
        this.context = context;
        this.habitList = habitList;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Habit habit = habitList.get(position);
        holder.Name.setText(habit.getName());
        holder.Duration.setText(habit.getDuration());
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        public TextView Duration;

        public ViewHolder(View view, Context ctx) {
            super(view);
            declare(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Habit habit = habitList.get(position);
                    Intent intent = new Intent(context, MainActivity2.class);
                    intent.putExtra("id", habit.getId());
                    context.startActivity(intent);
                }
            });
        }
        public void declare(View view){
            Name = view.findViewById(R.id.name);
            Duration = view.findViewById(R.id.duration);
        }

    }
}
