package com.usirooms.usirooms.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usirooms.usirooms.R;
import com.usirooms.usirooms.TabFragment1;
import com.usirooms.usirooms.TabFragment2;
import com.usirooms.usirooms.TabFragment3;

import java.util.ArrayList;
/**
 * This class implemented as TabActivity shows all the rooms of all buildings dividing that in more tab.
 * Rooms will appear as list.
 * Structure
 * NameRoom bottom (green/red depending on the state of the room)
 */
public class byRoom extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private DummyPagerAdapter mDummyPagerAdapter;


    // Method that return the layout corresponding to that class
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.by_room, container, false);
        mTabLayout = (TabLayout) getActivity().findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) v.findViewById(R.id.pager);

        //Create 3 tab each one for a different building
        mDummyPagerAdapter = new DummyPagerAdapter(getChildFragmentManager());
        mDummyPagerAdapter.addFragment(new TabFragment1(), "Black Building");
        mDummyPagerAdapter.addFragment(new TabFragment2(), "Main Building");
        mDummyPagerAdapter.addFragment(new TabFragment3(), "Red Building");

        mViewPager.setAdapter(mDummyPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        return v;
    }

    private class DummyPagerAdapter extends FragmentPagerAdapter {
        private final ArrayList<Fragment> mFragmentsArrayList = new ArrayList<>();
        private final ArrayList<String> mFragmentNamesArrayList = new ArrayList<>();
        public DummyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //Return the fragment corresponding to the tab that we click
        @Override
        public Fragment getItem(int position) {
            return mFragmentsArrayList.get(position);
        }

        //Return the title corresponding to the tab that we click
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentNamesArrayList.get(position);
        }

        // Method used to add a fragment to the adapter
        public void addFragment(Fragment f, String d) {
            mFragmentsArrayList.add(f);
            mFragmentNamesArrayList.add(d);
        }

        //Return the number of total tabs
        @Override
        public int getCount() {
            return mFragmentsArrayList.size();
        }
    }
}