package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.ToWithDraw;
import com.dql.g150t.fyhs.model.WithDraw;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 提现页面
 */
public class WithDrawActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.iv_bank_logo)//银行卡logo
            ImageView ivBankLogo;
    @BindView(R.id.tv_bank_card)//银行卡
            TextView tvBankCard;
    @BindView(R.id.et_with_draw_money)//提现金额
            EditText etWithDrawMoney;
    @BindView(R.id.et_password)//交易密码
            EditText etPassword;
    @BindView(R.id.btn_submit)//提交按钮
            Button btnSubmit;
    @BindView(R.id.tv_bank_type)//银行卡名字
            TextView tvBankType;
    @BindView(R.id.tv_with_draw_money)
    TextView tvWithDrawMoney;
    @BindView(R.id.tv_no_with_draw_money)
    TextView tvNoWithDrawMoney;
    private Activity mActivity;
    private MyApplication application;
    private DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void init() {
        mActivity = WithDrawActivity.this;
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
        account();
    }

    private void account() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        application.apiService.toWithDraw(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ToWithDraw>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ToWithDraw toWithDraw) {
                        tvWithDrawMoney.setText(df.format(toWithDraw.getAccount().getUse_money()));
                        tvNoWithDrawMoney.setText(df.format(Math.abs(toWithDraw.getAccount().getNo_use_money())));
                    }
                });
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
                        if (bankCard.getBankCard().getBank_cardno().length()==16){
                            tvBankCard.setText("尾号("+bankCard.getBankCard().getBank_cardno().substring(12, 16)+")");
                        }else if (bankCard.getBankCard().getBank_cardno().length()==19){
                            tvBankCard.setText("尾号("+bankCard.getBankCard().getBank_cardno().substring(15, 19)+")");
                        }else if (bankCard.getBankCard().getBank_cardno().length()==18){
                            tvBankCard.setText("尾号("+bankCard.getBankCard().getBank_cardno().substring(14, 18)+")");
                        }else if (bankCard.getBankCard().getBank_cardno().length()==17){
                            tvBankCard.setText("尾号("+bankCard.getBankCard().getBank_cardno().substring(13, 17)+")");
                        }

                    }
                });
    }

    private void withDraw() {
        String money = etWithDrawMoney.getText().toString();
        String password = etPassword.getText().toString();
        if (money.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入提现金额");
            return;
        }
        if (password.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入交易密码");
            return;
        }
        if (password.length() < 6 || password.length() > 16) {
            ToastUtil.showToast(mActivity, "请输入正确的交易密码");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        map.put("money", money);
        map.put("paypassword", password);
        application.apiService.getWithDraw(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WithDraw>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WithDraw withDraw) {
                        if (withDraw.getStatus().equals("1")) {
                            ToastUtil.showToast(mActivity, withDraw.getMsg());
                            finish();
                        } else {
                            ToastUtil.showToast(mActivity, withDraw.getMsg());
                        }
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_with_draw;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }

    @OnClick(R.id.btn_submit)
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                withDraw();
                break;
        }
    }

}
