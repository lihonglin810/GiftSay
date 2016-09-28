package com.lanou3g.dllo.giftsay.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryLvBean;
import com.lanou3g.dllo.giftsay.model.bean.CategoryRvBean;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.model.interfaces.OnRvItemClick;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.activity.ColumnActivity;
import com.lanou3g.dllo.giftsay.ui.adapter.CategoryListViewAdapter;
import com.lanou3g.dllo.giftsay.ui.adapter.CategoryRvAdapter;
import com.lanou3g.dllo.giftsay.view.MyListView;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * 分类界面攻略Fragment
 */
public class CategoryStrategyFragment extends AbsBaseFragment{
    private RecyclerView strategyRv;
    private MyListView strategyLv;
    private CategoryListViewAdapter categoryListViewAdapter;
    private CategoryRvAdapter categoryRvAdapter;

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
    }

    @Override
    protected void initDatas() {

        // 解析数据
        String rvUrl = getArguments().getString("rvUrl");
        String lvUrl = getArguments().getString("lvUrl");
        VolleyInstance.getInstance().startRequest(rvUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                categoryRvAdapter = new CategoryRvAdapter(context);
                Gson gson = new Gson();
                CategoryRvBean categoryRvBean = gson.fromJson(resultStr,CategoryRvBean.class);
                List<CategoryRvBean.DataBean.ColumnsBean> datas = categoryRvBean.getData().getColumns();
                categoryRvAdapter.setDatas(datas);
                strategyRv.setAdapter(categoryRvAdapter);
                GridLayoutManager manager = new GridLayoutManager(context,3, LinearLayoutManager.HORIZONTAL,false);
                strategyRv.setLayoutManager(manager);
                categoryRvAdapter.setOnRvItemClick(new OnRvItemClick() {
                    @Override
                    public void onRvItemClickListener(int position, Object o) {
                        int type = categoryRvAdapter.getItemViewType(position);
                        switch (type){
                            case 0: // 列表
                                Toast.makeText(context, "点击的列表", Toast.LENGTH_SHORT).show();
                                break;
                            case 1: // 最后的图片
                                goTo(ColumnActivity.class, ConstantBean.CATEGORY_RV_ALL_URL);
                                break;
                        }
                    }
                });
            }

            @Override
            public void failure() {

            }
        });

        VolleyInstance.getInstance().startRequest(lvUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                categoryListViewAdapter = new CategoryListViewAdapter(context);
                Gson gson = new Gson();
                CategoryLvBean categoryLvBean = gson.fromJson(resultStr,CategoryLvBean.class);
                List<CategoryLvBean.DataBean.ChannelGroupsBean> datas = categoryLvBean.getData().getChannel_groups();
                categoryListViewAdapter.setDatas(datas);
                strategyLv.setAdapter(categoryListViewAdapter);
            }
            @Override
            public void failure() {

            }
        });
    }

}
