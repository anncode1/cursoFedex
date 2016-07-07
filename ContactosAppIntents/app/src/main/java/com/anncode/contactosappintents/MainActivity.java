package com.anncode.contactosappintents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.anncode.contactosappintents.Adapter.ContactAdapter;
import com.anncode.contactosappintents.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 3;
    private final int PHONE = 2;
    private final int WEBSITE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvContact = (RecyclerView) findViewById(R.id.rvContact);
        rvContact.setLayoutManager(recyclerGrid());


        rvContact.setAdapter(new ContactAdapter(this, buildDummyContactList(), R.layout.cardview_contact));


    }

    public ArrayList<Contact> buildDummyContactList() {
        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("https://z-1-scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/13567328_1136627746358189_5852164150356691052_n.jpg?oh=dfd08a46e5579a4c2531410e5b8010c1&oe=58321DA8", "Sakura", "22221111", "twitter.com"));
        contacts.add(new Contact("https://z-1-scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/13418796_1136627739691523_5466660076076078948_n.jpg?oh=68c152dff226c10aa568b2dedb71db48&oe=57F1A846", "Sinon", "33332222", "yahoo.com"));
        contacts.add(new Contact("https://z-1-scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/13627050_1136627743024856_8371877266779400676_n.jpg?oh=4010888e662f17285e056c443f9812c7&oe=57F030F0", "Asuna", "11119999", "facebook.com"));
        contacts.add(new Contact("https://z-1-scontent-lax3-1.xx.fbcdn.net/v/t1.0-9/13620047_1136627759691521_8788096493360602557_n.jpg?oh=2b6151a69b845940ac3228c6769e00e7&oe=57EAD7C4", "Mirajane", "55557777", "youtube.com"));

        return contacts;
    }

    public LinearLayoutManager recyclerListaVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return linearLayoutManager;
    }

    public GridLayoutManager recyclerGrid() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        return gridLayoutManager;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", "***AQUI");
        Log.e("resultCode", String.valueOf(resultCode));
        if (data == null) {
            return;
        }
        Bundle resultData = data.getExtras();
        String value = resultData.getString("value");
        Log.e("VALUE", value);
        switch (resultCode) {
            case WEBSITE:

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + value)));
                break;

            case PHONE:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + value)));

                break;
        }
    }
}
