package com.usirooms.usirooms;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TabFragment3 extends ListFragment {

    public TabFragment3(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_3, container, false);

        String[] redbuilding = getResources().getStringArray(R.array.room_redbuilding);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, redbuilding);
        setListAdapter(adapter);
        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("Info", "TEST");
        Intent singleRoom = new Intent(getActivity(), singleRoom.class);
        startActivity(singleRoom);
    }
}