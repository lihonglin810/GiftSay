package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.ConstantBean;
import com.lanou3g.dllo.giftsay.model.bean.HomePopBean;
import com.lanou3g.dllo.giftsay.model.bean.HomeTabTitleBean;
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
public class HomeFragment extends AbsBaseFragment{
    private ViewPager mHomeVp;
    private TabLayout mHomeTab;
    private ImageView popWindowImg;
    private RecyclerView pwRecyclerView;
    private List<Fragment> fragments;

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


    }

    private void buildData() {
        fragments = new ArrayList<>();
        fragments.add(HomeSelectFragment.newInstance(ConstantBean.RECOMMEND_URL,ConstantBean.SCROLL_URL,ConstantBean.CAROUSEL_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.GIRLFRIEND_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.SEA_AMOY_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.ORIGINAKITY_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.TECHNOLOGY_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.PARENT_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.SEND_JIYOU_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.SEND_GUIMI_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.SEND_TONGSHI_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.SEND_BABY_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.DESIGN_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.LITERATURE_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.CRACKPOT_URL));
        fragments.add(HomeCommonFragment.newInstance(ConstantBean.ADORABLE_URL));
        HomeVpAdapter homeVpAdapter = new HomeVpAdapter(getChildFragmentManager(),fragments);
        mHomeVp.setAdapter(homeVpAdapter);
        mHomeTab.setupWithViewPager(mHomeVp);
        mHomeTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        // 网络请求
        VolleyInstance.getInstance().startRequest(ConstantBean.TAB_TITLE_URL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                HomeTabTitleBean homeTabTitleBean = gson.fromJson(resultStr,HomeTabTitleBean.class);
                List<HomeTabTitleBean.DataBean.ChannelsBean> datas = homeTabTitleBean.getData().getChannels();
                for (int i = 0; i < fragments.size(); i++) {
                    mHomeTab.getTabAt(i).setText(datas.get(i).getName());
                }
            }

            @Override
            public void failure() {

            }
        });

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

}
