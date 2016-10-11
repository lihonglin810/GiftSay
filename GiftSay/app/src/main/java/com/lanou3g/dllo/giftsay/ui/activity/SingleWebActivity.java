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

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 单品WebActivity
 */

public class SingleWebActivity extends AbsBaseActivity {
    private WebView webView;
    private ImageView likeImg,shareImg;
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
        shareImg = byView(R.id.share_img);
    }

    @Override
    protected void initDatas() {
        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
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

    private void share() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(SingleWebActivity.this);
    }
}
