package com.lanou3g.dllo.giftsay.ui.app;

import android.app.Application;
import android.content.Context;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by dllo on 16/9/8.
 * 当前应用
 */
public class GiftSayApp extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        ShareSDK.initSDK(this);
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
