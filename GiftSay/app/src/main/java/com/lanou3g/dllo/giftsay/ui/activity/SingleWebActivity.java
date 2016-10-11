package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.CollectBean;
import com.lanou3g.dllo.giftsay.model.db.LiteOrmInstance;

/**
 * 单品WebActivity
 */

public class SingleWebActivity extends AbsBaseActivity {
    private WebView webView;
    private ImageView likeImg;
    private boolean favourite;
    private String name;
    private String imgUrl;
    private String description;
    private String price;
    private String webUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_single_web;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.aty_single_web);
        likeImg = byView(R.id.favourite_img);
    }

    @Override
    protected void initDatas() {
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        Intent intent = getIntent();
        webUrl = intent.getStringExtra("weburl");
        imgUrl = intent.getStringExtra("imgUrl");
        name = intent.getStringExtra("name");
        description = intent.getStringExtra("description");
        price = intent.getStringExtra("price");
        webView.loadUrl(webUrl);
        likeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favourite == false){
                    likeImg.setImageResource(R.mipmap.ic_action_compact_favourite_selected);
                    favourite = true;
                    CollectBean bean = new CollectBean(name,description,price,imgUrl,webUrl);
                    LiteOrmInstance.getInstance().insert(bean);
                    Toast.makeText(SingleWebActivity.this, "喜欢成功", Toast.LENGTH_SHORT).show();
                }else if (favourite == true){
                    likeImg.setImageResource(R.mipmap.ic_action_compact_favourite_normal);
                    favourite = false;
                    LiteOrmInstance.getInstance().deleteByName(name);
                    Toast.makeText(SingleWebActivity.this, "取消喜欢成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (LiteOrmInstance.getInstance().queryByName(name).size() != 0){
            likeImg.setImageResource(R.mipmap.ic_action_compact_favourite_selected);
            favourite = true;
        }
    }
}
