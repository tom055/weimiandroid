package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BaseStatus;
import com.dql.g150t.fyhs.model.InvestDetail;
import com.dql.g150t.fyhs.model.MyInfo;
import com.dql.g150t.fyhs.model.ToRecharge;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InvestActivity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.tv_invest_title)
    TextView tvInvestTitle;
    @BindView(R.id.tv_apr)
    TextView tvApr;
    @BindView(R.id.tv_limit_day)
    TextView tvLimitDay;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.et_invest_money)
    EditText etInvestMoney;
    @BindView(R.id.tv_discount_coupon)
    TextView tvDiscountCoupon;
    @BindView(R.id.ll_discount_coupon)
    LinearLayout llDiscountCoupon;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_earnings)
    TextView tvEarning;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    private Activity mActivity;
    private MyApplication application;
    private static final String TAG = "InvestActivity";
    private DecimalFormat df = new DecimalFormat("0.00");

    private InvestDetail investDetail;

    private static int SELECT_REDPACKET = 1;

    public static Object[] list = new Object[10];
    Object[] objs = InvestDetailActivity.list;
    String lowestAccount = objs[0].toString();
    @Override
    public void init() {
        mActivity = InvestActivity.this;
        application = (MyApplication) getApplication();
        String jsonData = getIntent().getStringExtra("investDetail");

        investDetail = new Gson().fromJson(jsonData, InvestDetail.class);
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        etInvestMoney.setHint(lowestAccount+"元起投");
        setLoad();
    }



    /**
     * 展示数据
     */
    private void setLoad() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        application.apiService.MyInfo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyInfo myInfo) {
                        if (myInfo.getIsNew().equals("1")) {
                            getNewTender();
                        } else {
                            getTender();
                        }
                    }
                });
    }

    /**
     * 新手标
     */
    private void getNewTender() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        map.put("borrowId", getIntent().getStringExtra("newBorrowId"));
        application.apiService.getInvestDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InvestDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final InvestDetail investDetail) {
                        tvInvestTitle.setText(investDetail.getBorrow().getName());
                        tvApr.setText(investDetail.getBorrow().getApr() + "");
                        if (investDetail.getBorrow().getIs_day() == 1) {
                            tvLimitDay.setText(investDetail.getBorrow().getTime_limit() + "天");
                        } else {
                            tvLimitDay.setText(investDetail.getBorrow().getTime_limit() + "个月");
                        }
                        tvTotalMoney.setText(investDetail.getAccount().getUse_money() + "");
                        list[0] = investDetail.getBorrow().getName();
                        list[1] = investDetail.getBorrow().getApr();
                        list[4] = investDetail.getBorrow().getIs_day();
                        list[5] = investDetail.getBorrow().getTime_limit();
                        etInvestMoney.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                                if (investDetail.getBorrow().getIs_day() == 1) {
                                    if (!charSequence.toString().isEmpty() && count > 0) {
                                        tvEarning.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()) / 365 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Float.valueOf(charSequence.toString())));
                                    } else {
                                        tvEarning.setText("0");
                                    }
                                } else {
                                    if (!charSequence.toString().isEmpty() && count > 0) {
                                        tvEarning.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()) / 12 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Float.valueOf(charSequence.toString())));
                                    } else {
                                        tvEarning.setText("0");
                                    }
                                }
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });
                    }
                });
    }

    /**
     * 日常标
     */
    private void getTender() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        map.put("borrowId", getIntent().getStringExtra("borrowId"));
        application.apiService.getInvestDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InvestDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final InvestDetail investDetail) {
                        tvInvestTitle.setText(investDetail.getBorrow().getName());
                        tvApr.setText(investDetail.getBorrow().getApr() + "");
                        if (investDetail.getBorrow().getIs_day() == 1) {
                            tvLimitDay.setText(investDetail.getBorrow().getTime_limit() + "天");
                        } else {
                            tvLimitDay.setText(investDetail.getBorrow().getTime_limit() + "个月");
                        }
                        tvTotalMoney.setText(investDetail.getAccount().getUse_money() + "");
                        list[0] = investDetail.getBorrow().getName();
                        list[1] = investDetail.getBorrow().getApr();
                        list[4] = investDetail.getBorrow().getIs_day();
                        list[5] = investDetail.getBorrow().getTime_limit();
                        etInvestMoney.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                                if (investDetail.getBorrow().getIs_day() == 1) {
                                    if (!charSequence.toString().isEmpty() && count > 0) {
                                        tvEarning.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()) / 365 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Float.valueOf(charSequence.toString())));
                                    } else {
                                        tvEarning.setText("0");
                                    }
                                } else {
                                    if (!charSequence.toString().isEmpty() && count > 0) {
                                        tvEarning.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()) / 12 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Float.valueOf(charSequence.toString())));
                                    } else {
                                        tvEarning.setText("0");
                                    }
                                }
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });
                    }
                });
    }

    /**
     * 红包Id
     */
    private String userRedId = "-1";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SELECT_REDPACKET) {
            if (resultCode == RESULT_OK) {

                InvestDetail.RedsBean userRedsBean = null;
                Bundle bundle = data.getExtras();
                String jsonData = bundle.getString("red");

                if (!jsonData.equals("")) {
                    userRedsBean = new Gson().fromJson(jsonData, InvestDetail.RedsBean.class);
                    userRedId = userRedsBean.getId() + "";


                } else {
                    userRedId = "-1";
                }

                if (userRedsBean == null) {
                    tvDiscountCoupon.setText(/*investDetail.getUserRedNum()+*/"不使用红包");
                    list[2] = "未使用优惠券";
                } else {

                    if (userRedsBean.getRed_type_id() == 1) {
                        tvDiscountCoupon.setText(userRedsBean.getRed_title()+"加息券");
                        list[6] = userRedsBean.getRed_type_id();
                        list[2] = userRedsBean.getRed_title();
                    } else if (userRedsBean.getRed_type_id() == 2) {
                        tvDiscountCoupon.setText(userRedsBean.getRed_title()+"抵扣券");
                        list[6] = userRedsBean.getRed_type_id();
                        list[7] = userRedsBean.getRed_title();
                    }
                }


            }

        }
    }

    /**
     * 投标
     *
     * @return
     */

    private void allTender() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        application.apiService.MyInfo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyInfo myInfo) {
                        Log.e(TAG, "onNext: ");
                        if (myInfo.getIsNew().equals("1")) {
                            newTender();
                        } else {
                            tender();
                        }
                    }
                });
    }

    private void newTender() {
        String userId = application.userId;
        String account = etInvestMoney.getText().toString();
        String payPassword = etPassword.getText().toString();


        if (TextUtils.isEmpty(account)) {
            ToastUtil.showToast(mActivity, "请输入投资金额");
            return;
        }
        if (TextUtils.isEmpty(payPassword)) {
            ToastUtil.showToast(mActivity, "请输入交易密码");
            return;
        }

        Map<String, String> map = new HashMap<>();
        map.put("userid", userId);
        map.put("account", account);
        map.put("payPassword", payPassword);
        map.put("borrowId", getIntent().getStringExtra("newBorrowId"));
        map.put("redId", userRedId);
        Log.e(TAG, "newtender: " + userRedId);
        Log.e(TAG, "newtender: " + userId);
        Log.e(TAG, "newtender: " + account);
        Log.e(TAG, "newtender: " + payPassword);
        Log.e(TAG, "newtender: " + getIntent().getStringExtra("newBorrowId"));

        application.apiService.tender(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseStatus>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("investError", e.toString());
                    }

                    @Override
                    public void onNext(BaseStatus baseStatus) {

                        if (baseStatus.getStatus() == 1) {
                            ToastUtil.showToast(mActivity, baseStatus.getMsg());
                            Intent intent = new Intent(mActivity, InvestSuccessActivity.class);
                            intent.putExtra("money", etInvestMoney.getText().toString());
                            startActivity(intent);
                        } else {
                            ToastUtil.showToast(mActivity, baseStatus.getMsg());
                            list[6] = "";
                            return;
                        }
                    }
                });
    }

    private void tender() {
        String userId = application.userId;
        String account = etInvestMoney.getText().toString();

        String payPassword = etPassword.getText().toString();


        if (TextUtils.isEmpty(account)) {
            ToastUtil.showToast(mActivity, "请输入投资金额");
            return;
        }
        if (TextUtils.isEmpty(payPassword)) {
            ToastUtil.showToast(mActivity, "请输入交易密码");
            return;
        }

        Map<String, String> map = new HashMap<>();
        map.put("userid", userId);
        map.put("account", account);
        map.put("payPassword", payPassword);
        map.put("borrowId", getIntent().getStringExtra("borrowId"));
        map.put("redId", userRedId);
        Log.e(TAG, "tender: " + userRedId);
        Log.e(TAG, "tender: " + userId);
        Log.e(TAG, "tender: " + account);
        Log.e(TAG, "tender: " + payPassword);
        Log.e(TAG, "tender: " + getIntent().getStringExtra("newBorrowId"));
        application.apiService.tender(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseStatus>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("investError", e.toString());
                    }

                    @Override
                    public void onNext(BaseStatus baseStatus) {

                        if (baseStatus.getStatus() == 1) {
                            ToastUtil.showToast(mActivity, baseStatus.getMsg());
                            Intent intent = new Intent(mActivity, InvestSuccessActivity.class);
                            intent.putExtra("money", etInvestMoney.getText().toString());
                            startActivity(intent);
                        } else {
                            ToastUtil.showToast(mActivity, baseStatus.getMsg());
                            list[6] = "";
                            return;
                        }
                    }
                });
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_invest;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.ll_discount_coupon, R.id.btn_submit, R.id.tv_recharge,R.id.tv_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_discount_coupon://跳转选择红包页面

                Intent intent = new Intent(mActivity, SelectRedPacketActivity.class);
                intent.putExtra("investDetail", new Gson().toJson(investDetail));
                startActivityForResult(intent, SELECT_REDPACKET);
                break;

            case R.id.tv_forget_password:
                startActivity(new Intent(mActivity,ForgetDealPasswordActivity.class));
                break;

            case R.id.tv_recharge:
                Map<String, String> map2 = new HashMap<>();
                map2.put("userid", application.userId);
                application.apiService.toRecharge(map2)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<ToRecharge>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ToRecharge toRecharge) {
                                if (toRecharge.getStatus().equals("1")) {
                                    startActivity(new Intent(mActivity, RechargeActivity.class));
                                } else if (toRecharge.getStatus().equals("-1")) {
                                    ToastUtil.showToast(mActivity, toRecharge.getMsg());
                                } else if (toRecharge.getStatus().equals("0")) {
                                    ToastUtil.showToast(mActivity, "您尚未绑定银行卡");
                                }
                            }
                        });
                break;
            case R.id.btn_submit:
                allTender();
                break;
        }
    }


}
