package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MainActivity;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.LoginPwdFormatUtils;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 注册第一个页面
 */
public class RegistActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
            TopBar topBar;
    @BindView(R.id.et_phone)//手机号
            EditText etPhone;
    @BindView(R.id.et_password)//设置密码
            EditText etPassword;
    @BindView(R.id.et_invite)//邀请码
            EditText etInvite;
    @BindView(R.id.btn_regist_next)//登录按钮
            Button btnRegistNext;
    @BindView(R.id.ll_people_type)
    LinearLayout llPeopleType;
    @BindView(R.id.tv_people)
    TextView tvPeople;
    private Activity mActivity;
    private MyApplication application;
    private static String Tag = "RegistActivity";
    private LoginPwdFormatUtils loginPwdFormatUtils;

    @Override
    public void init() {
        mActivity = RegistActivity.this;
        application = (MyApplication) getApplication();
        topBar.setRightButton(true);
        topBar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                startActivity(new Intent(mActivity, MainActivity.class));
                finish();
            }

            @Override
            public void rightClick() {
                startActivity(new Intent(mActivity, LoginActivity.class));
            }
        });
        defaultPersonType();
    }

    //获取验证码
    private void getcode() {
        String phone = etPhone.getText().toString();
        String password = etPassword.getText().toString();
        //密码为数字和字母组合的正则表达式
        Pattern z1_ = Pattern.compile("^(?=.*?[a-z])(?=.*?[0-9])[a-zA-Z0-9_]{6,16}$");
        //判断是否都成立，都包含返回true
        boolean pwd = z1_.matcher(password).matches();
        if (phone.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入手机号");
            return;
        }
        if (password.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入登录密码");
            return;
        }
        if (phone.length() < 11 || phone.length() > 11) {
            ToastUtil.showToast(mActivity, "请输入正确的手机号");
            return;
        }
        if (password.length() < 6 || password.length() > 16) {
            ToastUtil.showToast(mActivity, "登录密码的位数请设置在6-16位之间");
            return;
        }
        if (!pwd) {
            ToastUtil.showToast(mActivity, "登录密码必须由字母和数字组成");
            return;
        }
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/registCode.dql")//
                .addParams("mobilePhone", phone)
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
                                Intent intent = new Intent(mActivity, NextRegistActivity.class);
                                intent.putExtra("phone", etPhone.getText().toString());
                                intent.putExtra("password", etPassword.getText().toString());
                                intent.putExtra("type", tvPeople.getText().toString());
                                startActivity(intent);
                            } else if (status.equals("0")) {
                                ToastUtil.showToast(mActivity, msg);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 默认个人注册
     */
    private void defaultPersonType() {
        tvPeople.setText("个人用户");
    }

    private void selectPerson() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("请选择注册账户的类型");
        builder.setTitle("选择");
        builder.setPositiveButton("个人用户", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvPeople.setText("个人用户");

            }
        });

        builder.setNegativeButton("企业用户", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvPeople.setText("企业用户");
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.btn_regist_next, R.id.ll_people_type})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_regist_next:
                getcode();
                break;
            case R.id.ll_people_type:
                selectPerson();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(Tag);
    }
}
