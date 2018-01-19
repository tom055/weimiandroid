package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.activity.BankCardActivity;
import com.dql.g150t.fyhs.activity.BindCardActivity;
import com.dql.g150t.fyhs.activity.DiscountCouponActivity;
import com.dql.g150t.fyhs.activity.InviteActivity;
import com.dql.g150t.fyhs.activity.LoginActivity;
import com.dql.g150t.fyhs.activity.MoneyRecordDetailActivity;
import com.dql.g150t.fyhs.activity.MyInvestActivity;
import com.dql.g150t.fyhs.activity.RealnameActivity;
import com.dql.g150t.fyhs.activity.RechargeActivity;
import com.dql.g150t.fyhs.activity.SettingActivity;
import com.dql.g150t.fyhs.activity.UserInfoActivity;
import com.dql.g150t.fyhs.activity.WithDrawActivity;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.MyInfo;
import com.dql.g150t.fyhs.model.ToRealname;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.GlideCircleTransform;
import com.dql.g150t.fyhs.view.TopBar;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

//import com.example.g150t.gaocaisheng.activity.ConvertIntegralActivity;

/**
 * 我的
 */
public class AccountFragment extends BaseFragment {
    private static boolean isRealName = false;//是否实名认证的标志
    private static boolean isBindBankCard = false;//是否绑定银行卡的标志

    @BindView(R.id.iv_head)//头像
            ImageView ivHead;
    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.btn_login)//我的页面登录按钮
            Button btnLogin;
    @BindView(R.id.tv_total_assets)//总资产--文字--未登录的时候隐藏，登陆时候显示   -
            TextView tvTotalAssets;
    @BindView(R.id.tv_total_assets_money)//总资产--数字--未登录的时候隐藏，登陆时候显示   -
            TextView tvTotalAssetsMoney;
    @BindView(R.id.ll_total_assets)//总资产的linearLayout--未登录的时候隐藏，登陆时候显示  -
            LinearLayout llTotalAssets;
    @BindView(R.id.tv_accumulated_income)//累计收益--文字--未登录的时候隐藏，登陆时候显示  -
            TextView tvAccumulatedIncome;
    @BindView(R.id.ll_accumulated_income)//累计收益LinearLayout--未登录的时候隐藏，登陆时候显示  -
            LinearLayout llAccumulatedIncome;
    @BindView(R.id.tv_collect)//代收金额--文字--未登录的时候隐藏，登陆时候显示  -
            TextView tvCollect;
    @BindView(R.id.ll_collect)//代收金额LinearLayout--未登录的时候隐藏，登陆时候显示 -
            LinearLayout llCollect;
    @BindView(R.id.ll_two)//累计收益和代收金额总的Linearlayout--未登录的时候隐藏，登陆时候显示
            LinearLayout llTwo;
    @BindView(R.id.ll_withdraw)//提现按钮
            LinearLayout llWithdraw;
    @BindView(R.id.ll_recharge)//充值按钮
            LinearLayout llRecharge;
    @BindView(R.id.tv_invest_number)//投资数量--数字--未登录的时候隐藏，登陆时候显示  -
            TextView tvInvestNumber;
    @BindView(R.id.tv_invest)//投资数量--文字--未登录的时候隐藏，登陆时候显示  -
            TextView tvInvest;
    @BindView(R.id.ll_my_invest)//我的投资按钮
            LinearLayout llMyInvest;
   @BindView(R.id.tv_balance)//账户余额
            TextView tvBalance;
     @BindView(R.id.ll_balance)//账户余额按钮
            LinearLayout llBalance;
    @BindView(R.id.ll_shop)
    LinearLayout llShop;
    @BindView(R.id.tv_discount_coupon_number)//可用优惠券数量--未登录的时候隐藏，登陆时候显示 -
            TextView tvDiscountCouponNumber;
    @BindView(R.id.tv_discount_coupon)//可用优惠券文字--未登录的时候隐藏，登陆时候显示
            TextView tvDiscountCoupon;
    @BindView(R.id.ll_discount_coupon)//我的优惠券那按钮
            LinearLayout llDiscountCoupon;
    @BindView(R.id.ll_money_record)//资金记录按钮
            LinearLayout llMoneyRecord;
  /*  @BindView(R.id.ll_use_money)
    LinearLayout llUseMoney;
    @BindView(R.id.tv_use_money)
    TextView tvUseMoney;*/
    /*@BindView(R.id.ll_bank_card)//绑定银行卡按钮
            LinearLayout llBankCard;*/
    /*@BindView(R.id.ll_invite)//推荐有奖按钮
            LinearLayout llInvite;*/
    /*@BindView(R.id.ll_settings)//系统设置
            LinearLayout llSettings;*/
    /*@BindView(R.id.tv_phone)//客服电话
            TextView tvPhone;*/
    @BindView(R.id.swipe_refresh)//刷新控件
            SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    @BindView(R.id.tv_text)//登录下面文字--未登录时显示--登录隐藏
            TextView tvText;
    @BindView(R.id.tv_name)//用户手机号
            TextView tvName;
    /*@BindView(R.id.iv_setting)
    ImageView ivSetting;*/
    @BindView(R.id.ll_bank_card)
    LinearLayout llBankCard;
    @BindView(R.id.ll_invite)
    LinearLayout llInvite;
    @BindView(R.id.ll_settings)
    LinearLayout llSettings;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.sv_container)
    ScrollView mSvContainer;

    private Activity mActivity;
    private MyApplication application;
    private DecimalFormat df = new DecimalFormat("0.00");
    private DecimalFormat df1 = new DecimalFormat("0");
    private static final String TAG = "AccountFragment";

