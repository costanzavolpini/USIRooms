package com.usirooms.usirooms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.recyclerview.roomAdapter;
import info.androidhive.recyclerview.roomData;

public class TabFragment1 extends Fragment {
    private List<roomData> roomList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private roomAdapter rAdapter;

    public TabFragment1() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);

        rAdapter = new roomAdapter(roomList);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_tab_1);

        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLinearLayoutManager);



        recyclerView.setAdapter(rAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        String[] blackbuilding = getResources().getStringArray(R.array.room_blackbuilding);
        for (String room : blackbuilding) {
            roomList.add(new roomData(room, "From 8:30", "to 10:30"));


        }
        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        roomList = new ArrayList<>();
    }

}

