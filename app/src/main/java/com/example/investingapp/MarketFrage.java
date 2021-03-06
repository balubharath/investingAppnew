package com.example.investingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

class MarketFrage extends Fragment {

    ViewPager viewPager;

    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView
            (@NonNull LayoutInflater inflater,
             @Nullable ViewGroup container,
             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first, container, false);
        viewPager=view.findViewById(R.id.view_pager);
        //  toolbar=findViewById(R.id.toolbar);
        tabLayout=view.findViewById(R.id.tabs);

        //  setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

      //  FragmentManager fragmentManager=getActivity().getSupportFragmentManager();



        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();

        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager);
        adapter.addFragment(new OneFragment(), "Indices");
        adapter.addFragment(new TwoFragment(), "Indices Future");
        adapter.addFragment(new ThreeFragment(), "Shares");
        adapter.addFragment(new FourFragment(), "Commodities");
        adapter.addFragment(new FiveFragment(), "Currencies");
        adapter.addFragment(new SixFragment(), "Cryptocurrency");
        adapter.addFragment(new SevenFragment(), "Bonds");
        adapter.addFragment(new EightFragment(), "ETFS");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter  extends FragmentPagerAdapter  {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}