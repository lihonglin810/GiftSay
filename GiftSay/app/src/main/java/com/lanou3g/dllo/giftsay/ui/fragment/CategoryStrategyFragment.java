package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryLvBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.view.MyListView;

/**
 * Created by dllo on 16/9/19.
 */
public class CategoryStrategyFragment extends AbsBaseFragment{
    private RecyclerView strategyRv;
    private MyListView strategyLv;
    private TextView allTv;

    public static CategoryStrategyFragment newInstance(String rvUrl,String lvUrl) {
        Bundle args = new Bundle();
        args.putString("rvUrl",rvUrl);
        args.putString("lvUrl",lvUrl);
        CategoryStrategyFragment fragment = new CategoryStrategyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_category_strategy;
    }

    @Override
    protected void initViews() {
        strategyRv = byView(R.id.category_strategy_rv);
        strategyLv = byView(R.id.category_strategy_lv);
        allTv = byView(R.id.category_strategy_all_tv);
    }

    @Override
    protected void initDatas() {
        // 解析数据
        String rvUrl = getArguments().getString("rvUrl");
        String lvUrl = getArguments().getString("lvUrl");
        VolleyInstance.getInstance().startRequest(rvUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Log.d("CategoryStrategyFragmen", resultStr);
            }

            @Override
            public void failure() {

            }
        });

        VolleyInstance.getInstance().startRequest(lvUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                CategoryLvBean categoryLvBean = gson.fromJson(resultStr,CategoryLvBean.class);
            }

            @Override
            public void failure() {

            }
        });
    }

}
