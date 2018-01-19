package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.webkit.WebView;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.WebViewManager;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;

public class ProtocolActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.web_view)
    WebView webView;

    private Activity mActivity;
    private MyApplication application;
    private String css;
    private String protocol;

    @Override
    public void init() {
        mActivity = ProtocolActivity.this;
        application = (MyApplication) getApplication();
        protocol = getIntent().getStringExtra("protocol");
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        WebViewManager manager = new WebViewManager(webView);
        manager.enableAdaptive();
        css = "<style type=\"text/css\"> " +
                "img {" +
                "width:100%;" +
                "height:auto;" +
                "}" +
                "body {" +
                "margin-right:15px;" +
                "margin-left:15px;" +
                "margin-top:15px;" +
                "font-size:30px;" +
                "}" +
                "p {" +
                "size:13px;" +
                "}" +
                "</style>";
        webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" + protocol + "</body></html>", "text/html", "UTF-8", null);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_protocol;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }
}
