package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.MyInfo;
import com.dql.g150t.fyhs.model.ToRealname;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
    TopBar topbar;
    @BindView(R.id.tv_name)//用户名
    TextView tvName;
  /*  @BindView(R.id.tv_vip)//vip
    TextView tvVip;*/
    @BindView(R.id.tv_phone)//手机号
    TextView tvPhone;
    @BindView(R.id.tv_realname)//实名认证
    TextView tvRealname;
    @BindView(R.id.ll_realname)//实名认证按钮
    LinearLayout llRealname;
    @BindView(R.id.tv_bank_card)//绑定银行卡
    TextView tvBankCard;
    @BindView(R.id.ll_bank_card)//绑定银行卡按钮
    LinearLayout llBankCard;
    private Activity mActivity;
    private MyApplication application;
    private static final String TAG = "UserInfoActivity";

    @Override
    public void init() {
        mActivity = UserInfoActivity.this;
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
        loadData();
        realName();
        bankcard();
    }

    /**
     * 加载我的信息中的数据
     */
    private void loadData(){
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
        application.apiService.MyInfo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyInfo myInfo) {
                        tvName.setText(myInfo.getUser().getUserName());
                        //tvVip.setText("VIP"+myInfo.getItLevel().getDescription());
                        Log.e(TAG, "onNext: "+myInfo.getMobile().getMobileNum());
                        tvPhone.setText(myInfo.getMobile().getMobileNum().substring(0,3)+"****"+myInfo.getMobile().getMobileNum().substring(7,11));
                    }
                });
    }
    private void bankcard(){
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
        application.apiService.bankcard(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BankCard>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BankCard bankCard) {
                        if (bankCard.getStatus().equals("1")){
                            tvBankCard.setText("已绑定");
                        }else {
                            tvBankCard.setText("未绑定");
                        }
                    }
                });
    }
    private void realName(){
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
        application.apiService.toReal(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ToRealname>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ToRealname toRealname) {
                        int realNameContent = toRealname.getRealName().getStatus();
                        Log.e("sss", "onNext: "+realNameContent );
                        if (!toRealname.getRealName().equals("")&&realNameContent==1){
                            tvRealname.setText("已认证");
                        }
                        else if (toRealname.getRealName().getStatus()==0){
                            tvRealname.setText("审核中");
                        }else{
                            tvRealname.setText("未认证");
                        }
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.ll_realname, R.id.ll_bank_card})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_realname:
                Map<String,String> map = new HashMap<>();
                map.put("userid",application.userId);
                application.apiService.toReal(map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<ToRealname>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ToRealname toRealname) {
                                if (toRealname.getRealName()==null){
                                    startActivity(new Intent(mActivity, RealnameActivity.class));
                                }else{
                                    Log.e("sss", "onNext: "+toRealname.getRealName().getId() );
                                    Intent intent = new Intent(mActivity,RealnameActivity.class);
                                    intent.putExtra("id",toRealname.getRealName().getId());
                                    startActivity(intent);
                                }

                            }
                        });
                break;
            case R.id.ll_bank_card:
                Map<String,String> map1 = new HashMap<>();
                map1.put("userid",application.userId);
                application.apiService.bankcard(map1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<BankCard>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(BankCard bankCard) {
                                if (bankCard.getStatus().equals("1")){
                                    startActivity(new Intent(mActivity,BankCardActivity.class));
                                }else if (bankCard.getStatus().equals("0")){
                                    startActivity(new Intent(mActivity,BindCardActivity.class));
                                }else{
                                    ToastUtil.showToast(mActivity,bankCard.getMsg());
                                }
                            }
                        });
                break;
        }
    }
}
