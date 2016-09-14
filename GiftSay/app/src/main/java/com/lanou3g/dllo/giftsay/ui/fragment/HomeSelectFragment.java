package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;

import com.lanou3g.dllo.giftsay.R;

/**
 * Created by dllo on 16/9/10.
 * 主页第一页推荐页Fragment
 */
public class HomeSelectFragment extends AbsBaseFragment{

    public static HomeSelectFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        HomeSelectFragment fragment = new HomeSelectFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_home_select;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
