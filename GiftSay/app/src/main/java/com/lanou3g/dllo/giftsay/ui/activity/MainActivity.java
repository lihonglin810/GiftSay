package com.lanou3g.dllo.giftsay.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.ui.fragment.CategoryFragment;
import com.lanou3g.dllo.giftsay.ui.fragment.GiftFragment;
import com.lanou3g.dllo.giftsay.ui.fragment.HomeFragment;
import com.lanou3g.dllo.giftsay.ui.fragment.ProfileFragment;

/**
 * 主页面
 */
public class MainActivity extends AbsBaseActivity {

    private RadioGroup mRadioGroup;
    private HomeFragment mHomeFragment;
    private GiftFragment mGiftFragment;
    private CategoryFragment mCategoryFragment;
    private ProfileFragment mProfileFragment;

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
