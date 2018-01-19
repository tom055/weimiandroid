//package com.example.g150t.gaocaisheng.activity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.bigkoo.convenientbanner.ConvenientBanner;
//import com.example.g150t.gaocaisheng.MyApplication;
//import com.example.g150t.gaocaisheng.R;
//import com.example.g150t.gaocaisheng.base.BaseActivity;
//import com.example.g150t.gaocaisheng.view.TopBar;
//import com.jude.easyrecyclerview.EasyRecyclerView;
//
//import butterknife.BindView;
//import butterknife.OnClick;
//
///**
// * 积分商城首页
// */
//public class ConvertIntegralActivity extends BaseActivity {
//
//    @BindView(R.id.topbar)
//    TopBar topbar;
//    @BindView(R.id.convenient_banner)
//    ConvenientBanner convenientBanner;
//    @BindView(R.id.tv_integral)
//    TextView tvIntegral;
//    @BindView(R.id.ll_convert_record)
//    LinearLayout llConvertRecord;
//    @BindView(R.id.easy_recycler_view)
//    EasyRecyclerView easyRecyclerView;
//    private Activity mActivity;
//    private MyApplication application;
//
//    @Override
//    public void init() {
//        mActivity = ConvertIntegralActivity.this;
//        application = (MyApplication) getApplication();
//        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
//            @Override
//            public void leftClick() {
//                finish();
//            }
//
//            @Override
//            public void rightClick() {
//
//            }
//        });
//    }
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_convert_integral;
//    }
//
//    @Override
//    public Activity bindActivity() {
//        return this;
//    }
//
//
//
//    @OnClick({R.id.ll_convert_record, R.id.easy_recycler_view})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.ll_convert_record:
//                startActivity(new Intent(mActivity,ConvertRecordActivity.class));
//                break;
//            case R.id.easy_recycler_view:
//                break;
//        }
//    }
//}
