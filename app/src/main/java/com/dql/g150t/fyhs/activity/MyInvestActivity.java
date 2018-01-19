package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.fragment.InvestRecordFragment;
import com.dql.g150t.fyhs.fragment.PaymentReceivedFragment;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的投资页面
 */
public class MyInvestActivity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private Activity mActivity;
    private MyApplication application;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    //private ArrayList<String> titles = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();

    @Override
    public void init() {
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        initViewPager();
    }
    private void initViewPager() {
        mFragments = getFragments();

        mTitles.add("持有中");
        mTitles.add("已还款");
//        mTitles.add("已还款项目");
        viewPager.setAdapter(new RecordPagerAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(viewPager);
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new InvestRecordFragment());
        list.add(new PaymentReceivedFragment());
        return list;
    }

    private class RecordPagerAdapter extends FragmentPagerAdapter {

        public RecordPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_invest;
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
