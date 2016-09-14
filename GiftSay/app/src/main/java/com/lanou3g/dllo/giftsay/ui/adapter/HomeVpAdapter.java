package com.lanou3g.dllo.giftsay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 主页viewpager适配器
 */
public class HomeVpAdapter extends FragmentPagerAdapter{
    private List<Fragment> mfragments;
    private String[] titles;
    public HomeVpAdapter(FragmentManager fm,List<Fragment> mfragments) {
        super(fm);
        this.mfragments = mfragments;
        notifyDataSetChanged();
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }
//    public CharSequence getPageTitle(int position){
//        return titles[position];
//    }
}
