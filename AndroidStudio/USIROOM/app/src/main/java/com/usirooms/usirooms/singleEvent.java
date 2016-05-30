package com.usirooms.usirooms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class singleEvent extends AppCompatActivity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.WhiteTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv = (TextView) findViewById(R.id.single_event_room);

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv.getContext().startActivity(new Intent(tv.getContext(), singleRoom.class));
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }
}
