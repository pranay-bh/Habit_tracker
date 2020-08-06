package com.solvedunsloved.myapplication.Ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.solvedunsloved.myapplication.Model.Habit;
import com.solvedunsloved.myapplication.R;

import java.util.List;


public class Taskrva extends RecyclerView.Adapter<Taskrva.ViewHolder> {
    private Context context;
    private List<Habit> habitList;

    public Taskrva(Context context, List<Habit> habitList) {
        this.context = context;
        this.habitList = habitList;
    }

    @Override
    public Taskrva.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_task, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(Taskrva.ViewHolder holder, int position) {
        Habit habit = habitList.get(position);

        if(position == 0)
        {
            holder.milestone.setImageResource(R.drawable.ic_milestone);
        }
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
        public ImageView milestone;

        public ViewHolder(View view, Context ctx) {
            super(view);
            Name = view.findViewById(R.id.taskName);
            Duration = view.findViewById(R.id.taskDuration);
            milestone = view.findViewById(R.id.milestone);
        }
    }
}
