package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.HomeCommonBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.HomeCommonAdapter;

import java.util.List;


/**
 * Created by dllo on 16/9/10.
 * 主页的复用Fragment
 */
public class HomeCommonFragment extends AbsBaseFragment implements VolleyResult {

    private ListView commomlv;
    private HomeCommonAdapter homeCommonAdapter;

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
        homeCommonAdapter = new HomeCommonAdapter(context);
        commomlv.setAdapter(homeCommonAdapter);
    }

    @Override
    protected void initDatas() {
        String url = getArguments().getString("url");
        VolleyInstance.getInstance().startRequest(url,this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        HomeCommonBean homeCommonBean = gson.fromJson(resultStr,HomeCommonBean.class);
        List<HomeCommonBean.DataBean.ItemsBean> datas = homeCommonBean.getData().getItems();
        homeCommonAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }
}