//    private static boolean isRealName = false ;//是否实名认证的标志
//    private static boolean isBindBankCard = false ;//是否绑定银行卡的标志

    @Override
    public void init() {
        mActivity = getActivity();
        application = (MyApplication) mActivity.getApplication();
        /*mSvContainer.setPadding(mSvContainer.getPaddingLeft(),mSvContainer.getPaddingTop()+BarUtils.getStatusBarHeight()
        ,mSvContainer.getPaddingRight(),mSvContainer.getPaddingBottom());*/

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
                refresh();
            }
        });
        swipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setRefreshing(true);
                refresh();
                swipeRefresh.setRefreshing(false);
            }
        });
        loadData();
        isReal();
        isBind();
    }

    /**
     * 广播接受者
     */
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.action.user.exit")) {
                exit();
            } else if (intent.getAction().equals("android.action.toWithDraw")) {

            } else if (intent.getAction().equals("android.action.refresh")) {
                loadData();
                isBind();
                isReal();
            }
        }
    };

    private void refresh() {
        if (!application.isLogin) {
            exit();
        } else {
            loadData();
            isBind();
            isReal();
        }

    }

    //如果登录的话这些显示出来
    private void loadData() {
        if (application.isLogin) {
            tvName.setVisibility(View.VISIBLE);
            tvTotalAssets.setVisibility(View.VISIBLE);
            tvTotalAssetsMoney.setVisibility(View.VISIBLE);
            llTotalAssets.setVisibility(View.VISIBLE);
            tvAccumulatedIncome.setVisibility(View.VISIBLE);
            llAccumulatedIncome.setVisibility(View.VISIBLE);
            tvCollect.setVisibility(View.VISIBLE);
            llCollect.setVisibility(View.VISIBLE);
            llBalance.setVisibility(View.VISIBLE);
            tvBalance.setVisibility(View.VISIBLE);
            llTwo.setVisibility(View.VISIBLE);
            tvInvestNumber.setVisibility(View.VISIBLE);
            tvInvest.setVisibility(View.VISIBLE);
            tvDiscountCouponNumber.setVisibility(View.VISIBLE);
            tvDiscountCoupon.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.GONE);
            tvText.setVisibility(View.GONE);
           /* llUseMoney.setVisibility(View.VISIBLE);
            tvUseMoney.setVisibility(View.VISIBLE);*/
            Log.e(TAG, "loadData: " + application.userId);
            Map<String, String> map = new HashMap<>();
            map.put("userid", String.valueOf(application.userId) + "");
            //加载总资产，累计收益，代收收益，头像旁边的手机号
            application.apiService.MyInfo(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<MyInfo>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.toString());
                        }

                        @Override
                        public void onNext(MyInfo myInfo) {
                            Log.e(TAG, "onNext: " + myInfo.getAccount().getTotal());
                            Log.e(TAG, "onNext: " + myInfo.getAccount().getCollection());
                           /* double total = myInfo.getAccount().getTotal();
                            double collection = myInfo.getAccount().getCollection();*/
                            tvTotalAssetsMoney.setText(df.format(Double.valueOf(myInfo.getAccount().getTotal())));//总资产
                            tvCollect.setText("待收金额\n" + df.format(Double.valueOf(myInfo.getAccount().getCollection())));//待收
                            tvName.setText(myInfo.getMobile().getMobileNum().substring(0, 3) + "****" + myInfo.getMobile().getMobileNum().substring(7, 11));//用户名
                            tvAccumulatedIncome.setText("累计收益\n" + myInfo.getCountBorrowTenderMap1().getRepaymentYesinterestTotal());//df.format(myInfo.getCountBorrowTenderMap1().getRepaymentYesinterestTotal()));//累计收益
                            tvInvestNumber.setText(myInfo.getInvestCount());//(df1.format(myInfo.getInvestCount()));//投资条数
                            tvDiscountCouponNumber.setText(myInfo.getRedCount());//(df1.format(myInfo.getRedCount()));//红包条数
                           // tvUseMoney.setText("可用余额\n"+df.format(myInfo.getAccount().getUse_money()));
                            tvBalance.setText(df.format(Double.valueOf(myInfo.getAccount().getUse_money())));//账户余额
                        }
                    });

        }
    }

    //退出的操作
    private void exit() {
        Glide.with(mActivity).load(R.mipmap.icon_head)
                .transform(new GlideCircleTransform(mActivity))
                .into(ivHead);
        tvName.setVisibility(View.GONE);
        tvTotalAssets.setVisibility(View.GONE);
        tvTotalAssetsMoney.setVisibility(View.GONE);
        llTotalAssets.setVisibility(View.GONE);
        tvAccumulatedIncome.setVisibility(View.GONE);
        llAccumulatedIncome.setVisibility(View.GONE);
        tvCollect.setVisibility(View.GONE);
        llCollect.setVisibility(View.GONE);

        tvBalance.setVisibility(View.GONE);
        llTwo.setVisibility(View.GONE);
        tvInvestNumber.setVisibility(View.GONE);
        tvInvest.setVisibility(View.GONE);
        tvDiscountCouponNumber.setVisibility(View.GONE);
        tvDiscountCoupon.setVisibility(View.GONE);
        btnLogin.setVisibility(View.VISIBLE);
        tvText.setVisibility(View.VISIBLE);
        /*llUseMoney.setVisibility(View.GONE);
        tvUseMoney.setVisibility(View.GONE);*/
    }

    //是否实名认证
    private void isReal() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        application.apiService.toReal(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ToRealname>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ToRealname toRealname) {
                        int realNameContent = toRealname.getRealName().getStatus();
                        Log.e("sss", "onNext: " + realNameContent);
                        if (!toRealname.getRealName().equals("") && realNameContent == 1) {
                            isRealName = true;
                        } else {
                            isRealName = false;
                        }
                    }
                });
    }

    //是否绑定银行卡
    private void isBind() {
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
                        if (bankCard.getStatus().equals("1")) {
                            isBindBankCard = true;
                        } else {
                            isBindBankCard = false;
                        }
                    }
                });
    }


    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.action.user.exit");
        filter.addAction("android.action.toWithDraw");
        filter.addAction("android.action.refresh");
        mActivity.registerReceiver(receiver, filter);
        refresh();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity.unregisterReceiver(receiver);
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_account;
    }

    @Override
    public Object bindFragment() {
        return this;
    }


    @OnClick({R.id.btn_login, R.id.ll_withdraw, R.id.ll_recharge, R.id.ll_my_invest/*, R.id.ll_balance*/, R.id.ll_discount_coupon, R.id.ll_money_record, R.id.ll_shop, R.id.ll_bank_card, R.id.ll_invite, R.id.ll_settings, R.id.ll_phone, R.id.iv_head/*, R.id.iv_setting*/, R.id.ll_total_assets})
    public void onViewClicked(View view) {
        if (!application.isLogin) {
            startActivity(new Intent(mActivity, LoginActivity.class));
        } else {
            switch (view.getId()) {
                case R.id.iv_head:
                    startActivity(new Intent(mActivity, UserInfoActivity.class));
                    break;
                case R.id.btn_login://登录按钮
                    startActivity(new Intent(mActivity, LoginActivity.class));
                    break;
                case R.id.ll_total_assets:
                    //startActivity(new Intent(mActivity, TotalAssetsActivity.class));  跳转到资产详情页
                    break;
                case R.id.ll_withdraw://提现
                    if (!isRealName) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity) ;
                        builder.setTitle("是否实名认证");
                        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                startActivity(new Intent(mActivity, RealnameActivity.class));
                            }
                        }) ;


                        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }) ;
                        AlertDialog alertDialog = builder.create() ;
                        alertDialog.show();
                        return;
                        /*startActivity(new Intent(mActivity, RealnameActivity.class));
                        ToastUtil.showToast(mActivity, "您未进行实名认证");
                        return;*/
                    } else if (!isBindBankCard) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity) ;
                        builder.setTitle("是否绑定银行卡");
                        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                startActivity(new Intent(mActivity, BindCardActivity.class));
                            }
                        }) ;


                        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }) ;
                        AlertDialog alertDialog = builder.create() ;
                        alertDialog.show();
                        /*startActivity(new Intent(mActivity, BindCardActivity.class));
                        ToastUtil.showToast(mActivity, "您未绑定银行卡");
                        return;*/
                    } else {
                        startActivity(new Intent(mActivity, WithDrawActivity.class));
                    }
                    /*Map<String, String> map = new HashMap<>();
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
                                    if (toWithDraw.getStatus().equals("1")) {
                                        startActivity(new Intent(mActivity, WithDrawActivity.class));
                                    } else if (toWithDraw.getStatus().equals("0")) {
                                        ToastUtil.showToast(mActivity, toWithDraw.getMsg());
                                    } else if (toWithDraw.getStatus().equals("-1")) {
                                        ToastUtil.showToast(mActivity, toWithDraw.getMsg());
                                    }
                                }
                            });*/
                    break;
                case R.id.ll_recharge://充值
                //    ToastUtil.showToast(mActivity,"充值功能暂未开通");
                    if (!isRealName) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity) ;
                        builder.setTitle("是否实名认证");
                        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                startActivity(new Intent(mActivity, RealnameActivity.class));
                            }
                        }) ;


                        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }) ;
                        AlertDialog alertDialog = builder.create() ;
                        alertDialog.show();
                        return;
                    } else if (!isBindBankCard) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity) ;
                        builder.setTitle("是否绑定银行卡");
                        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                startActivity(new Intent(mActivity, BindCardActivity.class));
                            }
                        }) ;


                        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }) ;
                        AlertDialog alertDialog = builder.create() ;
                        alertDialog.show();
                    } else {
                        startActivity(new Intent(mActivity, RechargeActivity.class));
                    }
                    break;
                case R.id.ll_my_invest://我的投资
                    startActivity(new Intent(mActivity, MyInvestActivity.class));
                    break;
                /*case R.id.ll_balance://账户余额
                    break;*/
                case R.id.ll_discount_coupon://优惠券
                    startActivity(new Intent(mActivity, DiscountCouponActivity.class));
                    break;
                case R.id.ll_money_record://资金记录
                    startActivity(new Intent(mActivity, MoneyRecordDetailActivity.class));
                    break;
                case R.id.ll_bank_card://银行卡
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
                                        ToastUtil.showToast(mActivity, "请按充值进行绑卡和实名认证");
                                    }
                                }
                            });
                    break;
                case R.id.ll_invite://推荐有奖
                    startActivity(new Intent(mActivity, InviteActivity.class));
                    break;
                case R.id.ll_settings://系统设置
                    startActivity(new Intent(mActivity, SettingActivity.class));
                    break;
                case R.id.ll_shop:
                    startActivity(new Intent(mActivity, InviteActivity.class));
                    break;
                /*case R.id.iv_setting://系统设置
                    startActivity(new Intent(mActivity, SettingActivity.class));
                    break;*/
                case R.id.ll_phone://客服电话
                    startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + "0798-7210018")));
                    break;
            }
        }

    }

}
