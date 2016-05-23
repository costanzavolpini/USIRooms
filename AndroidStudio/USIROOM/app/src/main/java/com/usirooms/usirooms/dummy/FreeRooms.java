package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usirooms.usirooms.R;

import java.util.ArrayList;

/**
 * Created by costanzavolpini on 15/05/16.
 */
public class FreeRooms extends Fragment {
    private RecyclerView recyclerView;
    private int room;
    private int day;
    private String month;
    private int hour;
    private int minute;
    private boolean free;

//    public FreeRooms(int room, int day, String month, int hour, boolean free, int minute){
//        this.room = room;
//        this.day = day;
//        this.month = month;
//        this.hour = hour;
//        this.minute = minute;
//        this.free = free;
//    }
//
//    public int getNameRoom(){
//        return room;
//    }
//
//    public boolean isFree(){
//        return free;
//    }
//
//    private static int lastRoomindex = 0;
//
//    public static ArrayList<FreeRooms> createRoomsList(int numRooms) {
//        ArrayList<FreeRooms> rooms = new ArrayList<FreeRooms>();
//
//        for (int i = 1; i <= numRooms; i++) {
//            rooms.add(new FreeRooms("Room" + ++lastRoomindex, i <= numRooms / 2));
//        }
//        return rooms;
//
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View layout=inflater.inflate(R.layout.free_rooms,container,false);
//        recyclerView = (RecyclerView) layout.findViewById(R.id.container);
//        return layout;
        return inflater.inflate(R.layout.free_rooms,container,false);
    }
}