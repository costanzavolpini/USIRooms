package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.usirooms.usirooms.R;

/**
 * Class creating to visualize details of a class, such that: capacity, name, floor, map, status (free or not)
 */
public class Room_specific extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_specifiche);
    }
}
