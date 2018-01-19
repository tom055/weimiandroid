package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.widget.LinearLayout;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;

//平台介绍
public class CompanyProfileActivity extends BaseActivity {
    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.activity_company_profile)
    LinearLayout activityCompanyProfile;
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = CompanyProfileActivity.this;
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
        return R.layout.activity_company_profile;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


}
