package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CateGorySingleBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.CategorySingleLvAdapter;
import com.lanou3g.dllo.giftsay.view.MyListView;

import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 分类界面单品Fragment
 */
public class CategorySingleFragment extends AbsBaseFragment implements VolleyResult {
    private ListView singleRightLv;
    private CategorySingleLvAdapter categorySingleLvAdapter;
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
        singleRightLv = byView(R.id.category_single_right_lv);
    }

    @Override
    protected void initDatas() {
        String singleUrl = getArguments().getString("url");
        VolleyInstance.getInstance().startRequest(singleUrl,this);
    }

    @Override
    public void success(String resultStr) {
        categorySingleLvAdapter = new CategorySingleLvAdapter(context);
        Gson gson = new Gson();
        CateGorySingleBean cateGorySingleBean = gson.fromJson(resultStr,CateGorySingleBean.class);
        List<CateGorySingleBean.DataBean.CategoriesBean> datas = cateGorySingleBean.getData().getCategories();
        categorySingleLvAdapter.setDatas(datas);
        singleRightLv.setAdapter(categorySingleLvAdapter);
    }

    @Override
    public void failure() {

    }
}
