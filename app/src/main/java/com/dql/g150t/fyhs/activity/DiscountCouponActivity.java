package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.fragment.HaveBeenUsedFragment;
import com.dql.g150t.fyhs.fragment.StaleFragment;
import com.dql.g150t.fyhs.fragment.TobeUseFragment;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 优惠券
 */
public class DiscountCouponActivity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
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
    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new TobeUseFragment());
        list.add(new HaveBeenUsedFragment());
        list.add(new StaleFragment());
        return list;
    }
    private void initViewPager() {
        mFragments = getFragments();

        mTitles.add("待使用");
        mTitles.add("已使用");
        mTitles.add("已过期");
        viewPager.setAdapter(new DiscountCouponAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(viewPager);
    }
    private class DiscountCouponAdapter extends FragmentPagerAdapter {

        public DiscountCouponAdapter(FragmentManager fm) {
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
        return R.layout.activity_discount_coupon;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }

}
