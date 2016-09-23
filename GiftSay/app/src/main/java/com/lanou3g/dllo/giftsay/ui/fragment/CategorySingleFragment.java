package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CateGorySingleBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.CategorySingleLeftLvAdapter;
import com.lanou3g.dllo.giftsay.ui.adapter.CategorySingleRightLvAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 分类界面单品Fragment
 */
public class CategorySingleFragment extends AbsBaseFragment implements VolleyResult {
    private ListView singleRightLv;
    private ListView singleLeftLv;
    private CategorySingleRightLvAdapter categorySingleRightLvAdapter;
    private CategorySingleLeftLvAdapter categorySingleLeftLvAdapter;

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
        singleLeftLv = byView(R.id.category_single_left_lv);
    }

    @Override
    protected void initDatas() {
        String singleUrl = getArguments().getString("url");
        VolleyInstance.getInstance().startRequest(singleUrl,this);
    }

    @Override
    public void success(String resultStr) {
        categorySingleRightLvAdapter = new CategorySingleRightLvAdapter(context);
        categorySingleLeftLvAdapter = new CategorySingleLeftLvAdapter(context);
        Gson gson = new Gson();
        CateGorySingleBean cateGorySingleBean = gson.fromJson(resultStr,CateGorySingleBean.class);
        List<CateGorySingleBean.DataBean.CategoriesBean> datas = cateGorySingleBean.getData().getCategories();
        categorySingleRightLvAdapter.setDatas(datas);
        categorySingleLeftLvAdapter.setDatas(datas);
        singleLeftLv.setAdapter(categorySingleLeftLvAdapter);
        singleRightLv.setAdapter(categorySingleRightLvAdapter);
        // 左边点击事件右边跟着跳
        singleLeftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                categorySingleLeftLvAdapter.setSelectPosition(position);
                categorySingleLeftLvAdapter.notifyDataSetChanged();
                singleRightLv.setSelection(position);
            }
        });
        // 右边的滑动监听
        singleRightLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int scrollState;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                this.scrollState = scrollState;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    return;
                }
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    return;
                }
                singleLeftLv.setSelection(firstVisibleItem);
                singleLeftLv.smoothScrollToPositionFromTop(firstVisibleItem - 1,0);
                categorySingleLeftLvAdapter.setSelectPosition(firstVisibleItem);
                categorySingleLeftLvAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void failure() {

    }
}
