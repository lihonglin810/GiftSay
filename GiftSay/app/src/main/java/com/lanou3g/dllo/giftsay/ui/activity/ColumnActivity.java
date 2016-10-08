package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CategoryRvBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.ColumnListAdapter;

import java.util.List;

/**
 * 栏目activity
 */
public class ColumnActivity extends AbsBaseActivity {
    private ImageView backImg;
    private ListView columnLv;
    private ColumnListAdapter columnListAdapter;
    @Override
    protected int setLayout() {
        return R.layout.activity_column;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.aty_column_back_img);
        columnLv = byView(R.id.aty_column_lv);
        columnListAdapter = new ColumnListAdapter(this);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        VolleyInstance.getInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                CategoryRvBean bean = gson.fromJson(resultStr,CategoryRvBean.class);
                List<CategoryRvBean.DataBean.ColumnsBean> datas = bean.getData().getColumns();
                columnListAdapter.setDatas(datas);
                columnLv.setAdapter(columnListAdapter);
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
