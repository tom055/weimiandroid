package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.URL;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 系统设置
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.ll_about)//关于
            LinearLayout llAbout;
    //    @BindView(R.id.ll_cooperation_to_recruit)//合作招募
//    LinearLayout llCooperationToRecruit;
    @BindView(R.id.ll_buyer_reading)//客户须知
            LinearLayout llBuyerReading;
    @BindView(R.id.ll_change_login_password)//修改登录密码
            LinearLayout llChangeLoginPassword;
    @BindView(R.id.ll_change_deal_password)//修改交易密码
            LinearLayout llChangeDealPassword;
    @BindView(R.id.ll_exit)//退出
            LinearLayout llExit;
    @BindView(R.id.ll_bank_card)
    LinearLayout llBankCard;
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = SettingActivity.this;
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
    /**
     * 联系我们
     */
    private void contactUrl() {
        application.apiService.url()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<URL>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(URL url) {
                        Intent intent = new Intent(mActivity, WebViewActivity.class);
                        intent.putExtra("contact",  Constants.BASE_URL+url.getContactUrl());
                        startActivity(intent);
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.ll_about/*, R.id.ll_cooperation_to_recruit*/, R.id.ll_buyer_reading, R.id.ll_change_login_password, R.id.ll_change_deal_password, R.id.ll_exit,R.id.ll_bank_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_about://跳转关于
                startActivity(new Intent(mActivity, AboutActivity.class));
                break;
//            case R.id.ll_cooperation_to_recruit://跳转合作招募
//                break;
            case R.id.ll_buyer_reading://跳转联系我们
                startActivity(new Intent(mActivity,ContactUsActivity.class));
                break;
            case R.id.ll_bank_card:
                Map<String, String> map1 = new HashMap<>();
                map1.put("userid", application.userId);
                application.apiService.bankcard(map1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<BankCard>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(BankCard bankCard) {
                                if (bankCard.getStatus().equals("1")) {
                                    startActivity(new Intent(mActivity, BankCardActivity.class));
                                } else if (bankCard.getStatus().equals("0")) {
                                    startActivity(new Intent(mActivity, BindCardActivity.class));
                                } else {
                                    ToastUtil.showToast(mActivity, bankCard.getMsg());
                                }
                            }
                        });
                break;
            case R.id.ll_change_login_password://修改登录密码
                startActivity(new Intent(mActivity, ChangeLoginPasswordActivity.class));
                break;
            case R.id.ll_change_deal_password://修改交易密码
                startActivity(new Intent(mActivity, ChangeDealPasswordActivity.class));
                break;
            case R.id.ll_exit://退出按钮
                application.clearLoginParams();
                Intent intent = new Intent("android.action.user.exit");
                sendBroadcast(intent);
                startActivity(new Intent(mActivity, LoginActivity.class));
                finish();
                break;
        }
    }




}
