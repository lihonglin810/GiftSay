package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.GiftCommonBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.GiftCommonAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 分类页的复用Fragment
 */
public class GiftCommonFragment extends AbsBaseFragment implements VolleyResult {
    
    private ImageView titleImg;
    private RecyclerView giftRecyclerView;
    private GiftCommonAdapter giftCommonAdapter;


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
        titleImg = byView(R.id.gift_common_title_img);
        giftRecyclerView = byView(R.id.gift_common_rv);
    }

    @Override
    protected void initDatas() {

        String url = getArguments().getString("url");
        VolleyInstance.getInstance().startRequest(url,this);

        giftCommonAdapter = new GiftCommonAdapter(context);
        GridLayoutManager manager = new GridLayoutManager(context,2);
        giftRecyclerView.setLayoutManager(manager);
        giftRecyclerView.setAdapter(giftCommonAdapter);

    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        GiftCommonBean giftCommonBean = gson.fromJson(resultStr,GiftCommonBean.class);
        GiftCommonBean.DataBean dataBean = giftCommonBean.getData();
        String url = dataBean.getCover_image();
        Picasso.with(context).load(url).into(titleImg);
        List<GiftCommonBean.DataBean.ItemsBean> datas = dataBean.getItems();
        giftCommonAdapter.setDatas(datas);
    }

    @Override
    public void failure() {
        Toast.makeText(context, "请重新加载", Toast.LENGTH_SHORT).show();
    }
}
