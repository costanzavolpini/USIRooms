package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.usirooms.usirooms.R;

/**
 * This class shows for each day where rooms are free and which are the event of the day.
 */
public class byDate extends Fragment {

    CalendarView calendar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.by_date, container, false);
 }
}

