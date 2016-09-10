package com.lanou3g.dllo.giftsay.ui.fragment;

import android.widget.ListView;

import com.lanou3g.dllo.giftsay.R;

/**
 * Created by dllo on 16/9/10.
 */
public class HomeCommonFragment extends AbsBaseFragment{

    private ListView commomlv;
    @Override
    protected int setLayout() {
        return R.layout.fragment_home_common;
    }

    @Override
    protected void initViews() {
        commomlv = byView(R.id.home_common_lv);
    }

    @Override
    protected void initDatas() {

    }
}
