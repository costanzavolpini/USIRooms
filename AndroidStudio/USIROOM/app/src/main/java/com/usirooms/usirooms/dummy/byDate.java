package com.usirooms.usirooms.dummy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.by_date, container, false);



        cv = (CalendarView) rootView.findViewById(R.id.calendarView);
        date = cv.getDate();
        cv.setClickable(true);

        cv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){
            @Override
            public void onGlobalLayout() {
                if (cv.getDate() != date) {
                    date = cv.getDate();
                    prepareEventData();
                }

                cv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(date);
                        prepareEventData();
                    }
                });
            }
//
//                cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//                    @Override
//                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                        if (cv.getDate() != date){
//                            Log.i("Info", "Clicked event");
//                            date = cv.getDate();
//                            prepareEventData();
//
//                        }
//                    }
//                });
//            }
        });


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_calendar);

        prepareEventData();

        return rootView;
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


    public void prepareEventData(){

        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLinearLayoutManager);


        eAdapter = new eventAdapter(eventList);

        recyclerView.setAdapter(eAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


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

