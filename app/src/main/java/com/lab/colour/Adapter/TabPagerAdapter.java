package com.lab.colour.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lab.colour.Fragment.CustomRecFragment;
import com.lab.colour.Fragment.PeopleRecFragment;
import com.lab.colour.Fragment.AddReviewFragment;
import com.lab.colour.Fragment.SettingFragment;

/**
 * Created by SeoHyeonBae on 2016-09-18.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                CustomRecFragment customRecFragment = new CustomRecFragment();
                return customRecFragment;
            case 1:
                PeopleRecFragment peopleRecFragment = new PeopleRecFragment();
                return peopleRecFragment;
            case 2:
                AddReviewFragment addReviewFragment = new AddReviewFragment();
                return addReviewFragment;
            case 3:
                SettingFragment settingFragment = new SettingFragment();
                return settingFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}