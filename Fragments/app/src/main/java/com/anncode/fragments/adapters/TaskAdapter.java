package com.anncode.fragments.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anncode.fragments.R;
import com.anncode.fragments.model.TaskDesciption;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 06/07/16.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>  {

    private ArrayList<TaskDesciption> tasksDesciptions;
    private int resource;

    public TaskAdapter(ArrayList<TaskDesciption> tasksDesciptions, int resource) {
        this.tasksDesciptions   = tasksDesciptions;
        this.resource           = resource;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(resource, parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder taskViewHolder, int position) {
        TaskDesciption taskDesciption = tasksDesciptions.get(position);
        taskViewHolder.tvTaskTitle.setText(taskDesciption.getName());
        taskViewHolder.tvTaskDescription.setText(taskDesciption.getDescription());
    }

    @Override
    public int getItemCount() {
        return tasksDesciptions.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTaskTitle;
        private TextView tvTaskDescription;


        public TaskViewHolder(View itemView) {
            super(itemView);

            tvTaskTitle         = (TextView) itemView.findViewById(R.id.tvTaskTitle);
            tvTaskDescription   = (TextView) itemView.findViewById(R.id.tvTaskDescription);
        }
    }
}
