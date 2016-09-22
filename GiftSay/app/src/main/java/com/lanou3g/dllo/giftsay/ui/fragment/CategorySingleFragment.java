package com.lanou3g.dllo.giftsay.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

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
    private TextView titleTv;
    private int lastposition;

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
        LeftlistToRightlist(); // 左边点击事件右边跟着跳
    }

    private void LeftlistToRightlist() {
        singleLeftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int firstVisibleItem = singleRightLv.getFirstVisiblePosition();
                updateLeftListview(firstVisibleItem, position);
            }
        });
    }

    private void updateLeftListview(int firstVisibleItem, int position) {
        TextView lastItemTv = (TextView) singleLeftLv.findViewWithTag(lastposition);
        if (lastItemTv != null){
            lastItemTv.setTextColor(Color.BLACK);
        }
        TextView currentTextView = (TextView) singleLeftLv.findViewWithTag(position);
        if (currentTextView != null){
            currentTextView.setText(Color.RED);
        }
        lastposition = position;
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
    }

    @Override
    public void failure() {

    }
}
