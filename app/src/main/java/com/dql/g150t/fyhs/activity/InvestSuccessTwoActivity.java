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

public class InvestSuccessTwoActivity extends BaseActivity {


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
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private Activity mActivity;
    private MyApplication application;
    private static final String TAG = "InvestSuccessActivity";
    private DecimalFormat df = new DecimalFormat("0.00");
    Object[] obj = InvestTwoActivity.list;

    @Override
    public void init() {
        mActivity = InvestSuccessTwoActivity.this;
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
        String title = obj[0].toString();
        String apr = obj[1].toString();
        String redId;
        try {
            redId = obj[6].toString();
        } catch (Exception e) {
            redId = "null";
        }
        tvInvestTitle.setText(title);
        tvApr.setText(apr + "%");
        tvInvestTitle.setText(title);
        tvInvestMoney.setText(getIntent().getStringExtra("money") + "元");

        if (redId.equals("0") || "-1".equals(redId)||"".equals(redId)) {
            tvType.setText("未使用优惠券");
        } else if (redId.equals("1")) {
            tvType.setText(obj[2].toString()+"加息券");
        } else if (redId.equals("2")) {
            tvType.setText(obj[7].toString()+"抵扣券");
        } else {
            tvType.setText("未使用优惠券");
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (int i = 0; i < obj.length; i++) {
            obj[i] = "";
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_invest_success_two;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



    @OnClick( R.id.btn_submit)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                startActivity(new Intent(mActivity, MainActivity.class));
                finish();
                break;
        }
    }
}
