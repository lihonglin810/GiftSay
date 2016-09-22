package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.GiftCommonBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.GiftNewCommonAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 分类页的复用Fragment
 */
public class GiftCommonFragment extends AbsBaseFragment implements VolleyResult {
    private RecyclerView recyclerView;
    private GiftNewCommonAdapter giftNewCommonAdapter;

    public static GiftCommonFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url",url);
        GiftCommonFragment fragment = new GiftCommonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_gift_common;
    }

    @Override
    protected void initViews() {
      recyclerView = byView(R.id.gift_common_rv);
    }

    @Override
    protected void initDatas() {
        String dataUrl = getArguments().getString("url");
        giftNewCommonAdapter = new GiftNewCommonAdapter(context);
        GridLayoutManager manager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(giftNewCommonAdapter);
        VolleyInstance.getInstance().startRequest(dataUrl, this);
    }

    @Override
    public void success(String resultStr) {
        // 解析数据
        // 1.给gridview设置数据
        // 2.gridView适配器处理2种行布局
        GiftCommonBean giftCommonBean = new Gson().fromJson(resultStr, GiftCommonBean.class);
        String imgUrl = giftCommonBean.getData().getCover_image();
        List<GiftCommonBean.DataBean.ItemsBean> datas = giftCommonBean.getData().getItems();
        giftNewCommonAdapter.setDatas(datas, imgUrl);
    }

    @Override
    public void failure() {

    }
}
