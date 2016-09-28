package com.lanou3g.dllo.giftsay.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.model.bean.HomeCommonBean;
import com.lanou3g.dllo.giftsay.model.bean.HomeSelectRvBean;
import com.lanou3g.dllo.giftsay.model.bean.RotateBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.activity.WebActivity;
import com.lanou3g.dllo.giftsay.ui.adapter.HomeCommonAdapter;
import com.lanou3g.dllo.giftsay.ui.adapter.HomeSelectRvAdapter;
import com.lanou3g.dllo.giftsay.ui.adapter.RotateVpAdapter;
import com.lanou3g.dllo.giftsay.view.MyListView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 主页第一页推荐页Fragment
 */
public class HomeSelectFragment extends AbsBaseFragment{

    private MyListView homeSelectLv;
    private RecyclerView homeSelectRv;
    private HomeCommonAdapter homeCommonAdapter;
    private HomeSelectRvAdapter homeSelectRvAdapter;

    private static final int TIME = 3000;

    private ViewPager viewPager;
    private LinearLayout pointLl;// 轮播状态改变的小圆点容器
    private List<RotateBean.DataBean.BannersBean> datas;
    private RotateVpAdapter vpAdapter;
    private TextView dateTv;

    public static HomeSelectFragment newInstance(String url,String sUrl,String lunboUrl) {
        Bundle args = new Bundle();
        args.putString("url", url);
        args.putString("surl",sUrl);
        args.putString("lunbourl",lunboUrl);
        HomeSelectFragment fragment = new HomeSelectFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_home_select;
    }

    @Override
    protected void initViews() {
        homeSelectLv = byView(R.id.home_select_lv);
        homeSelectRv = byView(R.id.home_select_rv);
        viewPager = byView(R.id.rotate_vp);
        pointLl = byView(R.id.rotate_point_container);
        dateTv = byView(R.id.jingxuan_date);
    }

    @Override
    protected void initDatas() {
        //时间获取当前时间
        String date1 = null;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        calendar.setTime(date);
        int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        if (weekIndex < 1 || weekIndex > 7) {
            date1 = null;
        }else {
            date1 = ConstantBean.WEEK[weekIndex - 1];
        }
        dateTv.setText(month + "月" + day + "日 " + date1);
        // 下面ListView的数据
        homeCommonAdapter = new HomeCommonAdapter(context);
        homeSelectLv.setAdapter(homeCommonAdapter);
        String url = getArguments().getString("url");
        VolleyInstance.getInstance().startRequest(url, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                HomeCommonBean homeCommonBean = gson.fromJson(resultStr,HomeCommonBean.class);
                final List<HomeCommonBean.DataBean.ItemsBean> datas = homeCommonBean.getData().getItems();
                homeCommonAdapter.setDatas(datas);
                homeSelectLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(context, WebActivity.class);
                        String ida = datas.get(position).getId() + "";
                        String url = "http://hawaii.liwushuo.com/posts/" + ida;
                        intent.putExtra("weburl", url);
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void failure() {

            }
        });

        // 横向RecyclerView
        homeSelectRvAdapter = new HomeSelectRvAdapter(context);
        homeSelectRv.setAdapter(homeSelectRvAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        homeSelectRv.setLayoutManager(llm);
        String surl = getArguments().getString("surl");
        VolleyInstance.getInstance().startRequest(surl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                HomeSelectRvBean homeSelectRvBean = gson.fromJson(resultStr,HomeSelectRvBean.class);
                List<HomeSelectRvBean.DataBean.SecondaryBannersBean> datas = homeSelectRvBean.getData().getSecondary_banners();
                homeSelectRvAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
        // 轮播图
        StartCarousel();
    }

    private void StartCarousel() {
        buildDatas();// 构造数据
        // 只是创建适配器,绑定适配器
        // 但是这里没有数据,buildDatas的网络成功回调里才能有数据
        vpAdapter = new RotateVpAdapter(context);
        viewPager.setAdapter(vpAdapter);

    }
    private void changePoints() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    // 把所有小点设置为白色
                    for (int i = 0; i < datas.size(); i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.btn_check_disabled);
                    }
                    // 设置当前位置小点为灰色
                    ImageView iv = (ImageView) pointLl.getChildAt(position % datas.size());
                    iv.setImageResource(R.mipmap.btn_check_disabled_nightmode);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加轮播切换小点
     */
    private void addPoints() {
        // 有多少张图加载多少个小点
        for (int i = 0; i < datas.size(); i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5,5,5,5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            pointIv.setLayoutParams(params);

            // 设置第0页小点的为灰色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.btn_check_disabled_nightmode);
            } else {
                pointIv.setImageResource(R.mipmap.btn_check_disabled);
            }
            pointLl.addView(pointIv);
        }
    }


    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;

    /**
     * 开始轮播
     */
    private void startRotate() {
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable, TIME);
    }

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }

    private void buildDatas() {
        String lunboUrl = getArguments().getString("lunbourl");
        Log.d("11111", lunboUrl);
        VolleyInstance.getInstance().startRequest(lunboUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Log.d("1111", resultStr);
                Gson gson = new Gson();
                RotateBean rotateBean = gson.fromJson(resultStr,RotateBean.class);
                datas = rotateBean.getData().getBanners();
                vpAdapter.setDatas(datas);
                // ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
                // 为了保证第一页始终为数据的第0条 取余要为0,因此设置数据集合大小的倍数
                viewPager.setCurrentItem(datas.size() * 100);
                // 开始轮播
                handler = new Handler();
                startRotate();
                // 添加轮播小点
                addPoints();
                // 随着轮播改变小点
                changePoints();
            }

            @Override
            public void failure() {

            }
        });
    }
}
