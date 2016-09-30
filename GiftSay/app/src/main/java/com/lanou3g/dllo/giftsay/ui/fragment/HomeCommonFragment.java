package com.lanou3g.dllo.giftsay.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.model.bean.HomeCommonBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.activity.WebActivity;
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
        final List<HomeCommonBean.DataBean.ItemsBean> datas = homeCommonBean.getData().getItems();
        homeCommonAdapter.setDatas(datas);
        commomlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, WebActivity.class);
                String idUrl = datas.get(position).getId() + "";
                String url = ConstantBean.HOME_PINJIE_URL + idUrl;
                intent.putExtra("weburl", url);
                intent.putExtra("counturl",ConstantBean.HOME_COUNT_PINJIE_URL + idUrl);
                startActivity(intent);
            }
        });
    }

    @Override
    public void failure() {

    }
}
