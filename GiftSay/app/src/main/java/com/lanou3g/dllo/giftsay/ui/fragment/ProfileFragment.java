package com.lanou3g.dllo.giftsay.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.UserInfoBean;
import com.lanou3g.dllo.giftsay.ui.activity.CollectionActivity;
import com.lanou3g.dllo.giftsay.ui.activity.LoginActivity;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by dllo on 16/9/9.
 * 个人页Fragment
 */
public class ProfileFragment extends AbsBaseFragment implements View.OnClickListener {

    private RadioGroup radioGroup;
    private CircleImageView loginAvatarImg;
    private TextView loginAvatarNameTv;
    private RelativeLayout relativeLayout;

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
        loginAvatarImg = byView(R.id.profile_avatar_img);
        loginAvatarNameTv = byView(R.id.profile_avatar_name);
        relativeLayout = byView(R.id.profile_db_layout);
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(UserInfoBean bean){
        loginAvatarNameTv.setText(bean.getName());
        Log.d("ProfileFragment", bean.getName());
        Picasso.with(context).load(bean.getIcon()).into(loginAvatarImg);
    }

    @Override
    protected void initDatas() {
        radioButtonClick();
        loginAvatarImg.setOnClickListener(this);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(CollectionActivity.class);
            }
        });
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
            case R.id.profile_avatar_img:
                goTo(LoginActivity.class);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(context);
    }
}
