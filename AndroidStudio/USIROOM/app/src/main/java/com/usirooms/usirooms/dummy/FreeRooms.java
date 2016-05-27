package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.usirooms.usirooms.R;

/**
 * This class must return as cardView (using recyclerView) cards where it a vnm ppears:
 * name of the room that it is actually free, time until is free (example until 17:00), floor where is the room
 * !!!!! RETURN ONLY THE ROOM OF THE BUILDING THAT WE HAVE SELECT FROM THE NAVIGATION VIEW !!!!
 */
public class FreeRooms extends ListFragment {
//    // EXAMPLE OF CARD VIEW WITG RECYCLER VIEW
//
//    //Reference to the RecyclerView.
//    private RecyclerView rv;
//
//    //I also need a reference to the Adapter I will use to populate the Recyclerview.
//    FileAdapter adapter;
//
//    public FreeRooms() {
//    }

    public FreeRooms(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.free_rooms, container, false);

            String[] values = new String[] { "Food", "Fuel", "Travel", "Stuff", "Repairs","Food", "Fuel", "Travel", "Stuff","Food", "Fuel", "Travel", "Stuff","Food", "Fuel", "Travel", "Stuff","Food", "Fuel", "Travel", "Stuff","Food", "Fuel", "Travel", "Stuff","Food", "Fuel", "Travel", "Stuff","Food", "Fuel", "Travel" };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);

            return rootView;
        }
    }
