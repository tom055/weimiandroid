package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

public class NewBigBagActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.btn_one)
    Button btnOne;
    @BindView(R.id.btn_two)
    Button btnTwo;
//    @BindView(R.id.imageView)
//    ImageView imageView;
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = NewBigBagActivity.this;
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
        return R.layout.activity_new_big_bag;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.btn_one, R.id.btn_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                Dialog dialog = new Dialog(mActivity,R.style.MyDialog);
                View contentView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_rule_one, null);
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
                break;
            case R.id.btn_two:
                Dialog dialog1 = new Dialog(mActivity,R.style.MyDialog);
                View contentView1 = LayoutInflater.from(mActivity).inflate(R.layout.dialog_rule_two, null);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setCanceledOnTouchOutside(true);
//        dialog.setContentView(contentView);
                WindowManager manager1 = getWindowManager();
                Display d1 = manager1.getDefaultDisplay();
                WindowManager.LayoutParams lp1 = dialog1.getWindow().getAttributes();

//        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;   //设置宽度充满屏幕
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                WindowManager.LayoutParams layoutParams1 = new WindowManager.LayoutParams();
                layoutParams1.width=lp1.width;
                layoutParams1.height=lp1.height;
                dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


//        dialog.getWindow().getAttributes().alpha=1;
                dialog1.getWindow().setAttributes(layoutParams1);


                dialog1.setContentView(contentView1);
        /*lp.width = (int) (d.getWidth()*0.8);
        lp.height = (int) (d.getHeight() * 0.1);*/
                dialog1.show();
                break;
        }
    }
}
