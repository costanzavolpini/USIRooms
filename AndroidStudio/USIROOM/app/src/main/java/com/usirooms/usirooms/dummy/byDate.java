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

    CalendarView calendarView;
   // Button dataEvento = (Button) findViewById(R.id.selectDay);

    // Method that return the layout corresponding to that class
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.by_date, container, false);
 }

//    // Method that selecting a day must return something.
//    dataEvento.setOnClickListener(new OnClickListener() {
//        public void onClick(View v) {
//            //Qui crei il dialog dove visualizzi il valore che ti interessa
//            new AlertDialog.Builder(new ContextThemeWrapper(Context, R.style.Dialog))
//                    .setTitle("Titolo dialog")
//                    .setMessage("Evento" + evento).show();
//        });
//    }
}


//
//    // JUST FOR DEBUG
//    public void selectDay(View view){
//        System.out.println("ciao marco" + calendarView.getDate());
//    }