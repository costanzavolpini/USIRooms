package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.usirooms.usirooms.R;

/**
 * This class shows for each day where rooms are free and which are the event of the day.
 */
public class byDate extends Fragment {

    CalendarView cv;
    Long date;
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
                    Toast.makeText(view.getContext(), "Year=" + year + " Month=" + month + " Day=" + dayOfMonth, Toast.LENGTH_LONG).show();

                }
            }
        });
        return rootView;
 }
}

