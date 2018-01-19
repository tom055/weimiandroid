package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改登录密码第一页
 * 跳转到setLoginPasswordTwo
 */
public class ChangeLoginPasswordActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
    TopBar topbar;
    @BindView(R.id.et_old_password)//旧的登录密码
    EditText etOldPassword;
    @BindView(R.id.btn_next)//下一步按钮
    Button btnNext;
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = ChangeLoginPasswordActivity.this;
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
    private void oldPassword(){
        String oldPassword = etOldPassword.getText().toString();
        if (oldPassword.isEmpty()){
            ToastUtil.showToast(mActivity,"请输入旧的登录密码");
        }
        if (oldPassword.length()<6||oldPassword.length()>16){
            ToastUtil.showToast(mActivity,"请输入正确的登录密码");
        }
        Intent intent = new Intent(this, SetLoginPasswordTwoActivity.class);
        intent.putExtra("oldPassword",etOldPassword.getText().toString());
        startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_login_password;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



    @OnClick(R.id.btn_next)
    public void onClicked(View view) {
        switch (view.getId()){
            case R.id.btn_next://点击下一步跳转到下个页面
                oldPassword();
                break;
        }
    }
}
