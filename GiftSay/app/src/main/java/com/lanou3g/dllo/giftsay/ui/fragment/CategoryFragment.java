package com.lanou3g.dllo.giftsay.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ListView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.ui.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class CategoryFragment extends AbsBaseFragment{
    private ViewPager mCategoryVp;
    private TabLayout mCategoryTb;
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
        for (int i = 0; i < 2; i++) {
            datas.add(new HomeCommonFragment());
        }
        CategoryAdapter categoryAdapter = new CategoryAdapter(getChildFragmentManager(),datas);
        mCategoryVp.setAdapter(categoryAdapter);
        mCategoryTb.setupWithViewPager(mCategoryVp);
        mCategoryTb.getTabAt(0).setText("攻略");
        mCategoryTb.getTabAt(1).setText("单品");
    }
}
