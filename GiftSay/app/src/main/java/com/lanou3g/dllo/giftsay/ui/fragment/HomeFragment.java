package com.lanou3g.dllo.giftsay.ui.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.HomePopBean;
import com.lanou3g.dllo.giftsay.model.net.VolleyInstance;
import com.lanou3g.dllo.giftsay.model.net.VolleyResult;
import com.lanou3g.dllo.giftsay.ui.adapter.HomePopAdapter;
import com.lanou3g.dllo.giftsay.ui.adapter.HomeVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * 主页Fragment
 */
public class HomeFragment extends AbsBaseFragment implements VolleyResult {
    private String dataUrl = "http://api.liwushuo.com/v2/channels/100/items_v2?ad=2&gender=1&generation=1&limit=20&offset=0";

    private ViewPager mHomeVp;
    private TabLayout mHomeTab;
    private ImageView popWindowImg;
    private RecyclerView pwRecyclerView;
    private List<Fragment> fragments;

    private String tuijianUrl = "http://api.liwushuo.com/v2/channels/100/items_v2?ad=2&gender=1&generation=1&limit=20&offset=0";
    private String scrollUrl = "http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=2";
    private String lunboUrl = "http://api.liwushuo.com/v2/banners?channel";

    private String girlfriendUrl = "http://api.liwushuo.com/v2/channels/10/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String haitaoUrl = "http://api.liwushuo.com/v2/channels/129/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String chuangyiUrl = "http://api.liwushuo.com/v2/channels/125/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String kejiUrl = "http://api.liwushuo.com/v2/channels/28/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String parentUrl = "http://api.liwushuo.com/v2/channels/6/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String jiyouUrl = "http://api.liwushuo.com/v2/channels/26/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String guimiUrl = "http://api.liwushuo.com/v2/channels/5/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String tongshiUrl = "http://api.liwushuo.com/v2/channels/17/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String babyUrl = "http://api.liwushuo.com/v2/channels/24/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String shejiganUrl = "http://api.liwushuo.com/v2/channels/127/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String wenyifengUrl = "http://api.liwushuo.com/v2/channels/14/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String qipaUrl = "http://api.liwushuo.com/v2/channels/126/items_v2?gender=1&limit=20&offset=0&generation=1";
    private String mengmengdaUrl = "http://api.liwushuo.com/v2/channels/11/items_v2?gender=1&limit=20&offset=0&generation=1";

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        mHomeVp = byView(R.id.homepage_vp);
        mHomeTab = byView(R.id.homepage_tb);
        popWindowImg = byView(R.id.pop_window_img);
    }

    @Override
    protected void initDatas() {
        // 数据
        buildData();
        HomePageTab();
        // 点击图片下拉出来popWindow
        popWindowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow();
//                mHomeTab.setVisibility(R.layout.change_home);
                popWindowImg.setImageResource(R.mipmap.icon_btn_arrow_up);
            }
        });
        // 网络请求
        VolleyInstance.getInstance().startRequest(dataUrl,this);

    }

    private void buildData() {
        fragments = new ArrayList<>();
        fragments.add(HomeSelectFragment.newInstance(tuijianUrl,scrollUrl,lunboUrl));
        fragments.add(HomeCommonFragment.newInstance(girlfriendUrl));
        fragments.add(HomeCommonFragment.newInstance(haitaoUrl));
        fragments.add(HomeCommonFragment.newInstance(chuangyiUrl));
        fragments.add(HomeCommonFragment.newInstance(kejiUrl));
        fragments.add(HomeCommonFragment.newInstance(parentUrl));
        fragments.add(HomeCommonFragment.newInstance(jiyouUrl));
        fragments.add(HomeCommonFragment.newInstance(guimiUrl));
        fragments.add(HomeCommonFragment.newInstance(tongshiUrl));
        fragments.add(HomeCommonFragment.newInstance(babyUrl));
        fragments.add(HomeCommonFragment.newInstance(shejiganUrl));
        fragments.add(HomeCommonFragment.newInstance(wenyifengUrl));
        fragments.add(HomeCommonFragment.newInstance(qipaUrl));
        fragments.add(HomeCommonFragment.newInstance(mengmengdaUrl));

        HomeVpAdapter homeVpAdapter = new HomeVpAdapter(getChildFragmentManager(),fragments);
        mHomeVp.setAdapter(homeVpAdapter);
        mHomeTab.setupWithViewPager(mHomeVp);
        mHomeTab.getTabAt(0).setText("精选");
        mHomeTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 1; i < fragments.size(); i++) {
            mHomeTab.getTabAt(i).setText("送女友" + i);
        }

    }

    // 显示下拉popWindow菜单
    private void showPopWindow() {
        PopupWindow pw = new PopupWindow(context);
        pw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        View view = getLayoutInflater(null).inflate(R.layout.pop_window,null);
        pwRecyclerView = (RecyclerView) view.findViewById(R.id.pop_window_rv);
        HomePopAdapter homePopAdapter = new HomePopAdapter(context);
        List<HomePopBean> datas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            datas.add(new HomePopBean("asdas"+i));
        }
        GridLayoutManager manager = new GridLayoutManager(context,4);
        pwRecyclerView.setLayoutManager(manager);
        homePopAdapter.setDatas(datas);
        pwRecyclerView.setAdapter(homePopAdapter);
        pw.setContentView(view);
        pw.setFocusable(true);
        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popWindowImg.setImageResource(R.mipmap.icon_btn_arrow_down);
            }
        });
        pw.showAsDropDown(popWindowImg);
    }

    // 上面的tablayout
    private void HomePageTab() {

    }

    @Override
    public void success(String resultStr) {
        Log.d("xxxxx", resultStr);
    }

    @Override
    public void failure() {
        Toast.makeText(context, "请重新加载", Toast.LENGTH_SHORT).show();
    }
}
