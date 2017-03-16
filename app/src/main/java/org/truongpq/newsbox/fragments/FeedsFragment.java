package org.truongpq.newsbox.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.truongpq.newsbox.R;
import org.truongpq.newsbox.adapters.NewsViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedsFragment extends Fragment {
    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    public static FeedsFragment newInstance() {
        return new FeedsFragment();
    }

    public FeedsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViewPager();
        tabs.setupWithViewPager(viewpager);
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());

        List<String> titles = new ArrayList<>();
        titles.add("Tab1");
        titles.add("Tab2");
        titles.add("Tab3");
        titles.add("Tab4");
        titles.add("Tab5");
        titles.add("Tab5");
        titles.add("Tab5");
        titles.add("Tab5");
        titles.add("Tab5");
        titles.add("Tab5");

        NewsViewPagerAdapter pagerAdapter = new NewsViewPagerAdapter(getChildFragmentManager(), fragments, titles);
        viewpager.setAdapter(pagerAdapter);
    }
}
