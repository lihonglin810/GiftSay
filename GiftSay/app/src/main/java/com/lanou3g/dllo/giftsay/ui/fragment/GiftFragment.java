package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.ui.adapter.GiftVpAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/9/9.
 * 榜单Fragment
 */
public class GiftFragment extends AbsBaseFragment{
    private ViewPager mGiftVp;
    private TabLayout mGiftTb;
    private List<Fragment> fragments;
    private ImageView shareImg;

    public static GiftFragment newInstance() {
        Bundle args = new Bundle();
        GiftFragment fragment = new GiftFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_gift;
    }

    @Override
    protected void initViews() {
        mGiftVp = byView(R.id.giftpage_vp);
        mGiftTb = byView(R.id.giftpage_tb);
        shareImg = byView(R.id.gift_share);
    }

    @Override
    protected void initDatas() {
        buildData();
        GiftPageTab();
        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
    }

    private void buildData() {
        fragments = new ArrayList<>();
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.EVERYDAY_URL));
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.TOP100_URL));
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.INDEPENDENT_URL));
        fragments.add(GiftCommonFragment.newInstance(ConstantBean.NEW_STAR_URL));
    }

    private void GiftPageTab() {
        GiftVpAdapter giftVpAdapter = new GiftVpAdapter(getChildFragmentManager(),fragments);
        mGiftVp.setAdapter(giftVpAdapter);
        mGiftTb.setupWithViewPager(mGiftVp);
        mGiftTb.getTabAt(0).setText(getResources().getString(R.string.gift_tab_title_everyday));
        mGiftTb.getTabAt(1).setText(getResources().getString(R.string.gift_tab_title_top100));
        mGiftTb.getTabAt(2).setText(getResources().getString(R.string.gift_tab_title_independent));
        mGiftTb.getTabAt(3).setText(getResources().getString(R.string.gift_tab_title_newStar));
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
        oks.show(context);
    }
}
