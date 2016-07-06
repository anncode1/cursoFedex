package com.anncode.holamundo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("CREATE", getString(R.string.mensaje_oncreate));
        Toast.makeText(MainActivity.this, getString(R.string.mensaje_oncreate), Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("START", "Método onStrat()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("RESUME", "Método onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("PAUSA", "Método onPausa()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("STOP", "Método onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("DESTROY", "Método onDestroy");
    }
}
