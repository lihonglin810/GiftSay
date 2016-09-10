package com.lanou3g.dllo.giftsay.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.ui.adapter.GiftVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class GiftFragment extends AbsBaseFragment{
    private ViewPager mGiftVp;
    private TabLayout mGiftTb;
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
        GiftPageTab();
    }

    private void GiftPageTab() {
        List<Fragment> datas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            datas.add(new HomeSelectFragment());
        }
        GiftVpAdapter giftVpAdapter = new GiftVpAdapter(getChildFragmentManager(),datas);
        mGiftVp.setAdapter(giftVpAdapter);
        mGiftTb.setupWithViewPager(mGiftVp);
        mGiftTb.getTabAt(0).setText("每日推荐");
        mGiftTb.getTabAt(1).setText("TOP100");
        mGiftTb.getTabAt(2).setText("独立原创榜");
        mGiftTb.getTabAt(3).setText("新星榜");
    }
}
