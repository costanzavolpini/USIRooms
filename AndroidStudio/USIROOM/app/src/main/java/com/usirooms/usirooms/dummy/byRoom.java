package com.usirooms.usirooms.dummy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.usirooms.usirooms.TabFragment1;
import com.usirooms.usirooms.TabFragment2;
import com.usirooms.usirooms.TabFragment3;

public class byRoom extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public byRoom(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}


/**
 * Created by costanzavolpini on 14/05/16.
 */
//public class byRoom extends Fragment {
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.by_room,container,false);
//
//
//
//    }
//}