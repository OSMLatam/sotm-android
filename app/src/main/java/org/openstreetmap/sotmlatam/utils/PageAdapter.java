package org.openstreetmap.sotmlatam.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.openstreetmap.sotmlatam.fragments.ProgramFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


/**
 * Created by laura on 8/8/2016.
 */
public class PageAdapter extends FragmentStatePagerAdapter {

    String[] titles = { "Auditorio", "Mezanino"};
    HashMap<Integer, ProgramFragment> myMap;
    String date;
    public PageAdapter(FragmentManager fm) {
        super(fm);
        myMap = new HashMap<Integer, ProgramFragment>();
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Fragment getItem(int position) {

    switch (position) {
            case 0:
                ProgramFragment fragment = ProgramFragment.newInstance(date,titles[position]);
                myMap.put(position, fragment);
                return fragment;
            case 1:
                ProgramFragment fragment2 = ProgramFragment.newInstance(date,titles[position]);
                myMap.put(position, fragment2);
                return fragment2;

            default:
              return  myMap.get(position);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public HashMap<Integer, ProgramFragment> getMyMap() {
        return myMap;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }
}
