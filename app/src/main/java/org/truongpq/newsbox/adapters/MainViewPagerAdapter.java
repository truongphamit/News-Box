package org.truongpq.newsbox.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.truongpq.newsbox.fragments.FeedsFragment;

/**
 * Created by truongpq on 09/03/2017.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private FeedsFragment feedsFragment;
    private FeedsFragment myFeedsFragment;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        feedsFragment = FeedsFragment.newInstance();
        myFeedsFragment = FeedsFragment.newInstance();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return feedsFragment;
            case 1:
                return myFeedsFragment;
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Feeds";
            case 1:
                return "My Feeds";
            default:
                return  null;
        }
    }
}
