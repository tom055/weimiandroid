//package com.example.g150t.gaocaisheng.activity;
//
//import android.app.Activity;
//import android.os.Bundle;
//
//import com.example.g150t.gaocaisheng.MyApplication;
//import com.example.g150t.gaocaisheng.R;
//import com.example.g150t.gaocaisheng.base.BaseActivity;
//import com.example.g150t.gaocaisheng.view.TopBar;
//import com.jude.easyrecyclerview.EasyRecyclerView;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class ConvertRecordActivity extends BaseActivity {
//
//    @BindView(R.id.topbar)
//    TopBar topbar;
//    @BindView(R.id.easy_recycler_view)
//    EasyRecyclerView easyRecyclerView;
//    private Activity mActivity;
//    private MyApplication application;
//
//    @Override
//    public void init() {
//        mActivity = ConvertRecordActivity.this;
//        application = (MyApplication) getApplication();
//
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
//        return R.layout.activity_convert_record;
//    }
//
//    @Override
//    public Activity bindActivity() {
//        return this;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
//}
