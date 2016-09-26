package com.lanou3g.dllo.giftsay.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.lanou3g.dllo.giftsay.R;

/**
 * Created by dllo on 16/9/10.
 * 登录界面Activity
 */
public class LoginActivity extends AbsBaseActivity{
    private ImageView closeImg;
    @Override
    protected int setLayout() {
        return R.layout.activity_profile_login;
    }

    @Override
    protected void initViews() {
        closeImg = byView(R.id.login_close_img);
    }

    @Override
    protected void initDatas() {
        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
