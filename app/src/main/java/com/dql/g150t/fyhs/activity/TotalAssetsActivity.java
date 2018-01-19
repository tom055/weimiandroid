package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.os.Bundle;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TotalAssetsActivity extends BaseActivity {
    @BindView(R.id.topbar)
    TopBar topbar;
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = TotalAssetsActivity.this;
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_total_assets;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
