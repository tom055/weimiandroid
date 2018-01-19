package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.WebViewManager;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;

public class ActivityById1Activity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.web_view)
    WebView webView;
    private Activity mActivity;
    private MyApplication application;
    private String url1;
    private String title;
    @Override
    public void init() {
        mActivity = ActivityById1Activity.this;
        application = (MyApplication) getApplication();
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        WebViewManager manager = new WebViewManager(webView);
        manager.enableAdaptive();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);//设置可支持缩放

        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//网页自适应屏幕宽度
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);//默认缩放尺寸为far
        webSettings.setBuiltInZoomControls(true);//出现缩放工具
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        url1 = getIntent().getStringExtra("url1");
        title = getIntent().getStringExtra("title");
        topbar.setTitle(title);
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        webView.loadUrl(url1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_by_id1;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


}
