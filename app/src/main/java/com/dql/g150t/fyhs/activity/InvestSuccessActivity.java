package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dql.g150t.fyhs.MainActivity;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.view.TopBar;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class InvestSuccessActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.tv_invest_title)
    TextView tvInvestTitle;
    @BindView(R.id.tv_apr)
    TextView tvApr;
    @BindView(R.id.tv_invest_money)
    TextView tvInvestMoney;
    @BindView(R.id.tv_type)
    TextView tvType;
    /*@BindView(R.id.tv_earnings)
    TextView tvEarnings;*/
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private Activity mActivity;
    private MyApplication application;
    private DecimalFormat df = new DecimalFormat("0.00");

    Object[] objs = InvestActivity.list;

    @Override
    public void init() {
        mActivity = InvestSuccessActivity.this;
        application = (MyApplication) getApplication();
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                startActivity(new Intent(mActivity, MainActivity.class));
            }

            @Override
            public void rightClick() {

            }
        });
        String title1 = objs[0].toString();
        String apr1 = objs[1].toString();
        String redId1;
        try {
            redId1 = objs[6].toString();
        } catch (Exception e) {
            redId1 = "null";
        }
        tvInvestTitle.setText(title1);
        tvApr.setText(apr1 + "%");
        tvInvestMoney.setText(getIntent().getStringExtra("money")+ "元");

        if (redId1.equals("0") || "null".equals(redId1)||"".equals(redId1)) {
            tvType.setText("未使用优惠券");
        } else if (redId1.equals("1")) {
            tvType.setText(objs[2].toString()+"加息券");
        } /*else if (redId1.equals("2")) {
            tvType.setText(objs[7].toString()+"抵扣卷");
        } */else {
            tvType.setText(objs[7].toString()+"抵扣券");
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (int i = 0; i < objs.length; i++) {
            objs[i] = "";
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_invest_success;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick(R.id.btn_submit)
    public void onClicked(View view) {
        switch (view.getId()){
            case R.id.btn_submit:
                startActivity(new Intent(mActivity,MainActivity.class));
                finish();
                break;
        }
    }
}
