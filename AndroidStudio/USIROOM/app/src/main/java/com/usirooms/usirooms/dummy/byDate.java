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

        ArrayList<eventData> ed = new ArrayList<>();

        ed.add(new eventData("Algorithm and data structures"));
        ed.add(new eventData("Calculus"));
        ed.add(new eventData("Programming Fundamentals 2"));
        ed.add(new eventData("Human & Computer Interaction"));
        ed.add(new eventData("Linear Algebra"));
        ed.add(new eventData("The new era of Robots"));
        ed.add(new eventData("Informatics into Biology"));
        ed.add(new eventData("The power of Dr. Racket"));
        ed.add(new eventData("CSS: the basics"));
        ed.add(new eventData("Anonymous: legal or not?"));
        ed.add(new eventData("Operating Systems"));
        ed.add(new eventData("The new era of Internet"));
        ed.add(new eventData("Social network vs real life"));
        ed.add(new eventData("How many friends on Facebook?"));
        ed.add(new eventData("Informatics and women"));
        ed.add(new eventData("Math vs computer graphics"));
        ed.add(new eventData("Discrete structure"));


        eventList.clear();

        for (int i = 0; i < randInt(1, ed.size()); i++){
            int rand = randInt(0, ed.size() - 1);
            eventList.add(ed.get(rand));
            ed.remove(rand);
        }
    }
}

