package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 修改交易密码
 */
public class ChangeDealPasswordActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.et_old_password)//旧的交易密码
            EditText etOldPassword;
    @BindView(R.id.et_new_password)//新的交易密码
            EditText etNewPassword;
    @BindView(R.id.et_new_password_again)//再次输入新的交易密码
            EditText etNewPasswordAgain;
    @BindView(R.id.btn_next)//下一步按钮
            Button btnNext;
    @BindView(R.id.tv_forget_deal_password)//忘记交易密码按钮
            TextView tvForgetDealPassword;
    private Activity mActivity;
    private MyApplication application;
    private static final String Tag = "ChangeDealPasswordActivity";

    @Override
    public void init() {
        mActivity = ChangeDealPasswordActivity.this;
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

    private void setPayPassword(){
        String oldPwd = etOldPassword.getText().toString();
        String newPwd = etNewPassword.getText().toString();
        String newPwdAgain = etNewPasswordAgain.getText().toString();
        if (oldPwd.isEmpty()){
            ToastUtil.showToast(mActivity,"请输入旧的交易密码");
            return;
        }
        if (newPwd.isEmpty()){
            ToastUtil.showToast(mActivity,"请输入新的交易密码");
            return;
        }
        if (newPwdAgain.isEmpty()){
            ToastUtil.showToast(mActivity,"请再次输入新的交易密码");
            return;
        }
        if (!newPwdAgain.equals(newPwd)){
            ToastUtil.showToast(mActivity,"两次输入的密码不一致");
            return;
        }
        if (oldPwd.length()<6||oldPwd.length()>16){
            ToastUtil.showToast(mActivity,"请输入正确的旧交易密码");
            return;
        }
        if (newPwd.length()<6||newPwd.length()>16){
            ToastUtil.showToast(mActivity,"请输入正确的新交易密码");
            return;
        }
        if (newPwdAgain.length()<6||newPwdAgain.length()>16){
            ToastUtil.showToast(mActivity,"请输入正确的确认新交易密码");
            return;
        }
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/modifyPayPwd.dql")//
                .addParams("userid",application.userId)
                .addParams("oldPayPassword",oldPwd)
                .addParams("newPayPassword1",newPwd)
                .addParams("newPayPassword2",newPwdAgain)
                .tag(Tag)
                .build()//
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("ll_yh", "登录失败404");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("ll_yh", "登陆结果： " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String msg = jsonObject.getString("msg");
                            if (status.equals("1")) {
                                ToastUtil.showToast(mActivity, msg);
                                finish();
                            } else if (status.equals("0")) {
                                ToastUtil.showToast(mActivity, msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_deal_password;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.btn_next, R.id.tv_forget_deal_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_next://修改交易密码按钮
                setPayPassword();
                break;
            case R.id.tv_forget_deal_password://忘记密码按钮
                startActivity(new Intent(mActivity, ForgetDealPasswordActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(Tag);
    }
}
