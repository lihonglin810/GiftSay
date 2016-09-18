package com.lanou3g.dllo.giftsay.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by dllo on 16/9/18.
 */
public class ScreenSizeUtil {

    public static int getScreenWidth(Context context) {
        // 首先获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将屏幕的尺寸设置给显示尺寸
        manager.getDefaultDisplay().getMetrics(metrics);
        // 返回屏幕宽度
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        // 首先获取窗口管理者
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // 创建显示尺寸类
        DisplayMetrics metrics = new DisplayMetrics();
        // 将屏幕的尺寸设置给显示尺寸
        manager.getDefaultDisplay().getMetrics(metrics);
        // 返回屏幕高度
        return metrics.heightPixels;
    }
}
