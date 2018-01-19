package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.LinearLayout;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.RecomUrl;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InviteActivity extends BaseActivity {
    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.activity_invite)
    LinearLayout activityInvite;
    /*@BindView(R.id.imageView)
    ImageView imageView;*/
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = InviteActivity.this;
        application = (MyApplication) getApplication();
        topbar.setRightButton(true);
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                Map<String,String> map = new HashMap<>();
                map.put("userid",application.userId);
                application.apiService.getRecomUrl(map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<RecomUrl>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(RecomUrl recomUrl) {
                                copy(recomUrl.getRecommend_url(),mActivity);
                            }
                        });
            }
        });
        //Glide.with(mActivity).load(R.drawable.icon_friend).into(imageView);
    }


    private void copy(String content, Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setText(content);
        ToastUtil.showToast(mActivity, "您已复制邀请链接");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_invite;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



}
