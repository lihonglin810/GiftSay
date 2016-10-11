package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.UserInfoBean;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by dllo on 16/9/10.
 * 登录界面Activity
 */
public class LoginActivity extends AbsBaseActivity{
    private ImageView closeImg;
    private ImageView qqImg;
    private EventBus eventBus;
    @Override
    protected int setLayout() {
        return R.layout.activity_profile_login;
    }

    @Override
    protected void initViews() {
        closeImg = byView(R.id.login_close_img);
        qqImg = byView(R.id.login_qq);
        eventBus = EventBus.getDefault();
    }

    @Override
    protected void initDatas() {
        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        qqImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取第三方平台
                Platform platform = ShareSDK.getPlatform(LoginActivity.this, QQ.NAME);
                platform.authorize();
                // 获取用户信息
                platform.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
                        // 获取qq头像和名字
                        PlatformDb db = platform.getDb();
                        String name = db.getUserName();
                        String icon = db.getUserIcon();
                        UserInfoBean bean = new UserInfoBean();
                        bean.setName(name);
                        bean.setIcon(icon);
                        eventBus.post(bean);
                        finish();
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        Toast.makeText(LoginActivity.this, "错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {
                        Toast.makeText(LoginActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
