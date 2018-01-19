package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BankCardActivity extends BaseActivity {


    @BindView(R.id.iv_background_bank_card)
    ImageView ivBackgroundBankCard;
    @BindView(R.id.iv_bank_logo)//银行卡logo
            ImageView ivBankLogo;
    @BindView(R.id.tv_bank_name)//银行卡名字
            TextView tvBankName;
    @BindView(R.id.tv_bank_number)//银行卡号
            TextView tvBankNumber;
    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    private Activity mActivity;
    private MyApplication application;
    private static final String TAG = "BankCardActivity";

    @Override
    public void init() {
        mActivity = BankCardActivity.this;
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
                        Log.e(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onNext(BankCard bankCard) {
                        tvBankName.setText(bankCard.getBankCard().getBank());
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
                        }else if (bankCard.getBankCard().getBank().equals("北京农村商业银行")) {
                            Glide.with(mActivity).load(R.mipmap.beijingnongcunshangye).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("重庆银行")) {
                            Glide.with(mActivity).load(R.mipmap.chongqing).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("大连银行")) {
                            Glide.with(mActivity).load(R.mipmap.dalian).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("广州银行")) {
                            Glide.with(mActivity).load(R.mipmap.guangzhou).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("杭州银行")) {
                            Glide.with(mActivity).load(R.mipmap.hangzhou).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("江苏银行")) {
                            Glide.with(mActivity).load(R.mipmap.jiangsu).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("济宁银行")) {
                            Glide.with(mActivity).load(R.mipmap.jining).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("上海银行")) {
                            Glide.with(mActivity).load(R.mipmap.shanhai).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("深圳银行")) {
                            Glide.with(mActivity).load(R.mipmap.shenzhen).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("上海农村商业银行")) {
                            Glide.with(mActivity).load(R.mipmap.shncsy).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("台州银行")) {
                            Glide.with(mActivity).load(R.mipmap.taizhou).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("天津银行")) {
                            Glide.with(mActivity).load(R.mipmap.tianjin).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("厦门银行")) {//
                            Glide.with(mActivity).load(R.mipmap.xiamen).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("浙商银行")) {//
                            Glide.with(mActivity).load(R.mipmap.zheshang).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("浙江省农村信用社联合社")) {//
                            Glide.with(mActivity).load(R.mipmap.zjnchzs).into(ivBankLogo);
                        }else if (bankCard.getBankCard().getBank().equals("浙江泰隆商业银行")) {//
                            Glide.with(mActivity).load(R.mipmap.zjtlyh).into(ivBankLogo);
                        }

                        //tvBankNumber.setText(bankCard.getBankCard().getBank_cardno());
                        if (bankCard.getBankCard().getBank_cardno().length()==16){
                            tvBankNumber.setText("**************"+bankCard.getBankCard().getBank_cardno().substring(12,16));
                        }else{
                            tvBankNumber.setText("**************"+bankCard.getBankCard().getBank_cardno().substring(15,19));
                        }
                        Log.e(TAG, "onNext: "+bankCard.getBankCard().getBank_cardno() );


                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_bank_card;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }

}
