package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.lanou3g.dllo.giftsay.R;

/**
 * 单品WebActivity
 */

public class SingleWebActivity extends AbsBaseActivity {
    private WebView webView;
    private ImageView likeImg;
    private boolean favourite;
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
        String url = intent.getStringExtra("weburl");
        webView.loadUrl(url);
        likeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favourite == false){
                    likeImg.setImageResource(R.mipmap.ic_action_compact_favourite_selected);
                    favourite = true;
                    Toast.makeText(SingleWebActivity.this, "喜欢成功", Toast.LENGTH_SHORT).show();
                }else if (favourite == true){
                    likeImg.setImageResource(R.mipmap.ic_action_compact_favourite_normal);
                    favourite = false;
                    Toast.makeText(SingleWebActivity.this, "取消喜欢成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
