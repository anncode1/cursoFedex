package com.anncode.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.anncode.fragments.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtroFragment extends Fragment {


    public OtroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_otro, container, false);

        final EditText    edtTaskToDo = (EditText)    view.findViewById(R.id.edtTaskToDo);
        Button            btnSaveTask = (Button)      view.findViewById(R.id.btnSaveTask);
        ListView lstTasks = (ListView) view.findViewById(R.id.lstTasks);
        //final TextView    tvTaskList  = (TextView)    view.findViewById(R.id.tvTaskList);

        final ArrayList<String> arrayTasks = new ArrayList<>();
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        arrayTasks
                );

        lstTasks.setAdapter(adapter);

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = edtTaskToDo.getText().toString();
                arrayTasks.add(task);
                adapter.notifyDataSetChanged();
                edtTaskToDo.setText("");
                //tvTaskList.append("\n" + task);

            }
        });

        lstTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayTasks.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });


        return view;
    }

}
