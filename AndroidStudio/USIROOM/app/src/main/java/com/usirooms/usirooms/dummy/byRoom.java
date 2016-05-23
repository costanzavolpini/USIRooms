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
 * Created by costanzavolpini on 17/05/16.
 */
public class byRoom extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private DummyPagerAdapter mDummyPagerAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.by_room, container, false);
        mTabLayout = (TabLayout) getActivity().findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) v.findViewById(R.id.pager);

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

        @Override
        public Fragment getItem(int position) {
            return mFragmentsArrayList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentNamesArrayList.get(position);
        }

        /**
         * Method used to add a fragment to the adapter
         * @param f The fragment
         * @param d It's description/title
         */
        public void addFragment(Fragment f, String d) {
            mFragmentsArrayList.add(f);
            mFragmentNamesArrayList.add(d);
        }

        @Override
        public int getCount() {
            return mFragmentsArrayList.size();
        }
    }
}