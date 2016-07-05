package com.anncode.fragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.anncode.fragments.R;


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
        Button          btnSaveTask = (Button)      view.findViewById(R.id.btnSaveTask);
        final TextView    tvTaskList  = (TextView)    view.findViewById(R.id.tvTaskList);

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = edtTaskToDo.getText().toString();
                tvTaskList.append("\n" + task);
            }
        });


        return view;
    }

}
