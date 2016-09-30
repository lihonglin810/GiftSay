package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.dllo.giftsay.R;
import com.squareup.picasso.Picasso;

public class FillImageActivity extends AbsBaseActivity {
    private ImageView imageView;
    @Override
    protected int setLayout() {
        return R.layout.activity_fill_image;
    }

    @Override
    protected void initViews() {
        imageView = byView(R.id.fill_img);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String imgUrl = intent.getStringExtra("url");
        Picasso.with(this).load(imgUrl).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
