package com.dql.g150t.fyhs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.dql.g150t.fyhs.activity.RegistActivity;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.fragment.AccountFragment;
import com.dql.g150t.fyhs.fragment.DiscoveryFragment;
import com.dql.g150t.fyhs.fragment.IndexFragment;
import com.dql.g150t.fyhs.fragment.InvestFragment;
import com.dql.g150t.fyhs.utils.SharedPreferencesUtil;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.ViewPagerFix;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.pager)
    ViewPagerFix mPager;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;

    private Activity mActivity;
    private long clickTime = 0;

    private List<Fragment> fragments = new ArrayList<>();
    private MainPagerAdapter adapter;
    private MyApplication application;
    private static final String TAG = "MainActivity";

    @Override
    public void init() {
        mActivity = MainActivity.this;
        //BarUtils.setStatusBarAlpha(mActivity,60);
        //application = (MyApplication) getApplication();

        //设置ViewPage无法左右滑动
        mPager.setScrollable(false);
        mPager.setOffscreenPageLimit(4);

        fragments.add(new IndexFragment());
        fragments.add(new InvestFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new AccountFragment());

        adapter = new MainPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);
        //设置底部导航栏
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor(R.color.black);
        mBottomNavigationBar.setActiveColor(R.color.org);
        mBottomNavigationBar.setBarBackgroundColor(R.color.material_white);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.icon_index_touch, getString(R.string.home_page)).setInactiveIconResource(R.mipmap.icon_index))
                .addItem(new BottomNavigationItem(R.mipmap.icon_invest_touch, getString(R.string.invest)).setInactiveIconResource(R.mipmap.icon_invest))
                .addItem(new BottomNavigationItem(R.mipmap.icon_find_touch, getString(R.string.account)).setInactiveIconResource(R.mipmap.icon_find))
                .addItem(new BottomNavigationItem(R.mipmap.icon_account_touch, getString(R.string.more)).setInactiveIconResource(R.mipmap.icon_account))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        // 判断是否是第一次开启应用
        boolean isFirstStart = SharedPreferencesUtil.getBoolean(this, SharedPreferencesUtil.FIRST_START, true);
        if (isFirstStart){
            Dialog();
        }



    }
    //首次进入app弹出去注册弹窗
    private void Dialog(){
        final Dialog dialog = new Dialog(mActivity,R.style.MyDialog);
        View contentView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_regist, null);
        final TextView tvRegist = (TextView) contentView.findViewById(R.id.tv_regist);
        tvRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, RegistActivity.class));
                dialog.dismiss();
            }
        });
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog .setCanceledOnTouchOutside(true);
//        dialog.setContentView(contentView);
        WindowManager manager = getWindowManager();
        Display d = manager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

//        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;   //设置宽度充满屏幕
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width=lp.width;
        layoutParams.height=lp.height;
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


//        dialog.getWindow().getAttributes().alpha=1;
        dialog.getWindow().setAttributes(layoutParams);


        dialog.setContentView(contentView);
        /*lp.width = (int) (d.getWidth()*0.8);
        lp.height = (int) (d.getHeight() * 0.1);*/
        dialog.show();
        SharedPreferencesUtil.putBoolean(this, SharedPreferencesUtil.FIRST_START, false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private class MainPagerAdapter extends FragmentPagerAdapter {

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    @Override
    public Activity bindActivity() {
        return this;
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - clickTime > 2000) {
            ToastUtil.showToast(mActivity, R.string.click_again_exit);
            clickTime = currentTime;
        } else {
            super.onBackPressed();
        }
    }

}
