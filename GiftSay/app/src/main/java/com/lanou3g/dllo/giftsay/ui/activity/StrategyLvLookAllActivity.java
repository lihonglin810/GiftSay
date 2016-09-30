package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryLvBean;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.ui.adapter.StrategyLvLookAllAdapter;

import java.util.List;

public class StrategyLvLookAllActivity extends AbsBaseActivity {
    private ImageView backImg;
    private TextView titleTv;
    private GridView gridView;
    private List<CategoryLvBean.DataBean.ChannelGroupsBean.ChannelsBean> list;
    private StrategyLvLookAllAdapter strategyLvLookAllAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_strategy_lv_look_all;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.aty_strategy_look_all_back_img);
        titleTv = byView(R.id.aty_strategy_look_all_title);
        gridView = byView(R.id.aty_strategy_look_all_gv);
        strategyLvLookAllAdapter = new StrategyLvLookAllAdapter(this);
    }

    @Override
    protected void initDatas() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        list = (List<CategoryLvBean.DataBean.ChannelGroupsBean.ChannelsBean>) intent.getSerializableExtra("list");
        strategyLvLookAllAdapter.setDatas(list);
        gridView.setAdapter(strategyLvLookAllAdapter);
        titleTv.setText(title);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StrategyLvLookAllActivity.this, StrategyLvDetailsActivity.class);
                String idUrl = list.get(position).getId() + "";
                String url = ConstantBean.STRATEGY_LV_DETAILS_URL + idUrl + ConstantBean.STRATEGY_LV_DETAILS_PINJIE_URL;
                String name = list.get(position).getName();
                intent.putExtra("url",url);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
