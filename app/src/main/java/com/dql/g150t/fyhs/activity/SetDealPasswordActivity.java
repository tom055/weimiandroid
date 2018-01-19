package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MainActivity;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
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
 * 设置交易密码页面
 */
public class SetDealPasswordActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
    TopBar topbar;
    @BindView(R.id.et_new_password)//新的交易密码填写框
    EditText etNewPassword;
    @BindView(R.id.et_new_password_again)//再次输入新的交易密码
    EditText etNewPasswordAgain;
    @BindView(R.id.btn_finish)//完成按钮
    Button btnFinish;
    private Activity mActivity;
    private MyApplication application;
    private static final String Tag = "SetDealPasswordActivity";
    @Override
    public void init() {
        mActivity = SetDealPasswordActivity.this;
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
    private void setDealPwd(){
        String newPwd = etNewPassword.getText().toString();
        String newPwdAgain = etNewPasswordAgain.getText().toString();
        //密码为数字和字母组合的正则表达式
        Pattern z1_ = Pattern.compile("^(?=.*?[a-z])(?=.*?[0-9])[a-zA-Z0-9_]{6,16}$");
        //判断是否都成立，都包含返回true
        boolean pwd = z1_.matcher(newPwd).matches();
        boolean pwdAgain = z1_.matcher(newPwdAgain).matches();
        if (newPwd.isEmpty()){
            ToastUtil.showToast(mActivity,"请输入新交易密码");
            return;
        }
        if (newPwdAgain.isEmpty()){
            ToastUtil.showToast(mActivity,"请输入确认新的交易密码");
            return;
        }
        if (newPwd.length()<6||newPwd.length()>16){
            ToastUtil.showToast(mActivity,"请输入正确的交易密码");
            return;
        }
        if (newPwdAgain.length()<6||newPwdAgain.length()>16){
            ToastUtil.showToast(mActivity,"请输入正确的交易密码");
            return;
        }
        if (!newPwdAgain.equals(newPwd)){
            ToastUtil.showToast(mActivity,"两次输入的密码不一致");
            return;
        }
        if (!pwd) {
            ToastUtil.showToast(mActivity, "交易密码必须由字母和数字组成");
            return;
        }
        if (!pwdAgain) {
            ToastUtil.showToast(mActivity, "再次输入的交易密码必须由字母和数字组成");
            return;
        }
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/modifyPaymentPassword.dql")//
                .addParams("userName",getIntent().getStringExtra("phone"))
                .addParams("paymentPassword1",newPwd)
                .addParams("paymentPassword2",newPwdAgain)
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
                            String msg = jsonObject.getString("message");
                            if (status.equals("1")) {
                                ToastUtil.showToast(mActivity, msg);
                                startActivity(new Intent(mActivity,MainActivity.class));
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
        return R.layout.activity_set_deal_password;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick(R.id.btn_finish)
    public void onClicked(View view) {
        switch (view.getId()){
            case R.id.btn_finish:
                setDealPwd();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(Tag);
    }
}
