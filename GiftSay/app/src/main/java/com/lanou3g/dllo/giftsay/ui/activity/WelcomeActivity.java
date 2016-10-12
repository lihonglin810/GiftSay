package com.lanou3g.dllo.giftsay.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.lanou3g.dllo.giftsay.R;

public class WelcomeActivity extends AbsBaseActivity {

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        handler.sendEmptyMessageDelayed(0,3000);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
