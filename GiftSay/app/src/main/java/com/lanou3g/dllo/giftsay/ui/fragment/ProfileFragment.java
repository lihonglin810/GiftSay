package com.lanou3g.dllo.giftsay.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.dllo.giftsay.R;
import com.lanou3g.dllo.giftsay.model.bean.UserInfoBean;
import com.lanou3g.dllo.giftsay.ui.activity.CollectionActivity;
import com.lanou3g.dllo.giftsay.ui.activity.LoginActivity;
import com.lanou3g.dllo.giftsay.ui.activity.SetActivity;
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
    private AlertDialog alertDialog;
    private ImageView setImg;

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
        setImg = byView(R.id.profile_settings);
    }

    @Override
    protected void initDatas() {
        // 将获取到的用户信息存到sp中
        SharedPreferences sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        String name = sp.getString("name","请登录");
        String icon = sp.getString("icon","123");
        if (icon == "123") {
            loginAvatarImg.setImageResource(R.mipmap.me_avatar_boy);
            loginAvatarNameTv.setText("请登录");
        }else {
            loginAvatarNameTv.setText(name);
            Picasso.with(context).load(icon).into(loginAvatarImg);
        }
        EventBus.getDefault().register(this);
        // 设置
        setImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(SetActivity.class);
            }
        });
        radioButtonClick();// 两个radioButton的切换
        loginAvatarImg.setOnClickListener(this);// 登录
        // 收藏
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(CollectionActivity.class);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(UserInfoBean bean){
        loginAvatarNameTv.setText(bean.getName());
        Picasso.with(context).load(bean.getIcon()).into(loginAvatarImg);
        SharedPreferences sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name",bean.getName());
        editor.putString("icon",bean.getIcon());
        editor.commit();
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
                SharedPreferences sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                if (sp.getString("name", "123").equals("123")) {
                    goTo(LoginActivity.class);
                }else {
                    showDialog();
                }
                break;
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("确认退出吗???");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setPositiveButton("是的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "退出成功", Toast.LENGTH_SHORT).show();
                SharedPreferences sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                loginAvatarImg.setImageResource(R.mipmap.me_avatar_boy);
                loginAvatarNameTv.setText("请登录");
            }
        });
        builder.setNegativeButton("不退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "不退出", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "滚蛋", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
