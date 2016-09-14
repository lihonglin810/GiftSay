package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.ui.activity.LoginActivity;


/**
 * Created by dllo on 16/9/9.
 * 个人页Fragment
 */
public class ProfileFragment extends AbsBaseFragment implements View.OnClickListener {

    private RadioGroup radioGroup;
    private ImageView loginAvatarImg;

    public static ProfileFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initViews() {
        radioGroup = byView(R.id.profile_radiogroup);
        loginAvatarImg = byView(R.id.profile_avatar);
    }

    @Override
    protected void initDatas() {
        radioButtonClick();
        loginAvatarImg.setOnClickListener(this);
    }

    private void radioButtonClick() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.profile_single_radiobutton:
                        break;
                    case R.id.profile_strategy_radiobutton:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profile_avatar:
                goTo(LoginActivity.class);
                break;
        }
    }
}
