package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.ui.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 分类Fragment
 */
public class CategoryFragment extends AbsBaseFragment{
    private ViewPager mCategoryVp;
    private TabLayout mCategoryTb;
    private String strategyUrl = "http://api.liwushuo.com/v2/columns";
    private String columnUrl = "http://api.liwushuo.com/v2/channel_groups/all";
    private String singleUrl = "";

    public static CategoryFragment newInstance() {
        Bundle args = new Bundle();
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initViews() {
        mCategoryVp = byView(R.id.category_vp);
        mCategoryTb = byView(R.id.category_tb);
    }

    @Override
    protected void initDatas() {
        CategoryPageTab();
    }

    private void CategoryPageTab() {
        List<Fragment> datas = new ArrayList<>();
        datas.add(CategoryStrategyFragment.newInstance(strategyUrl,columnUrl));
        datas.add(CategorySingleFragment.newInstance(singleUrl));
        CategoryAdapter categoryAdapter = new CategoryAdapter(getChildFragmentManager(),datas);
        mCategoryVp.setAdapter(categoryAdapter);
        mCategoryTb.setupWithViewPager(mCategoryVp);
        mCategoryTb.getTabAt(0).setText("攻略");
        mCategoryTb.getTabAt(1).setText("单品");
    }
}
