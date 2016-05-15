package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usirooms.usirooms.R;

/**
 * Created by costanzavolpini on 14/05/16.
 */
public class byDate extends Fragment {
//    CalendarView calendarView;
//    TextView dateDisplay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.by_date, container, false);


////        calendarView = (CalendarView) findViewById(R.id.calendarView);
////        dateDisplay = (TextView) findViewById(R.id.date_display);
//        dateDisplay.setText("Date: ");
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
//                dateDisplay.setText("Date: " + i2 + " / " + i1 + " / " + i);
////
////                Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
