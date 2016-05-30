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

import com.usirooms.usirooms.MainActivity;
import com.usirooms.usirooms.R;
import com.usirooms.usirooms.events.dummyRoom;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.recyclerview.roomAdapter;
import info.androidhive.recyclerview.roomData;


/**
 * This class must return as cardView (using recyclerView) cards where it a vnm ppears:
 * name of the room that it is actually free, time until is free (example until 17:00), floor where is the room
 * !!!!! RETURN ONLY THE ROOM OF THE BUILDING THAT WE HAVE SELECT FROM THE NAVIGATION VIEW !!!!
 */
public class FreeRooms extends Fragment {
    private List<roomData> roomList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private roomAdapter rAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1.
        rAdapter = new roomAdapter(roomList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.free_rooms, container, false);


        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        // 2. set layoutManger
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true); //
        recyclerView.setLayoutManager(mLinearLayoutManager);


        // 3. create an adapter
//        rAdapter = new roomAdapter(roomList);
        // 4. set adapter

        recyclerView.setAdapter(rAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareRoomData();


        return rootView;
    }


     private void prepareRoomData() {

         for (dummyRoom dr : MainActivity.rooms.getRooms()){
             roomList.add(new roomData("Room " + dr.getName(), "From 8:30", "to 10:30"));
         }

    }

    public void onResume() {
        super.onResume();
        recyclerView.setAdapter(rAdapter);
        rAdapter.notifyDataSetChanged();
    }


}
