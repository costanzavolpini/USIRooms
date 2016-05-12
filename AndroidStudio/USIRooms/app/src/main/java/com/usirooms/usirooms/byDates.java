package com.usirooms.usirooms;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class byDates extends freeRooms implements NavigationView.OnNavigationItemSelectedListener {
    String msg = "#######by Dates : ";
    CalendarView calendarView;
    TextView dateDisplay;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_by_dates);
        Log.d(msg, "The onCreate() event");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateDisplay = (TextView) findViewById(R.id.date_display);
        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                dateDisplay.setText("Date: " + i2 + " / " + i1 + " / " + i);

                Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
            }
        });
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
