package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.model.bean.StrategyLvDetailsBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.StrategyLvDetailsLvAdapter;

import java.util.List;

/**
 * 分类攻略ListView详情activity
 */
public class StrategyLvDetailsActivity extends AbsBaseActivity {
    private ImageView backImg,updownImg;
    private TextView titleTv;
    private ListView listView;
    private StrategyLvDetailsLvAdapter strategyLvDetailsLvAdapter;
    @Override
    protected int setLayout() {
        return R.layout.activity_strategy_lv_details;
    }

    @Override
    protected void initViews() {
        titleTv = byView(R.id.strategy_lv_details_title_tv);
        backImg = byView(R.id.strategy_lv_details_back_img);
        updownImg = byView(R.id.strategy_lv_details_updown_img);
        listView = byView(R.id.strategy_lv_details_lv);
        strategyLvDetailsLvAdapter = new StrategyLvDetailsLvAdapter(this);
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
        String url = intent.getStringExtra("url");
        String name = intent.getStringExtra("name");
        titleTv.setText(name);
        VolleyInstance.getInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                StrategyLvDetailsBean strategyLvDetailsBean = gson.fromJson(resultStr,StrategyLvDetailsBean.class);
                final List<StrategyLvDetailsBean.DataBean.ItemsBean> datas = strategyLvDetailsBean.getData().getItems();
                strategyLvDetailsLvAdapter.setDatas(datas);
                listView.setAdapter(strategyLvDetailsLvAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(StrategyLvDetailsActivity.this, WebActivity.class);
                        String idUrl = datas.get(position).getId() + "";
                        String url = ConstantBean.HOME_PINJIE_URL + idUrl;
                        intent.putExtra("weburl", url);
                        intent.putExtra("counturl",ConstantBean.HOME_COUNT_PINJIE_URL + idUrl);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void failure() {

            }
        });
    }
}
