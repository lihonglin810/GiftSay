package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.model.bean.StrategyRvDetailsBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.StrategyRvDetailsLvAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 攻略RecyclerView详情activity
 */
public class StrategyRvDetailsActivity extends AbsBaseActivity {
    private ListView detailsListView;
    private StrategyRvDetailsLvAdapter strategyRvDetailsLvAdapter;
    private View listHeaderView;
    private TextView titleTv, likeCountTv, descriptionTv;
    private ImageView imageView;
    private RelativeLayout relativeLayout;

    @Override
    protected int setLayout() {
        return R.layout.activity_strategy_rv_details;
    }

    @Override
    protected void initViews() {
        detailsListView = byView(R.id.strategy_rv_details_lv);
        strategyRvDetailsLvAdapter = new StrategyRvDetailsLvAdapter(this);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("StrategyRvDetailsActivi", url);
        VolleyInstance.getInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                StrategyRvDetailsBean strategyRvDetailsBean = gson.fromJson(resultStr, StrategyRvDetailsBean.class);
                final List<StrategyRvDetailsBean.DataBean.PostsBean> datas = strategyRvDetailsBean.getData().getPosts();
                strategyRvDetailsLvAdapter.setDatas(datas);
                detailsListView.setAdapter(strategyRvDetailsLvAdapter);
                detailsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            String url = datas.get(position - 1).getContent_url();
                            String finalId = datas.get(position - 1).getId() + "";
                            Intent intent1 = new Intent(StrategyRvDetailsActivity.this, WebActivity.class);
                            intent1.putExtra("weburl", url);
                            intent1.putExtra("counturl", ConstantBean.HOME_COUNT_PINJIE_URL + finalId);
                            startActivity(intent1);
                        }
                    }
                });
                // ListView添加头布局
                listHeaderView = getLayoutInflater().inflate(R.layout.item_strategy_lv_header_layout, detailsListView, false);
                titleTv = (TextView) listHeaderView.findViewById(R.id.item_header_title);
                likeCountTv = (TextView) listHeaderView.findViewById(R.id.item_header_like_count);
                descriptionTv = (TextView) listHeaderView.findViewById(R.id.item_header_description);
                imageView = (ImageView) listHeaderView.findViewById(R.id.item_header_img);
                titleTv.setText(strategyRvDetailsBean.getData().getTitle());
                likeCountTv.setText(strategyRvDetailsBean.getData().getLikes_count() + "人喜欢");
                descriptionTv.setText(strategyRvDetailsBean.getData().getDescription());
                Picasso.with(StrategyRvDetailsActivity.this).load(strategyRvDetailsBean.getData().getCover_image_url()).into(imageView);
                detailsListView.addHeaderView(listHeaderView);
            }

            @Override
            public void failure() {

            }
        });
    }
}
