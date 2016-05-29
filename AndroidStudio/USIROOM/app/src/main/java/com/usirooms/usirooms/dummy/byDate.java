package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.usirooms.usirooms.R;

import info.androidhive.recyclerview.eventAdapter;
import info.androidhive.recyclerview.eventData;

/**
 * This class shows for each day where rooms are free and which are the event of the day.
 */
public class byDate extends Fragment {

    CalendarView cv;
    Long date;
    private List<eventData> eventList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private eventAdapter eAdapter;
   // Button dataEvento = (Button) findViewById(R.id.selectDay);

    // Method that return the layout corresponding to that class
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.by_date, container, false);

        cv = (CalendarView) rootView.findViewById(R.id.calendarView);
        date = cv.getDate();
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                if (cv.getDate() != date){
                    date = cv.getDate();
                    prepareEventData();
//                    Toast.makeText(view.getContext(), "Year=" + year + " Month=" + month + " Day=" + dayOfMonth, Toast.LENGTH_LONG).show();

                }
            }
        });

        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_calendar);

        prepareEventData();

        return rootView;
    }

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


    public void prepareEventData(){

        // 2. set layoutManger
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true); //
        recyclerView.setLayoutManager(mLinearLayoutManager);


        // 3. create an adapter
        eAdapter = new eventAdapter(eventList);
        // 4. set adapter

        recyclerView.setAdapter(eAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //System.out.println("***********Perché non vai porca puttana**************");

        eventList.clear();

        eventData event_a = new eventData("Event " + randInt(0,10) + "");
        eventList.add(event_a);

        eventData event_b = new eventData("Event " + randInt(0,10) + "");
        eventList.add(event_b);

        eventData event_c = new eventData("Event " + randInt(0,10) + "");
        eventList.add(event_c);

        eventData event_d = new eventData("Event " + randInt(0,10) + "");
        eventList.add(event_d);
    }
}

