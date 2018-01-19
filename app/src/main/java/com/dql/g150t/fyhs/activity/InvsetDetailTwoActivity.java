package com.dql.g150t.fyhs.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.Index;
import com.dql.g150t.fyhs.model.InvestDetail;
import com.dql.g150t.fyhs.view.TopBar;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InvsetDetailTwoActivity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.tv_invest_title)
    TextView tvInvestTitle;
    @BindView(R.id.tv_apr)
    TextView tvApr;
    @BindView(R.id.tv_time_limit)
    TextView tvTimeLimit;
    @BindView(R.id.tv_little_invest_money)
    TextView tvLittleInvestMoney;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_residue_money)
    TextView tvResidueMoney;
    @BindView(R.id.tv_releace_time)
    TextView tvReleaceTime;
    @BindView(R.id.tv_due_time)
    TextView tvDueTime;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_award)
    TextView tvAward;
    @BindView(R.id.tv_people_number)
    TextView tvPeopleNumber;
    @BindView(R.id.ll_record)
    LinearLayout llRecord;
    /*@BindView(R.id.tv_recommend)
    LinearLayout tvRecommend;*/
    @BindView(R.id.ll_detail)
    LinearLayout llDetail;
    @BindView(R.id.ll_risk_management)
    LinearLayout llRiskManagement;
    @BindView(R.id.iv_calculator)
    ImageView ivCalculator;
    @BindView(R.id.btn_buy)
    Button btnBuy;
    private Activity mActivity;
    private MyApplication application;
    private Date date;
    private Index.BorrowsBean borrows = null;
    private Index.BorrowNewBean borrowsNew = null;
    private static final String TAG = "InvsetDetailTwoActivity";
    private DecimalFormat df = new DecimalFormat("0.00");
    public InvestDetail investDetail = new InvestDetail();
    public static Object[] list = new Object[10];

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 101) {
                investDetail = (InvestDetail) msg.obj;
                //setData();
            }

            super.handleMessage(msg);
        }
    };
    @Override
    public void init() {
        mActivity = InvsetDetailTwoActivity.this;
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
        setLoad();
        Log.e(TAG, "init: "+getIntent().getStringExtra("id") );
    }

    /**
     * 加载标的详情
     */
    private void setLoad(){
        Map<String,String> map = new HashMap<>();
        map.put("borrowId",getIntent().getStringExtra("id"));
        map.put("userid",application.userId);
        application.apiService.getInvestDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InvestDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onNext(InvestDetail investDetail) {
                       // Log.e(TAG, "onNext: " + investDetail.getBorrow().getAccount());
                        tvInvestTitle.setText(investDetail.getBorrow().getName());
                        tvApr.setText(df.format(investDetail.getBorrow().getApr()) + "%");
                        if (investDetail.getBorrow().getIs_day() == 1) {
                            tvTimeLimit.setText(investDetail.getBorrow().getTime_limit() + "天");
                        } else {
                            tvTimeLimit.setText(investDetail.getBorrow().getTime_limit() + "个月");
                        }
                        tvTotalMoney.setText((int) investDetail.getBorrow().getAccount() + "");
                        tvLittleInvestMoney.setText(df.format(investDetail.getBorrow().getLowest_account()) + "");
                        list[0] = df.format(investDetail.getBorrow().getLowest_account());
                        tvResidueMoney.setText((int) (investDetail.getBorrow().getAccount() - investDetail.getBorrow().getAccount_yes()) + "");
                        tvProgress.setText((int) (investDetail.getBorrow().getAccount_yes() / investDetail.getBorrow().getAccount()*100) + "%");
                        pb.setProgress((int) (investDetail.getBorrow().getAccount_yes() / investDetail.getBorrow().getAccount()*100));
                        ObjectAnimator animator = ObjectAnimator.ofInt(pb, "progress", 0, (int) (investDetail.getBorrow().getAccount_yes() / investDetail.getBorrow().getAccount()*100));
                        animator.setDuration(3000);
                        animator.start();
                        if (!TextUtils.isEmpty(investDetail.getBorrow().getAddtime())) {
                            long l = Long.parseLong(investDetail.getBorrow().getAddtime());
                            long l2 = l * 1000;
                            date = new Date(l2);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            tvReleaceTime.setText(sdf.format(date));
                        } else {
                            tvReleaceTime.setText("");
                        }
                        if (!TextUtils.isEmpty(investDetail.getBorrow().getEnd_time())) {
                            long l = Long.parseLong(investDetail.getBorrow().getEnd_time());
                            long l2 = l * 1000;
                            date = new Date(l2);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            tvDueTime.setText(sdf.format(date));
                        } else {
                            tvDueTime.setText("");
                        }
                        if (investDetail.getBorrow().getStyle() == 0) {
                            tvType.setText("一次性还本付息");
                        } else if (investDetail.getBorrow().getStyle() == 1) {
                            tvType.setText("等额本息");
                        } else if (investDetail.getBorrow().getStyle() == 3) {
                            tvType.setText("按月付息到期还本");
                        }
                        if (investDetail.getBorrow().getFunds()==0 && investDetail.getBorrow().getPart_account()==0) {
                            tvAward.setText("无奖励");
                        } else if (investDetail.getBorrow().getFunds()==0 /*| investDetail.getBorrow().getPart_account().equals("0")*/) {
                           // Log.e(TAG, "onNext2: "+investDetail.getBorrow().getPart_account() + "元");
                            tvAward.setText(df.format(investDetail.getBorrow().getPart_account()) + "元");
                        } else if (investDetail.getBorrow().getPart_account()==0/* | investDetail.getBorrow().getFunds().equals("0")*/) {
                            tvAward.setText(df.format(investDetail.getBorrow().getFunds()) + "%");
                            //Log.e(TAG, "onNext1: "+investDetail.getBorrow().getFunds() + "%");

                        }
                        tvPeopleNumber.setText(investDetail.getTendersCount() + "");
                        if (investDetail.getBorrow().getStatus()==3){
                            btnBuy.setText("立即购买");
                            btnBuy.setEnabled(true);
                        }else if (investDetail.getBorrow().getStatus()==5){
                            btnBuy.setText("已售空");
                            btnBuy.setEnabled(false);
                        }else if (investDetail.getBorrow().getStatus()==6){
                            btnBuy.setText("已还款");
                            btnBuy.setEnabled(false);
                        }
                    }
                });
    }

    /**
     * 计算器
     */
    private void calculate() {
        Dialog dialog = new Dialog(mActivity);
        View contentView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_calculator, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(contentView);
        WindowManager manager = getWindowManager();
        Display d = manager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (int) (d.getWidth());
        lp.height = (int) (d.getHeight() * 0.4);
        dialog.show();
        final EditText et_InputMoney = (EditText) contentView.findViewById(R.id.et_InputMoney);
        final TextView tv_BidDate = (TextView) contentView.findViewById(R.id.tv_BidDate);
        final TextView tv_BidDateUnit = (TextView) contentView.findViewById(R.id.tv_BidDateUnit);
        final TextView tv_result = (TextView) contentView.findViewById(R.id.tv_result);
        final Button btn_cal = (Button) contentView.findViewById(R.id.btn_cal);
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
        map.put("borrowId",getIntent().getStringExtra("id"));
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
                        if (investDetail.getBorrow().getFunds()!=0){
                            if (investDetail.getBorrow().getIs_day() == 1) {
                                tv_BidDateUnit.setText("天");
                                tv_BidDate.setText(investDetail.getBorrow().getTime_limit() + "");
                                btn_cal.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DecimalFormat df = new DecimalFormat("0.00");
                                        tv_result.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()+investDetail.getBorrow().getFunds()) / 365 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Integer.valueOf(et_InputMoney.getText().toString().trim())) + "");
                                    }
                                });
                            } else {
                                tv_BidDateUnit.setText("个月");
                                tv_BidDate.setText(investDetail.getBorrow().getTime_limit() + "");
                                btn_cal.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DecimalFormat df = new DecimalFormat("0.00");
                                        tv_result.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()+investDetail.getBorrow().getFunds()) / 12 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Integer.valueOf(et_InputMoney.getText().toString().trim())) + "");
                                    }
                                });
                            }
                        }else{
                            if (investDetail.getBorrow().getIs_day() == 1) {
                                tv_BidDateUnit.setText("天");
                                tv_BidDate.setText(investDetail.getBorrow().getTime_limit() + "");
                                btn_cal.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DecimalFormat df = new DecimalFormat("0.00");
                                        tv_result.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()) / 365 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Integer.valueOf(et_InputMoney.getText().toString().trim())) + "");
                                    }
                                });
                            } else {
                                tv_BidDateUnit.setText("个月");
                                tv_BidDate.setText(investDetail.getBorrow().getTime_limit() + "");
                                btn_cal.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DecimalFormat df = new DecimalFormat("0.00");
                                        tv_result.setText(df.format(Double.valueOf(investDetail.getBorrow().getApr()) / 12 / 100 * Integer.valueOf(investDetail.getBorrow().getTime_limit()) * Integer.valueOf(et_InputMoney.getText().toString().trim())) + "");
                                    }
                                });
                            }
                        }
                    }
                });
        et_InputMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    btn_cal.setEnabled(true);
                } else {
                    btn_cal.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//        btn_cal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DecimalFormat df = new DecimalFormat("##.00");
//                tv_result.setText(df.format(Double.valueOf(invest.getApr()) / 365 / 100 * Integer.valueOf(invest.getTime_limit()) * Integer.valueOf(et_InputMoney.getText().toString().trim())) + "");
//            }
//        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_invset_detail_two;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



    @OnClick({R.id.ll_record/*, R.id.tv_recommend*/, R.id.ll_detail, R.id.ll_risk_management, R.id.iv_calculator, R.id.btn_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_record:
                Intent intent = new Intent(mActivity,TenderLogActivity.class);
                intent.putExtra("borrowId",getIntent().getStringExtra("id"));
                startActivity(intent);
                break;
            /*case R.id.tv_recommend:
                Map<String,String> map = new HashMap<>();
                map.put("borrowId",getIntent().getStringExtra("id"));
                map.put("userid",application.userId);
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
                            public void onNext(InvestDetail investDetail) {
                                Intent intent = new Intent(mActivity,RecommendActivity.class);
                                intent.putExtra("recommend",investDetail.getBorrow().getPromotion_info());
                                startActivity(intent);
                            }
                        });
                break;*/
            case R.id.ll_detail:
                Map<String,String> map1 = new HashMap<>();
                map1.put("borrowId",getIntent().getStringExtra("id"));
                map1.put("userid",application.userId);
                application.apiService.getInvestDetail(map1)
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
                            public void onNext(InvestDetail investDetail) {
                                Intent intent = new Intent(mActivity,DetailActivity.class);
                                intent.putExtra("con",investDetail.getBorrow().getContent());
                                String ss = investDetail.getImgs().get(0).getImg();
                                if (ss==null){
                                    intent.putExtra("imgs", String.valueOf(investDetail.getImgs()));
                                }else{
                                    intent.putExtra("img",ss.split(","));
                                }
                                startActivity(intent);
                            }
                        });
                break;
            case R.id.ll_risk_management:
                Map<String,String> map2 = new HashMap<>();
                map2.put("borrowId",getIntent().getStringExtra("id"));
                map2.put("userid",application.userId);
                application.apiService.getInvestDetail(map2)
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
                            public void onNext(InvestDetail investDetail) {
                                Intent intent = new Intent(mActivity,RiskManagementActivity.class);
                                intent.putExtra("risk_warning",investDetail.getBorrow().getRisk_warning());
                                startActivity(intent);
                            }
                        });
                break;
            case R.id.iv_calculator:
                calculate();
                break;
            case R.id.btn_buy:
                Intent intent1 = new Intent(mActivity,InvestTwoActivity.class);
                intent1.putExtra("borrowId",getIntent().getStringExtra("id"));
                intent1.putExtra("investDetail", new Gson().toJson(investDetail));
                startActivity(intent1);
                break;
        }
    }
}
