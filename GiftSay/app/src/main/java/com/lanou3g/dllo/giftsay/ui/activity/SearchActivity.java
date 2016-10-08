package com.lanou3g.dllo.giftsay.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.model.bean.SearchHotWordBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.SearchRvAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 * 搜索Activity
 */
public class SearchActivity extends AbsBaseActivity implements VolleyResult {

    private RecyclerView searchRecyclerView;
    private SearchRvAdapter searchRvAdapter;
    private TextView cancelTv;
    private RelativeLayout relativeLayout;
    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        searchRecyclerView = byView(R.id.aty_search_rv);
        searchRvAdapter = new SearchRvAdapter(this);
        cancelTv = byView(R.id.search_cancel_tv);
        relativeLayout = byView(R.id.search_db_layout);
    }
    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().startRequest(ConstantBean.HOT_WORD_URL,this);
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        SearchHotWordBean searchHotWordBean = gson.fromJson(resultStr,SearchHotWordBean.class);
        List<String> datas = searchHotWordBean.getData().getHot_words();
        searchRvAdapter.setDatas(datas);
        searchRecyclerView.setAdapter(searchRvAdapter);
        StaggeredGridLayoutManager glm = new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL);
        searchRecyclerView.setLayoutManager(glm);
    }

    @Override
    public void failure() {

    }
}
