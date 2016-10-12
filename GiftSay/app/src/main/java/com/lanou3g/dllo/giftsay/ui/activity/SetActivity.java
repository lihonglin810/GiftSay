package com.lanou3g.dllo.giftsay.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.lanou3g.dllo.giftsay.R;

public class SetActivity extends AbsBaseActivity {
    private ImageView backImg;
    @Override
    protected int setLayout() {
        return R.layout.activity_set;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.set_back_img);
    }

    @Override
    protected void initDatas() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
