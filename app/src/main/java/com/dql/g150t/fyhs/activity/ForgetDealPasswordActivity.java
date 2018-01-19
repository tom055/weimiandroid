package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TimeButton;
import com.dql.g150t.fyhs.view.TopBar;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 找回交易密码
 */
public class ForgetDealPasswordActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.et_phone)//手机号填写栏
            EditText etPhone;
    @BindView(R.id.et_code)//验证码填写栏
            EditText etCode;
    @BindView(R.id.time_button)//获取短信验证码按钮
            TimeButton timeButton;
    @BindView(R.id.btn_next)//下一步按钮
            Button btnNext;
    private Activity mActivity;
    private MyApplication application;
    private static final String Tag = "ForgetDealPasswordActiv";


    @Override
    public void init() {
        mActivity = ForgetDealPasswordActivity.this;
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
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                timeButton.setMobile(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * 获取短信验证码
     *
     * @return
     */
    private void getCode() {
        String phone = etPhone.getText().toString();
        String code = etCode.getText().toString();
        if (phone.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入手机号");
            return;
        }
        if (phone.length() < 11 || phone.length() > 11) {
            ToastUtil.showToast(mActivity, "请输入正确的手机号");
            return;
        }
        if (code.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入验证码");
        }
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/getCode.dql")//
                .addParams("userName", phone + "")
                .addParams("type", "忘记交易密码")
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
                            } else if (status.equals("0")) {
                                ToastUtil.showToast(mActivity, msg);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
       /* Map<String, String> map = new HashMap<>();
        map.put("userName", phone);
        map.put("type", "忘记交易密码");
        application.apiService.getCode(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Code>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Code code) {
                        if (code.getStatus().equals("1")) {
                            if (code.equals(code.getMobileCode())){
                                ToastUtil.showToast(mActivity, code.getMessage());
                            }else{
                                ToastUtil.showToast(mActivity,"验证码不正确");
                                return;
                            }
                        } else {
                            ToastUtil.showToast(mActivity, code.getMessage());
                            return;
                        }
                    }
                });*/
    }
    private void checkCode() {
        String phone = etPhone.getText().toString().trim();
        String code = etCode.getText().toString().trim();
        if (phone.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入手机号");
            return;
        }
        if (phone.length() < 11 || phone.length() > 11) {
            ToastUtil.showToast(mActivity, "请输入正确的手机号");
            return;
        }
        if (code.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入验证码");
            return;
        }
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/checkCode.dql")//
                .addParams("userName", phone + "")
                .addParams("inputMobileCode", code + "")
                .addParams("mobileCode", code + "")
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
                                Intent intent = new Intent(mActivity, SetDealPasswordActivity.class);
                                intent.putExtra("phone", etPhone.getText().toString());
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget_deal_password;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.time_button, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time_button://短信验证码按钮
                getCode();
                break;
            case R.id.btn_next://下一步跳转到找回密码下一步
                checkCode();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(Tag);
    }
}
