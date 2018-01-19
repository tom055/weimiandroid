package com.dql.g150t.fyhs.activity;

import android.app.Activity;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;

/**
 * 资金记录页面
 */
public class MoneyRecordActivity extends BaseActivity {

    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = MoneyRecordActivity.this;
        application = (MyApplication) getApplication();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_money_record;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }
}
