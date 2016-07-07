package com.anncode.contactosappintents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anncode.contactosappintents.model.Contact;
import com.squareup.picasso.Picasso;

public class ContactDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private final int PHONE = 0;
    private final int WEBSITE = 1;

    TextView    tvNameContactDetail;
    ImageView   imgPictureContactDetail;
    TextView    tvPhoneContactDetail;
    TextView    tvWebSiteContactDetail;
    Contact     contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        tvNameContactDetail     = (TextView)    findViewById(R.id.tvNameContactDetail);
        imgPictureContactDetail = (ImageView)   findViewById(R.id.imgPictureContactDetail);
        tvPhoneContactDetail    = (TextView)    findViewById(R.id.tvPhoneContactDetail);
        tvWebSiteContactDetail  = (TextView)    findViewById(R.id.tvWebSiteContactDetail);

        Bundle extras = getIntent().getExtras();
        if (extras == null){
            return;
        }

        contact = (Contact) getIntent().getSerializableExtra(getString(R.string.key_extra_contact));
        tvNameContactDetail.setText(contact.getName());
        tvPhoneContactDetail.setText(contact.getPhone());
        tvWebSiteContactDetail.setText(contact.getWebsite());

        Picasso.with(this)
                .load(contact.getPicture())
                .placeholder(R.drawable.contacto1)
                .into(imgPictureContactDetail);

        tvPhoneContactDetail.setOnClickListener(this);
        tvWebSiteContactDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tvPhoneContactDetail:
                Intent intent = new Intent();
                intent.putExtra("value", contact.getPhone());
                setResult(2, intent);
                finish();
                break;

            case R.id.tvWebSiteContactDetail:
                intent = new Intent();
                intent.putExtra("value", contact.getWebsite());
                setResult(WEBSITE, intent);
                finish();
                break;
        }

    }
}
