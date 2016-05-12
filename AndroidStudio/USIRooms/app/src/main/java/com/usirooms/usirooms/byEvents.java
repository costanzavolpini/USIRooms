package com.usirooms.usirooms;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class byEvents extends freeRooms implements NavigationView.OnNavigationItemSelectedListener {
    String msg = "#######by Events : ";

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_by_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.d(msg, "The onCreate() event");


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(msg, "The onResume() event");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

}
