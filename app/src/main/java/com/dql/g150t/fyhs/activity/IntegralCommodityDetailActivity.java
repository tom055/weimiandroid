//package com.example.g150t.gaocaisheng.activity;
//
//import android.app.Activity;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.example.g150t.gaocaisheng.R;
//import com.example.g150t.gaocaisheng.base.BaseActivity;
//import com.example.g150t.gaocaisheng.view.TopBar;
//
//import butterknife.BindView;
//import butterknife.OnClick;
//
//public class IntegralCommodityDetailActivity extends BaseActivity {
//
//
//    @BindView(R.id.topbar)
//    TopBar topbar;
//    @BindView(R.id.iv_commodity_img)
//    ImageView ivCommodityImg;
//    @BindView(R.id.tv_commodity_name)
//    TextView tvCommodityName;
//    @BindView(R.id.tv_commodity_price)
//    TextView tvCommodityPrice;
//    @BindView(R.id.tv_inventory)
//    TextView tvInventory;
//    @BindView(R.id.tv_commodity_introduce)
//    TextView tvCommodityIntroduce;
//    @BindView(R.id.tv_convert)
//    TextView tvConvert;
//    @BindView(R.id.ll_convert)
//    LinearLayout llConvert;
//
//    @Override
//    public void init() {
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
//        return R.layout.activity_integral_commodity_detail;
//    }
//
//    @Override
//    public Activity bindActivity() {
//        return this;
//    }
//
//
//
//    @OnClick(R.id.ll_convert)
//    public void onClicked(View view) {
//        switch (view.getId()){
//            case R.id.ll_convert:
//                break;
//        }
//    }
//}
