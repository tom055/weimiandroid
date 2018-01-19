package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.dql.g150t.fyhs.MainActivity;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册成功页面
 */
public class RegistSuccessActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
    TopBar topbar;
    @BindView(R.id.btn_invest)//理财按钮
    Button btnInvest;
    @BindView(R.id.btn_red_packet)//查看红包
    Button btnRedPacket;
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = RegistSuccessActivity.this;
        application = (MyApplication) getApplication();
        topbar.setRightButton(true);
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                startActivity(new Intent(mActivity,MainActivity.class));
            }

            @Override
            public void rightClick() {
                startActivity(new Intent(mActivity,LoginActivity.class));
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_regist_success;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.btn_invest, R.id.btn_red_packet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_invest://理财按钮--跳转到首页
                startActivity(new Intent(mActivity, MainActivity.class));
                break;
            case R.id.btn_red_packet:
                startActivity(new Intent(mActivity,DiscountCouponActivity.class));
                break;
        }
    }
}
