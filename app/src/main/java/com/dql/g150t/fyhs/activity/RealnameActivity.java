package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.Realname;
import com.dql.g150t.fyhs.model.ToRealname;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RealnameActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
    TopBar topbar;
    @BindView(R.id.et_name)//名字输入框
    EditText etName;
    @BindView(R.id.et_card)//身份证输入框
    EditText etCard;
    @BindView(R.id.btn_submit)//审核按钮
    Button btnSubmit;
    private Activity mActivity;
    private MyApplication application;
    private static final String TAG = "RealnameActivity";

    @Override
    public void init() {
        mActivity = RealnameActivity.this;
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
       toRealname();
    }
    private void toRealname(){

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
                        if (!toRealname.getRealName().equals("")&&toRealname.getRealName().getStatus()==1){
                            etName.setText(toRealname.getRealName().getReal_name());
                            etCard.setText(toRealname.getRealName().getId_card_no());
                            etName.setEnabled(false);
                            etCard.setEnabled(false);
                            btnSubmit.setVisibility(View.GONE);
                        }else {
                            etCard.setText("");
                            etName.setText("");
                        }
                    }
                });
    }

    private void realname(){
        String name = etName.getText().toString().trim();
        String card = etCard.getText().toString().trim();
        Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
        boolean isCard = idNumPattern.matcher(card).matches();
        if (name.isEmpty()){
            ToastUtil.showToast(mActivity,"请输入身份证姓名");
            return;
        }
        if(card.isEmpty()){
            ToastUtil.showToast(mActivity,"请输入您的身份证号");
            return;
        }
        /*if (card.length()>18||card.length()<18){
            ToastUtil.showToast(mActivity,"请输入正确的身份证号码");
            return;
        }*/
        if (!isCard){
            ToastUtil.showToast(mActivity,"请输入正确的身份证号码");
            return;
        }
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
                        Log.e(TAG, "onError: "+e.toString() );
                    }

                    @Override
                    public void onNext(ToRealname toRealname) {
                        if (toRealname.getRealName()==null){
                            Map<String,String> map = new HashMap<>();
                            map.put("userid",application.userId);
                            map.put("real_name",etName.getText().toString());
                            map.put("id_card_no",etCard.getText().toString());
                            application.apiService.real(map)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Subscriber<Realname>() {
                                        @Override
                                        public void onCompleted() {

                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.e("sss", "onError: "+e.toString() );
                                        }

                                        @Override
                                        public void onNext(Realname realname) {
                                            Log.e("sss", "onNext: "+realname.getStatus());
                                            if (realname.getStatus().equals("1")){
                                                ToastUtil.showToast(mActivity,realname.getMsg());
                                                startActivity(new Intent(mActivity,BindCardActivity.class));
                                                finish();
                                            }else {
                                                ToastUtil.showToast(mActivity,"实名认证失败");
                                                return;
                                            }
                                        }
                                    });
                        }else{
                            Map<String,String> map = new HashMap<>();
                            map.put("userid",application.userId);
                            map.put("real_name",etName.getText().toString());
                            map.put("id_card_no",etCard.getText().toString());
                            map.put("id",getIntent().getStringExtra("id"));
                            Log.e(TAG, "onNext: "+application.userId );
                            Log.e(TAG, "onNext: "+getIntent().getStringExtra("id"));
                            application.apiService.real(map)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Subscriber<Realname>() {
                                        @Override
                                        public void onCompleted() {

                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.e("sss", "onError: "+e.toString() );
                                        }

                                        @Override
                                        public void onNext(Realname realname) {
                                            Log.e("sss", "onNext: "+realname.getStatus());
                                            if (realname.getStatus().equals("1")){
                                                ToastUtil.showToast(mActivity,realname.getMsg());
                                                startActivity(new Intent(mActivity,BindCardActivity.class));
                                                finish();
                                            }else {
                                                ToastUtil.showToast(mActivity,"实名认证失败");
                                                return;
                                            }
                                        }
                                    });
                        }
                    }
                });

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_realname;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick(R.id.btn_submit)
    public void onClicked(View view) {
        switch (view.getId()){
            case R.id.btn_submit:
                realname();
                break;
        }
    }
}
