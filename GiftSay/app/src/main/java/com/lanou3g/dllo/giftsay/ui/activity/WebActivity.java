package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lanou3g.dllo.giftsay.R;

public class WebActivity extends AbsBaseActivity {
    private WebView webView;
    @Override
    protected int setLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.aty_web);
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
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("weburl");
        webView.loadUrl(url);
    }
}
