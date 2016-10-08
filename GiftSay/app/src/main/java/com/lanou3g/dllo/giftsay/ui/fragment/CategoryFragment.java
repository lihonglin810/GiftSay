package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.ui.activity.SearchActivity;
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
    private RelativeLayout relativeLayout;

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
        relativeLayout = byView(R.id.category_title_layout);
    }

    @Override
    protected void initDatas() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(SearchActivity.class);
            }
        });
        CategoryPageTab();
    }

    private void CategoryPageTab() {
        List<Fragment> datas = new ArrayList<>();
        datas.add(CategoryStrategyFragment.newInstance(ConstantBean.CATEGORY_RV_URL,ConstantBean.CATEGORY_LV_URL));
        datas.add(CategorySingleFragment.newInstance(ConstantBean.CATEGORY_SINGLE_URL));
        CategoryAdapter categoryAdapter = new CategoryAdapter(getChildFragmentManager(),datas);
        mCategoryVp.setAdapter(categoryAdapter);
        mCategoryTb.setupWithViewPager(mCategoryVp);
        mCategoryTb.getTabAt(0).setText(getResources().getString(R.string.category_fragment_title_strategy));
        mCategoryTb.getTabAt(1).setText(getResources().getString(R.string.category_fragment_title_single));
    }
}
