package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.ui.adapter.GiftVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 榜单Fragment
 */
public class GiftFragment extends AbsBaseFragment{
    private ViewPager mGiftVp;
    private TabLayout mGiftTb;

    private List<Fragment> fragments;
    private String meiriUrl = "http://api.liwushuo.com/v2/ranks_v2/ranks/1?limit=20&offset=0";
    private String top100Url = "http://api.liwushuo.com/v2/ranks_v2/ranks/2?limit=20&offset=0";
    private String duliUrl = "http://api.liwushuo.com/v2/ranks_v2/ranks/3?limit=20&offset=0";
    private String newStarUrl = "http://api.liwushuo.com/v2/ranks_v2/ranks/4?limit=20&offset=0";

    public static GiftFragment newInstance() {
        Bundle args = new Bundle();
        GiftFragment fragment = new GiftFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_gift;
    }

    @Override
    protected void initViews() {
        mGiftVp = byView(R.id.giftpage_vp);
        mGiftTb = byView(R.id.giftpage_tb);
    }

    @Override
    protected void initDatas() {
        buildData();
        GiftPageTab();
    }

    private void buildData() {
        fragments = new ArrayList<>();
        fragments.add(GiftCommonFragment.newInstance(meiriUrl));
        fragments.add(GiftCommonFragment.newInstance(top100Url));
        fragments.add(GiftCommonFragment.newInstance(duliUrl));
        fragments.add(GiftCommonFragment.newInstance(newStarUrl));
    }

    private void GiftPageTab() {
        GiftVpAdapter giftVpAdapter = new GiftVpAdapter(getChildFragmentManager(),fragments);
        mGiftVp.setAdapter(giftVpAdapter);
        mGiftTb.setupWithViewPager(mGiftVp);
        mGiftTb.getTabAt(0).setText("每日推荐");
        mGiftTb.getTabAt(1).setText("TOP100");
        mGiftTb.getTabAt(2).setText("独立原创榜");
        mGiftTb.getTabAt(3).setText("新星榜");
    }
}
