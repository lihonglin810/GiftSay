package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/9/8.
 * Activity的基类
 */
public abstract class AbsBaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置布局
        setContentView(setLayout());
        // 初始化组件
        initViews();
        // 初始化数据
        initDatas();
    }

    /**
     * 设置布局文件
     * @return R.layout.xxx
     */
    protected abstract int setLayout();
    /**
     * 初始化组件
     */
    protected abstract void initViews();
    /**
     * 初始化数据
     */
    protected abstract void initDatas();
    /**
     * 简化findViewById
     */
    protected <T extends View> T byView(int resId){
        return (T) findViewById(resId);
    }

    /**
     * 简化跳转页面
     * @param from 从那个页面
     * @param to 跳到那个界面
     */
    protected void goTo(Context from,Class<? extends AbsBaseActivity> to){
        Intent intent = new Intent(from,to);
        startActivity(intent);
    }

    /**
     * 简化带值跳转页面
     */
    protected void goTo(Context from,Class<? extends AbsBaseActivity> to,Bundle extras){
        Intent intent = new Intent(from,to);
        intent.putExtras(extras);
        startActivity(intent);
    }


}
