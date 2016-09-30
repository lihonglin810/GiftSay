package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.HomeDetailsBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;

public class WebActivity extends AbsBaseActivity {
    private WebView webView;
    private TextView likeTv,shareTv,commentTv;
    @Override
    protected int setLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.aty_web);
        likeTv = byView(R.id.aty_web_like_count_tv);
        shareTv = byView(R.id.aty_web_share_tv);
        commentTv = byView(R.id.aty_web_comment_tv);
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
        String countUrl = intent.getStringExtra("counturl");
        VolleyInstance.getInstance().startRequest(countUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                HomeDetailsBean homeDetailsBean = gson.fromJson(resultStr,HomeDetailsBean.class);
                likeTv.setText(homeDetailsBean.getData().getLikes_count()+"");
                shareTv.setText(homeDetailsBean.getData().getShares_count() + "");
                commentTv.setText(homeDetailsBean.getData().getComments_count() + "");
            }

            @Override
            public void failure() {

            }
        });
    }
}
