package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CollectBean;
import com.lanou3g.dllo.giftsay.model.db.LiteOrmInstance;
import com.lanou3g.dllo.giftsay.ui.adapter.CollectGvAdapter;

import java.util.List;

/**
 * 收藏activity
 */
public class CollectionActivity extends AbsBaseActivity {
    private GridView gridView;
    private List<CollectBean> datas;
    private CollectGvAdapter collectGvAdapter;
    private ImageView backImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initViews() {
        gridView = byView(R.id.collect_gv);
        collectGvAdapter = new CollectGvAdapter(this);
        backImg = byView(R.id.collect_back_img);
    }

    @Override
    protected void initDatas() {
        datas = LiteOrmInstance.getInstance().queryAll();
        collectGvAdapter.setDatas(datas);
        gridView.setAdapter(collectGvAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CollectionActivity.this,SingleWebActivity.class);
                datas = LiteOrmInstance.getInstance().queryAll();
                String webUrl = datas.get(position).getWebUrl();
                String name = datas.get(position).getName();
                intent.putExtra("weburl",webUrl);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        datas = LiteOrmInstance.getInstance().queryAll();
        collectGvAdapter.setDatas(datas);
        gridView.setAdapter(collectGvAdapter);
    }
}
