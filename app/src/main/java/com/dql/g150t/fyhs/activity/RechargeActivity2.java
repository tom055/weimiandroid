package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;
import com.fuiou.mobile.FyPay;
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
 * 充值页面
 */
public class RechargeActivity2 extends BaseActivity {

    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.et_code)//银行logo
            TextView etCode;

    @BindView(R.id.btn_submit)//提交按钮
            Button btnSubmit;

    /*@BindView(R.id.et_bill_number)
    EditText etBillNumber;*/
    private Activity mActivity;
    private MyApplication application;
    private static final String TAG = "RechargeActivity";


    @Override
    public void init() {
        mActivity = RechargeActivity2.this;
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
     //  bankcard();


    }



    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge_step2;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick(R.id.btn_submit)
    public void onClicked(View view) {

        String code = etCode.getText()+"";

        if (TextUtils.isEmpty(code)) {
            ToastUtil.showToast(mActivity, "请输入验证码");
            return;
        }
        showProgress();
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_home/rechargexinhestep2.dql")//
                .addParams("code", code)
                .addParams("orderId", getIntent().getStringExtra("orderId"))
                .addParams("payOrderId", getIntent().getStringExtra("payOrderId"))
                .addParams("user_id", application.userId)
                .tag("doit")
                .build()//
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        dismissProgress();;
                        Log.e("ll_yh", "登录失败404");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        dismissProgress();;
                        Log.e("ll_yh", "登陆结果： " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String msg = jsonObject.getString("message");
                            if (status.equals("1")) {
                                ToastUtil.showToast(mActivity, msg);
                                finish();
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
    }



