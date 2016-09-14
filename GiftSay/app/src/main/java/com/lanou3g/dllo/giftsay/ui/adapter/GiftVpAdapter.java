package com.lanou3g.dllo.giftsay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 榜单viewpager适配器
 */
public class GiftVpAdapter extends FragmentPagerAdapter{
    private List<Fragment> mfragments;
    public GiftVpAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.mfragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }
}
