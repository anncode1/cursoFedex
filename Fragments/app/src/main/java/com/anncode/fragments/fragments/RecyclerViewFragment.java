package com.anncode.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.anncode.fragments.R;
import com.anncode.fragments.adapters.TaskAdapter;
import com.anncode.fragments.model.TaskDesciption;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        RecyclerView rvTasks = (RecyclerView) view.findViewById(R.id.rvTasks);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvTasks.setLayoutManager(linearLayoutManager);

        final ArrayList<TaskDesciption> taskDesciptions = new ArrayList<>();
        final TaskAdapter taskAdapter = new TaskAdapter(taskDesciptions, R.layout.cardview_task);
        rvTasks.setAdapter(taskAdapter);

        final EditText edtTaskToDoRecycler        = (EditText) view.findViewById(R.id.edtTaskToDoRecycler);
        final EditText edtTaskDescriptionRecycler = (EditText) view.findViewById(R.id.edtTaskDescriptionRecycler);
        Button   btnSaveTaskRecycler        = (Button) view.findViewById(R.id.btnSaveTaskRecycler);

        btnSaveTaskRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskTitle = edtTaskToDoRecycler.getText().toString();
                String taskDescription = edtTaskDescriptionRecycler.getText().toString();
                taskDesciptions.add(new TaskDesciption(taskTitle, taskDescription));
                taskAdapter.notifyDataSetChanged();
                edtTaskToDoRecycler.setText("");
                edtTaskDescriptionRecycler.setText("");

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    /*public void addItemToRecyclerView(String taskTitle, String taskDescription, ){

    }*/




}
