package com.anncode.contactosappintents.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anncode.contactosappintents.ContactDetailActivity;
import com.anncode.contactosappintents.R;
import com.anncode.contactosappintents.model.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 07/07/16.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private ArrayList<Contact> contacts;
    private int resource;
    private Context context;

    public ContactAdapter(Activity context, ArrayList<Contact> contacts, int resource) {
        this.contacts = contacts;
        this.resource = resource;
        this.context = context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int position) {
        final Contact contact = contacts.get(position);
        Picasso.with((Activity) context)
                .load(contact.getPicture())
                .placeholder(R.drawable.contacto1)
                .into(contactViewHolder.imgPictureContact);

        contactViewHolder.tvNameContact.setText(contact.getName());

        contactViewHolder.imgPictureContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContactDetailActivity.class);
                intent.putExtra(context.getString(R.string.key_extra_contact), contact);
                ((Activity) context).startActivityForResult(intent, 0);
            }
        });


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView imgPictureContact;
        TextView tvNameContact;

        public ContactViewHolder(View itemView) {
            super(itemView);

            imgPictureContact   = (ImageView) itemView.findViewById(R.id.imgPictureContact);
            tvNameContact       = (TextView) itemView.findViewById(R.id.tvNameContact);
        }
    }
}
