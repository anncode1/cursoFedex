package com.anncode.fragments.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anncode.fragments.R;
import com.anncode.fragments.model.Task;

/**
 * Created by anahisalgado on 06/07/16.
 */
public class ItemListAdapter extends ArrayAdapter<Task> {

    Context context;
    int resource;
    Task[] tasks;

    public ItemListAdapter(Context context, int resource, Task[] tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.resource = resource;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Activity activity = (Activity) context;
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(resource, null);

        ImageView   imgImagen   = (ImageView) view.findViewById(R.id.imgImagen);
        TextView    tvTask      = (TextView) view.findViewById(R.id.tvTask);

        //Settear el path a la imagen

        //Settear el nombre de la tarea al objeto TextView
        tvTask.setText(tasks[position].getName());

        return view;

    }
}
