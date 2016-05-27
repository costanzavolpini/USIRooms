package com.usirooms.usirooms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class TabFragment1 extends ListFragment {

    public TabFragment1() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);

        String[] blackbuilding = getResources().getStringArray(R.array.room_blackbuilding);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, blackbuilding);
        setListAdapter(adapter);
        return rootView;
    }

//    ListView list = getListView();
//
//
//    ListView list = getListView();
//    list.setOnItemClickListener(new AdapterView.OnItemClickListener()
//
//    {
//        @Override
//        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
//        Object listItem = list.getItemAtPosition(position);
//        Intent myIntent = new Intent(TabFragment1.this, room.class);
//        //  myIntent.putExtra("key", value); //parametri da passare se ti servono
//        TabFragment1.this.startActivity(myIntent);
//    }
//    }
//    );
}




//        if (list.getSelectedItemPosition() == 0){
//            return View.inflate(R.layout.room_specifiche, container, false);
//
//        } else if(list.getSelectedItemPosition() == 1){
//            //layout
//
//        }else if(list.getSelectedItemPosition() == 2){
//            //layout
//
//        }else if(list.getSelectedItemPosition() == 3){
//            //layout
//
//        }else if(list.getSelectedItemPosition() == 4){
//            //layout
//
//        }else if(list.getSelectedItemPosition() == 5){
//            //layout
//
//        }else if(list.getSelectedItemPosition() == 6){
//            //layout
//
//        }else if(list.getSelectedItemPosition() == 7){
//            //layout
//
//        }
//

