package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
public class RechargeActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.iv_bank_logo)//银行logo
            ImageView ivBankLogo;
    @BindView(R.id.tv_bank_card_number)//银行卡号
            TextView tvBankCardNumber;
    @BindView(R.id.et_recharge_money)//充值输入的金额
            EditText etRechargeMoney;
    @BindView(R.id.btn_submit)//提交按钮
            Button btnSubmit;
    @BindView(R.id.tv_bank_type)//银行名字
            TextView tvBankType;

    /*@BindView(R.id.et_bill_number)
    EditText etBillNumber;*/
    private Activity mActivity;
    private MyApplication application;
    private static final String TAG = "RechargeActivity";
    //private String cardNo;//银行卡号-
    private String mchntCd;//商户号-
    private String amt;//金额-
    private String backUrl;//回调地址-
    private String cardNo;//银行卡号-
    private String orderId;//商户订单号-
    private String IDcardType;//证件类型-
    private String userId;//-
    private String IDNo;//证件号-
    private String userName;//名字-
    private String signKey;
    private String sdkSignTp;//-
    private String sdkType;//商户秘钥
    private String sdkVersion;//sdk版本号-
    private String payType;
    private String key;

    @Override
    public void init() {
        mActivity = RechargeActivity.this;
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
        bankcard();
        etRechargeMoney.setText(10+"");
        FyPay.setDev(true);
        FyPay.init(RechargeActivity.this);
    }

    private void bankcard() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        application.apiService.bankcard(map)
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
                        cardNo = bankCard.getBankCard().getBank_cardno();
                        tvBankType.setText(bankCard.getBankCard().getBank());
                        if (bankCard.getBankCard().getBank().equals("建设银行")) {//
                            Glide.with(mActivity).load(R.mipmap.jianshe).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("渤海银行")) {//
                            Glide.with(mActivity).load(R.mipmap.bohai).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("工商银行")) {//
                            Glide.with(mActivity).load(R.mipmap.gongshang).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("中国光大银行")) {//
                            Glide.with(mActivity).load(R.mipmap.guangda).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("广东发展银行")) {//
                            Glide.with(mActivity).load(R.mipmap.guangfa).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("华夏银行")) {//
                            Glide.with(mActivity).load(R.mipmap.huaxia).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("交通银行")) {//
                            Glide.with(mActivity).load(R.mipmap.jiaotong).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("中国民生银行")) {//
                            Glide.with(mActivity).load(R.mipmap.minsheng).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("宁波银行")) {//
                            Glide.with(mActivity).load(R.mipmap.ningbo).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("农业银行")) {//
                            Glide.with(mActivity).load(R.mipmap.nongye).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("平安银行")) {//
                            Glide.with(mActivity).load(R.mipmap.pingan).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("上海浦东发展银行")) {//
                            Glide.with(mActivity).load(R.mipmap.pufa).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("兴业银行")) {//
                            Glide.with(mActivity).load(R.mipmap.xingye).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("中国邮政储蓄银行")) {
                            Glide.with(mActivity).load(R.mipmap.youzheng).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("招商银行")) {//
                            Glide.with(mActivity).load(R.mipmap.zhaoshang).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("中国银行")) {//
                            Glide.with(mActivity).load(R.mipmap.zhongguo).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("中信银行")) {//
                            Glide.with(mActivity).load(R.mipmap.zhongxin).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("北京农村商业银行")) {
                            Glide.with(mActivity).load(R.mipmap.beijingnongcunshangye).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("重庆银行")) {
                            Glide.with(mActivity).load(R.mipmap.chongqing).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("大连银行")) {
                            Glide.with(mActivity).load(R.mipmap.dalian).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("广州银行")) {
                            Glide.with(mActivity).load(R.mipmap.guangzhou).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("杭州银行")) {
                            Glide.with(mActivity).load(R.mipmap.hangzhou).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("江苏银行")) {
                            Glide.with(mActivity).load(R.mipmap.jiangsu).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("济宁银行")) {
                            Glide.with(mActivity).load(R.mipmap.jining).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("上海银行")) {
                            Glide.with(mActivity).load(R.mipmap.shanhai).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("深圳银行")) {
                            Glide.with(mActivity).load(R.mipmap.shenzhen).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("上海农村商业银行")) {
                            Glide.with(mActivity).load(R.mipmap.shncsy).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("台州银行")) {
                            Glide.with(mActivity).load(R.mipmap.taizhou).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("天津银行")) {
                            Glide.with(mActivity).load(R.mipmap.tianjin).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("厦门银行")) {//
                            Glide.with(mActivity).load(R.mipmap.xiamen).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("浙商银行")) {//
                            Glide.with(mActivity).load(R.mipmap.zheshang).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("浙江省农村信用社联合社")) {//
                            Glide.with(mActivity).load(R.mipmap.zjnchzs).into(ivBankLogo);
                        } else if (bankCard.getBankCard().getBank().equals("浙江泰隆商业银行")) {//
                            Glide.with(mActivity).load(R.mipmap.zjtlyh).into(ivBankLogo);
                        }

                        if (bankCard.getBankCard().getBank_cardno().length() == 16) {
                            Log.e(TAG, "onNext1: " + bankCard.getBankCard().getBank_cardno() + "");
                            tvBankCardNumber.setText("尾号(" + bankCard.getBankCard().getBank_cardno().substring(12, 16) + ")");
                        } else if (bankCard.getBankCard().getBank_cardno().length() == 19) {
                            Log.e(TAG, "onNext2: " + bankCard.getBankCard().getBank_cardno() + "");
                            tvBankCardNumber.setText("尾号(" + bankCard.getBankCard().getBank_cardno().substring(15, 19) + ")");
                        }else if (bankCard.getBankCard().getBank_cardno().length() == 18) {
                            Log.e(TAG, "onNext2: " + bankCard.getBankCard().getBank_cardno() + "");
                            tvBankCardNumber.setText("尾号(" + bankCard.getBankCard().getBank_cardno().substring(14, 18) + ")");
                        }else if (bankCard.getBankCard().getBank_cardno().length() == 17) {
                            Log.e(TAG, "onNext2: " + bankCard.getBankCard().getBank_cardno() + "");
                            tvBankCardNumber.setText("尾号(" + bankCard.getBankCard().getBank_cardno().substring(13, 17) + ")");
                        }


                    }
                });
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }

    @OnClick(R.id.urlbtn)
    public void openUrl(){
        Intent intent=new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(Constants.openurl);
        intent.setData(content_url);
        startActivity(intent);
    }

    @OnClick(R.id.btn_submit)
    public void onClicked(View view) {

        String money = etRechargeMoney.getText()+"";

        if (TextUtils.isEmpty(money)) {
            ToastUtil.showToast(mActivity, "请输入投资金额");
            return;
        }
        showProgress();
        OkHttpUtils
                .post()//
                .url(Constants.BASE_URL + "app_home/rechargexinhestep1.dql")//
                .addParams("money", money)
                .addParams("user_id", application.userId)
                .tag("doit")
                .build()//
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        dismissProgress();
                        Log.e("ll_yh", "登录失败404");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        dismissProgress();
                        Log.e("ll_yh", "登陆结果： " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String msg = jsonObject.getString("message");
                            if (status.equals("1")) {
                                ToastUtil.showToast(mActivity, msg);
                                Intent intent = new Intent(mActivity, RechargeActivity2.class);
                                intent.putExtra("orderId", jsonObject.getString("orderId"));
                                intent.putExtra("payOrderId", jsonObject.getString("payOrderId"));
                                ToastUtil.showToast(mActivity, "请输入验证码");
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
    }




