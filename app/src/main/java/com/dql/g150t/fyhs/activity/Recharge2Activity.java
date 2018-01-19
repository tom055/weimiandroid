package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.WebViewManager;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;

public class Recharge2Activity extends BaseActivity {

    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.activity_recharge2)
    LinearLayout activityRecharge2;
    @BindView(R.id.topbar)
    TopBar topbar;
    private Activity mActivity;
    private MyApplication application;
    private String url;
    private String data;

    @Override
    public void init() {
        mActivity = Recharge2Activity.this;
        application = (MyApplication) getApplication();
        url = getIntent().getStringExtra("url");
        WebSettings webSettings = webView.getSettings();
       data = getIntent().getStringExtra("data");
        WebViewManager manager = new WebViewManager(webView);
        manager.enableAdaptive();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        webView.postUrl(url, data.getBytes()/*EncodingUtils.getBytes(data, "Base64")*/);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recharge2;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



}
