package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dql.g150t.fyhs.MainActivity;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.Login;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.ClearEditText;
import com.dql.g150t.fyhs.view.TopBar;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.et_phone)//手机号填写栏
    ClearEditText etPhone;
    @BindView(R.id.et_password)//登录密码填写栏
            EditText etPassword;
    @BindView(R.id.btn_login)//登录按钮
            Button btnLogin;
    @BindView(R.id.tv_forget_password)//忘记登录密码按钮
            TextView tvForgetPassword;
    @BindView(R.id.tv_regist)//快速注册按钮
            TextView tvRegist;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;
    @BindView(R.id.cb_eye)
    CheckBox cbEye;

    private Activity mActivity;
    private MyApplication application;
    private static String Tag = "LoginActivity";
    private static final String TAG = "LoginActivity";

    @Override
    public void init() {
        mActivity = LoginActivity.this;
        application = (MyApplication) getApplication();
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
//                finish();
                startActivity(new Intent(mActivity, MainActivity.class));
            }

            @Override
            public void rightClick() {

            }
        });


    }

    /*private void login() {
        String username = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (username.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入账号");
            return;
        }
        if (password.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入密码");
            return;
        }
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/login.dql")//
                .addParams("userName", username)
                .addParams("loginPassword", password)
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
                            String status = jsonObject.getString("code");
                            String userId = jsonObject.getString("userId");
                            String msg = jsonObject.getString("returnMsg");
                            if (Integer.valueOf(status) == 1) {
                                ToastUtil.showToast(mActivity, msg);
                                application.updateLoginParams(true, userId, etPhone.getText().toString());
                                startActivity(new Intent(mActivity, MainActivity.class));
                                finish();
                            } else {
                                ToastUtil.showToast(mActivity, msg);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }*/
    private void login(){
        String username = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (username.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入账号");
            return;
        }
        if (password.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入密码");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("userName", username);
        map.put("loginPassword", password);
//        map.put("inputCode" , inputCode) ;

        // showProgress();

        application.apiService.login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Login>() {
                    @Override
                    public void onCompleted() {
                        //dismissProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("loginFailed", e.toString());
                    }

                    @Override
                    public void onNext(Login user) {
                        Toast.makeText(mActivity, user.getReturnMsg(), Toast.LENGTH_SHORT).show();
                        if (user.getCode().equals("1")) {
//                            ToastUtil.showToast(mActivity, "登陆成功");
                            application.updateLoginParams(true, String.valueOf(user.getUserId()),etPhone.getText().toString());
                            startActivity(new Intent(mActivity,MainActivity.class));
                            finish();
                        }
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.btn_login, R.id.tv_forget_password, R.id.tv_regist, R.id.cb_eye})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login://登录按钮
                login();
                break;
            case R.id.tv_forget_password://忘记登录密码
                startActivity(new Intent(mActivity, ForgetPasswordActivity.class));
                break;
            case R.id.tv_regist://快速注册
                startActivity(new Intent(mActivity, RegistActivity.class));
                break;
            case R.id.cb_eye:
                cbEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        int passwordLength = etPassword.getText().length();
                        etPassword.setInputType(isChecked ?
                                (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) :
                                (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD));
                        etPassword.setSelection(passwordLength);
                    }
                });
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(Tag);
    }




}
