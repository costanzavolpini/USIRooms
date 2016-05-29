package com.usirooms.usirooms;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.usirooms.usirooms.dummy.FreeRooms;
import com.usirooms.usirooms.dummy.byDate;
import com.usirooms.usirooms.dummy.byRoom;
import com.usirooms.usirooms.events.Events;
import com.usirooms.usirooms.events.Rooms;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String favouriteBuilding;
    public static Rooms rooms = new Rooms();
    public static Events events = new Events();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            navigationView.getMenu().performIdentifierAction(R.id.nav_free_rooms, 0);
        }

        favouriteBuilding = getResources().getStringArray(R.array.spinnerStrings)[0];

        View spinnerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        Spinner spin = (Spinner) spinnerView.findViewById(R.id.spin);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (position == 0){
                    favouriteBuilding = "Main Building";

                } else if (position == 1) {
                    favouriteBuilding = "Black Building";
                } else if (position == 2){
                    favouriteBuilding = "Red Building";
                }

                Log.i("Info", "Changed building preference");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }


    public void credits(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        TextView title = new TextView(this);
        // You Can Customise your Title here
        title.setText("Credits");
        title.setPadding(0, 35, 0, -7);
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.DKGRAY);
        title.setTextSize(20);
        title.setTypeface(Typeface.DEFAULT_BOLD, 1);

        // set title
        alertDialogBuilder.setCustomTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage("Costanza Volpini\nMarco Tollini" +
                        "\nMichele Lustro\nThomas Del Prete")
                .setCancelable(false)

                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog dialog = alertDialogBuilder.show();

        TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);

        dialog.show();

        Log.i("info", "Credits clicked");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;

        if (id == R.id.nav_free_rooms) {
            fragment = new FreeRooms();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit();

        } else if (id == R.id.nav_room) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragment = new byRoom();
            fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit();

        } else if (id == R.id.nav_date) {
            fragment = new byDate();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit();
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if (tabLayout != null) {
            if (id != R.id.nav_room) {
                tabLayout.setVisibility(View.GONE);
            } else {
                tabLayout.setVisibility(View.VISIBLE);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

}