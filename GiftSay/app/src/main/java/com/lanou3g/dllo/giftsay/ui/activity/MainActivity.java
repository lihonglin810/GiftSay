package com.lanou3g.dllo.giftsay.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.UserInfoBean;
import com.lanou3g.dllo.giftsay.ui.fragment.CategoryFragment;
import com.lanou3g.dllo.giftsay.ui.fragment.GiftFragment;
import com.lanou3g.dllo.giftsay.ui.fragment.HomeFragment;
import com.lanou3g.dllo.giftsay.ui.fragment.ProfileFragment;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 主页面
 */
public class MainActivity extends AbsBaseActivity {

    private RadioGroup mRadioGroup;
    private HomeFragment mHomeFragment;
    private GiftFragment mGiftFragment;
    private CategoryFragment mCategoryFragment;
    private ProfileFragment mProfileFragment;
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, "再按一次退出[礼物说]", Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_radio_group);
        mHomeFragment = HomeFragment.newInstance();
        mGiftFragment = GiftFragment.newInstance();
        mCategoryFragment = CategoryFragment.newInstance();
        mProfileFragment = ProfileFragment.newInstance();
    }
    @Override
    protected void initDatas() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                switch (checkedId){
                    case R.id.home_rb:
                        ft.replace(R.id.main_replace_view,mHomeFragment);
                        break;
                    case R.id.gift_rb:
                        ft.replace(R.id.main_replace_view,mGiftFragment);
                        break;
                    case R.id.category_rb:
                        ft.replace(R.id.main_replace_view,mCategoryFragment);
                        break;
                    case R.id.profile_rb:
                        ft.replace(R.id.main_replace_view,mProfileFragment);
                        break;
                }
                ft.commit();
            }
        });
        mRadioGroup.check(R.id.home_rb);
    }
}
