package com.anncode.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.anncode.fragments.R;
import com.anncode.fragments.adapters.ItemListAdapter;
import com.anncode.fragments.model.Task;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomListFragment extends Fragment {


    public CustomListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_list, container, false);

        final EditText edtTaskToDoCustom  = (EditText)    view.findViewById(R.id.edtTaskToDoCustom);
        Button btnSaveTaskCustom    = (Button)      view.findViewById(R.id.btnSaveTaskCustom);
        ListView lstTasksCustom     = (ListView)    view.findViewById(R.id.lstTasksCustom);
        final ArrayList<Task> tasks = new ArrayList<>();

        final ItemListAdapter itemListAdapter
                = new ItemListAdapter(getContext(), R.layout.item_list, tasks);

        lstTasksCustom.setAdapter(itemListAdapter);

        btnSaveTaskCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = edtTaskToDoCustom.getText().toString();
                addItemToCustomList(tasks, taskName, itemListAdapter);
                edtTaskToDoCustom.setText("");
            }
        });


        lstTasksCustom.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removeItemCustomList(tasks, position, itemListAdapter);
                return true;
            }
        });

        return view;
    }

    public void addItemToCustomList(ArrayList<Task> tasks, String taskName, ItemListAdapter itemListAdapter){
        tasks.add(new Task(taskName, ""));
        itemListAdapter.notifyDataSetChanged();
    }

    public void removeItemCustomList(ArrayList<Task> tasks, int position, ItemListAdapter itemListAdapter){
        tasks.remove(position);
        itemListAdapter.notifyDataSetChanged();
    }

}
