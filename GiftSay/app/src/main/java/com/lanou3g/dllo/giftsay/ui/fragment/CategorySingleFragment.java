package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;

import com.lanou3g.dllo.giftsay.R;

/**
 * Created by dllo on 16/9/20.
 */
public class CategorySingleFragment extends AbsBaseFragment{

    public static CategorySingleFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url",url);
        CategorySingleFragment fragment = new CategorySingleFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_category_single;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
