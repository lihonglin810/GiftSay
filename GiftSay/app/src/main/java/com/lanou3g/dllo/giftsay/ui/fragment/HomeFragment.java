package com.lanou3g.dllo.giftsay.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.ui.adapter.HomeVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class HomeFragment extends AbsBaseFragment{
    private ViewPager mHomeVp;
    private TabLayout mHomeTab;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        mHomeVp = byView(R.id.homepage_vp);
        mHomeTab = byView(R.id.homepage_tb);
    }

    @Override
    protected void initDatas() {
        HomePageTab();
    }

    private void HomePageTab() {
        List<Fragment> datas = new ArrayList<>();
        datas.add(new HomeSelectFragment());
        for (int i = 0; i < 12; i++) {
            datas.add(new HomeCommonFragment());
        }
        HomeVpAdapter homeVpAdapter = new HomeVpAdapter(getChildFragmentManager(),datas);
        mHomeVp.setAdapter(homeVpAdapter);
        mHomeTab.setupWithViewPager(mHomeVp);
        mHomeTab.getTabAt(0).setText("精选");
        mHomeTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 1; i < 13; i++) {
            mHomeTab.getTabAt(i).setText("送女友");
        }
    }
}
