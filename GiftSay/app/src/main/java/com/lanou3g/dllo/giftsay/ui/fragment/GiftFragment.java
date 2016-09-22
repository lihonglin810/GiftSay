package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
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
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.EVERYDAY_URL));
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.TOP100_URL));
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.INDEPENDENT_URL));
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.NEW_STAR_URL));
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
