package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usirooms.usirooms.R;

/**
 * This class must return as cardView (using recyclerView) cards where it appears:
 * name of the room that it is actually free, time until is free (example until 17:00), floor where is the room
 * !!!!! RETURN ONLY THE ROOM OF THE BUILDING THAT WE HAVE SELECT FROM THE NAVIGATION VIEW !!!!
 */
public class FreeRooms extends Fragment {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.free_rooms,container,false);
    }

//    ////////////////Partial code of FreeRoom///////////////////
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        //Instantiate the adapter class and pass it a List<File> of all files in the external storage root directory.
//        adapter = new FileAdapter(Arrays.asList(Environment.getExternalStorageDirectory().listFiles()));
//
//        //Now I instantiate the RecyclerView from the Fragment's xml layout file [uifragment_main.xml]
//        rv = (RecyclerView) getActivity().findViewById(R.id.rv);
//
//    /*We are required to se a Layout Manager for the RecyclerView.
//    There are two that I see in the documentation, LinearLayoutManager,
//    GridLayoutManager, and StaggeredLayoutManager.   This layout will
//    measure and position the CardView from [row_layout.xml] within the RecyclerView.
//    So, CardView contains the TextView that holds the file name, and the CardView
//    is held by the LinearLayoutManager in the RecyclerView.
//    */
//        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        //Just like with ListView, we set the adapter.
//        rv.setAdapter(adapter);
//    }
}





//    private RecyclerView recyclerView;
//    private int room;
//    private int day;
//    private String month;
//    private int hour;
//    private int minute;
//    private boolean free;

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
//    }    //

//Base method that return the layout corresponding of that class.


//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.free_rooms,container,false);
//    }






//private class FileAdapter extends RecyclerView.Adapter<FileAdapter.RecyclerViewHolder> {
//
//    private List<File> list;
//
//    public FileAdapter(List<File> list) {
//        this.list = list;
//    }
//
//    //Called to update the list when necessary.
//    public void updateList(List<File> list) {
//        this.list = list;
//        notifyDataSetChanged();
//    }
//
//    //Here we inflate the xml used for the "rows".
//    @Override
//    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
//        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
//                R.layout.row_layout, viewGroup, false);
//
//        return new RecyclerViewHolder(v);
//    }
//
//    @Override
//    //here we access the Views held by the viewholder.
//    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
//
//        viewHolder.getTextView().setText(list.get(i).getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    ////////////////View holder for the RecyclerView////////////////
//    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
//        private TextView itemView;
//        private CardView cardView;
//
//        public RecyclerViewHolder(final View view) {
//            super(view);
//            view.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    Toast.makeText(view.getContext(), "You clicked "
//                            + String.valueOf(rv.getChildPosition(v)), Toast.LENGTH_LONG).show();
//                }
//            });
//            itemView = (TextView) view.findViewById(R.id.tv);
//            cardView = (CardView) view.findViewById(R.id.card_view);
//            cardView.setRadius(15);
//        }
//
//        public TextView getTextView() {
//            return itemView;
//        }
//    }
//
//} //FileAdapter

