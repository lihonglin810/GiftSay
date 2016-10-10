package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.SingleDetailsBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.SingleDetailsAdapter;

import java.util.List;

/**
 * 单品详情activity
 */
public class SingleDetailsActivity extends AbsBaseActivity {

    private ImageView backImg;
    private TextView titleTv;
    private GridView gridView;
    private SingleDetailsAdapter singleDetailsAdapter;
    @Override
    protected int setLayout() {
        return R.layout.activity_single_details;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.single_details_back_img);
        titleTv = byView(R.id.single_details_title_tv);
        gridView = byView(R.id.item_single_details_gv);
        singleDetailsAdapter = new SingleDetailsAdapter(this);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String name = intent.getStringExtra("name");
        titleTv.setText(name);
        VolleyInstance.getInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                SingleDetailsBean singleDetailsBean = gson.fromJson(resultStr,SingleDetailsBean.class);
                final List<SingleDetailsBean.DataBean.ItemsBean> datas = singleDetailsBean.getData().getItems();
                singleDetailsAdapter.setDatas(datas);
                gridView.setAdapter(singleDetailsAdapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent1 = new Intent(SingleDetailsActivity.this,SingleWebActivity.class);
                        intent1.putExtra("weburl",datas.get(position).getUrl());
                        startActivity(intent1);
                    }
                });
            }

            @Override
            public void failure() {

            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
