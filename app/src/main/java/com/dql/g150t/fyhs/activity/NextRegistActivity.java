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
import com.dql.g150t.fyhs.model.Login;
import com.dql.g150t.fyhs.model.Protocol;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TimeButtonView;
import com.dql.g150t.fyhs.view.TopBar;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 注册的第2个页面
 */
public class NextRegistActivity extends BaseActivity {


    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.tv_phone)//从上个页面获取到的手机号
            TextView tvPhone;
    @BindView(R.id.et_code)//验证码输入框
            EditText etCode;
    @BindView(R.id.time_button)//短信验证码按钮
            TimeButtonView timeButton;
    @BindView(R.id.btn_finish)//完成按钮
            Button btnFinish;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;

    private Activity mActivity;
    private MyApplication application;
    private String phone;
    private String password;
    private String type;
    private static String Tag = "NextRegistActivity";
    private static final String TAG = "NextRegistActivity";

    @Override
    public void init() {
        mActivity = NextRegistActivity.this;
        application = (MyApplication) getApplication();
        topbar.setRightButton(true);
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                startActivity(new Intent(mActivity, LoginActivity.class));
            }
        });
        /*etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                timeButton.setText(1,charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/
        msg();

    }

    private void msg() {
        phone = getIntent().getStringExtra("phone");
        password = getIntent().getStringExtra("password");
        type = getIntent().getStringExtra("type");
        Log.e("sss", "msg: " + phone + "");
        Log.e("sss", "msg: " + password + "");
        tvPhone.setText(phone + "");
    }

    private void registPerson() {
        String code = etCode.getText().toString().trim();
        if (code.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入验证码");
            return;
        }

        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/regist.dql")//
                .addParams("mobilePhone", getIntent().getStringExtra("phone"))
                .addParams("loginPassword1", getIntent().getStringExtra("password"))
                .addParams("inputMobileCode", code + "")
                .addParams("platform_id", "4")
                .addParams("style", "1")
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
                            String status = jsonObject.getString("retCode");
                            String msg = jsonObject.getString("returnMsg");
                            if (status.equals("0")) {
                                ToastUtil.showToast(mActivity, msg);
                                startActivity(new Intent(mActivity, RegistSuccessActivity.class));
                            } else {
                                ToastUtil.showToast(mActivity, msg);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    private void registCompany() {
        String code = etCode.getText().toString().trim();
        if (code.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入验证码");
            return;
        }

        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/regist.dql")//
                .addParams("mobilePhone", getIntent().getStringExtra("phone"))
                .addParams("loginPassword1", getIntent().getStringExtra("password"))
                .addParams("inputMobileCode", code + "")
                .addParams("platform_id", "4")
                .addParams("style", "2")
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
                            String status = jsonObject.getString("retCode");
                            String msg = jsonObject.getString("returnMsg");
                            if (status.equals("0")) {
                                ToastUtil.showToast(mActivity, msg);
                                startActivity(new Intent(mActivity, RegistSuccessActivity.class));
                            } else {
                                ToastUtil.showToast(mActivity, msg);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void getCode() {
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_user/registCode.dql")//
                .addParams("mobilePhone", getIntent().getStringExtra("phone"))
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
                            } else if (status.equals("0")) {
                                ToastUtil.showToast(mActivity, msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void login() {

        Map<String, String> map = new HashMap<>();
        map.put("userName", getIntent().getStringExtra("phone"));
        map.put("loginPassword", getIntent().getStringExtra("password"));
        application.apiService.login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Login>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("loginFailed", e.toString());
                    }

                    @Override
                    public void onNext(Login user) {

                        if (user.getCode().equals("1")) {
                            application.updateLoginParams(true, String.valueOf(user.getUserId()), getIntent().getStringExtra("phone"));
                        }
                    }
                });
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_next_regist;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.time_button, R.id.btn_finish, R.id.tv_agreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time_button:
                getCode();
                break;
            case R.id.btn_finish:
                if (getIntent().getStringExtra("type").equals("个人用户")) {
                    registPerson();
                    login();
                } else if (getIntent().getStringExtra("type").equals("企业用户")) {
                    registCompany();
                    login();
                }
                break;
            case R.id.tv_agreement:
                application.apiService.toProtocol()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Protocol>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Protocol protocol) {
                                Intent intent = new Intent(mActivity, ProtocolActivity.class);
                                intent.putExtra("protocol", protocol.getRegProtocol());
                                startActivity(intent);
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
