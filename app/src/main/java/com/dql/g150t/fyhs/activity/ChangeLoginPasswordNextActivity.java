package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改登录密码的下一步
 */
public class ChangeLoginPasswordNextActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
    TopBar topbar;
    @BindView(R.id.et_new_password)//新密码
    EditText etNewPassword;
    @BindView(R.id.et_new_password_again)//再次输入新密码
    EditText etNewPasswordAgain;
    @BindView(R.id.btn_finish)//完成按钮
    Button btnFinish;
    private Activity mActivity;
    private MyApplication application;


    @Override
    public void init() {
        mActivity = ChangeLoginPasswordNextActivity.this;
        application = (MyApplication) getApplication();
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_login_password_two;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



    @OnClick(R.id.btn_finish)
    public void onClicked(View view) {
        switch (view.getId()){
            case R.id.btn_finish://完成按钮
                break;
        }
    }
}
