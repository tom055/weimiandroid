package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;

import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.NewDetailRecord;
import com.dql.g150t.fyhs.view.TopBar;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewDetailActivity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.iv_activity)
    ImageView ivActivity;
    /*@BindView(R.id.web_view)
    WebView webView;*/
    /*@BindView(R.id.tv_content)
    TextView tvContent;*/
    private Activity mActivity;
    private MyApplication application;
    private String css;
    private static final String TAG = "NewDetailActivity";

    @Override
    public void init() {
        mActivity = NewDetailActivity.this;
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
        setLoad();
    }

    private void setLoad() {
        final Map<String, String> map = new HashMap<>();
        map.put("id", getIntent().getStringExtra("id"));
        map.put("userid", application.userId);
        application.apiService.getNewDetailRecord(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewDetailRecord>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewDetailRecord newDetailRecord) {
                        topbar.setTitle(newDetailRecord.getActivity().getActivity_name());
                        Log.e(TAG, "onNext: "+ Constants.BASE_URL_IMG+newDetailRecord.getActivity().getImgs());
                        Picasso.with(mActivity).load(Constants.BASE_URL_IMG+newDetailRecord.getActivity().getImgs()).into(ivActivity);
                        // tvContent.setText(newDetailRecord.getActivity().getContent());
                       /* WebSettings webSettings = webView.getSettings();
                        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
                        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
                        WebViewManager manager = new WebViewManager(webView);
                        webSettings.setJavaScriptEnabled(true);
                        webSettings.setSupportZoom(true);//设置可支持缩放
                        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//网页自适应屏幕宽度
                        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);//默认缩放尺寸为far
                        webSettings.setBuiltInZoomControls(true);//出现缩放工具
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.getSettings().setBlockNetworkImage(false);
                        manager.enableAdaptive();
                        webView.setWebViewClient(new WebViewClient() {
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                view.loadUrl(url);
                                return true;
                            }
                        });
                        css = "<style type=\"text/css\"> " +
                                "img {" +
                                "width:100%;" +
                                "height:auto;" +
                                "}" +
                                "body {" +
                                "margin-right:15px;" +
                                "margin-left:15px;" +
                                "margin-top:15px;" +
                                "font-size:45px;" +
                                "}" +
                                "p {" +
                                "size:16px;" +
                                "}" +
                                "</style>";*/
                        // webView.loadUrl(Constants.BASE_URL+"front_activity/toActivityById.dql?id="+getIntent().getStringExtra("id")/*+"&device=app"*/);
                    }
                });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_detail;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



}
