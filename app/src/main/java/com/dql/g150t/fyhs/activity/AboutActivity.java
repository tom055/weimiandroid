package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 关于富源恒生
 */
public class AboutActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.ll_company_profile)
    LinearLayout llCompanyProfile;
    @BindView(R.id.ll_enterprise_features)
    LinearLayout llEnterpriseFeatures;
    @BindView(R.id.ll_honor)
    LinearLayout llHonor;
    /*@BindView(R.id.ll_partner)
    LinearLayout llPartner;*/
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = AboutActivity.this;
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
        return R.layout.activity_about;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }




    @OnClick({R.id.ll_company_profile, R.id.ll_enterprise_features, R.id.ll_honor/*, R.id.ll_partner*/})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_company_profile:
               // startActivity(new Intent(mActivity,CompanyProfileActivity.class));
                break;
            case R.id.ll_enterprise_features:
                startActivity(new Intent(mActivity,EnterpriseFeaturesActivity.class));
                break;
            case R.id.ll_honor:
               // startActivity(new Intent(mActivity,HonorActivity.class));
                break;
            /*case R.id.ll_partner:
                startActivity(new Intent(mActivity,PartnerActivity.class));
                break;*/
        }
    }

}
