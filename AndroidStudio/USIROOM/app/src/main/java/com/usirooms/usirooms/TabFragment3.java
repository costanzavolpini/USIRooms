package com.usirooms.usirooms;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class TabFragment3 extends ListFragment {

    public TabFragment3(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_3, container, false);

        String[] values = new String[] {"Room A11", "Room A12", "Room A13", "Room A14", "Room A21", "Room A22", "Room A23", "Room A24", "Room A31", "Room A32", "Room A33", "Room A34" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return rootView;
    }
}