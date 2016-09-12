package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;

/**
 * Created by dllo on 16/9/10.
 */
public class HomeCommonFragment extends AbsBaseFragment{

    private ListView commomlv;
    private TextView showTv;

    public static HomeCommonFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url", url);
        HomeCommonFragment fragment = new HomeCommonFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_home_common;
    }

    @Override
    protected void initViews() {
        commomlv = byView(R.id.home_common_lv);
        showTv = byView(R.id.show_tv);
    }

    @Override
    protected void initDatas() {
        showTv.setText(getArguments().getString("url"));
    }
}
