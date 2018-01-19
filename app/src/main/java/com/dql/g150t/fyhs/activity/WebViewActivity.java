package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.WebViewManager;
import com.dql.g150t.fyhs.view.TopBar;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {
    @BindView(R.id.topbar)
    TopBar topBar;
    @BindView(R.id.web_view)
    WebView webView;

    private String title;
    private String content;
    private String css;
    private String pptUrl;
    private String profile;
    private String culture;
    private String cert;
    private String team;
    private String history;
    private String style;
    private String contact;
    private static final String TAG = "WebViewActivity";

    @Override
    public void init() {
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        pptUrl = getIntent().getStringExtra("pptUrl");
        profile = getIntent().getStringExtra("profile");
        culture = getIntent().getStringExtra("culture");
        cert = getIntent().getStringExtra("cert");
        team = getIntent().getStringExtra("team");
        history = getIntent().getStringExtra("history");
        style = getIntent().getStringExtra("style");
        contact = getIntent().getStringExtra("contact");
        topBar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        WebSettings webSettings = webView.getSettings();
        WebViewManager manager = new WebViewManager(webView);
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
                "</style>";




        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        Log.e(TAG, "init: "+pptUrl );
        webView.loadUrl(pptUrl);
        webView.loadUrl( profile);
        webView.loadUrl( culture);
        webView.loadUrl( cert);
        webView.loadUrl(team);
        webView.loadUrl( history);
        webView.loadUrl( style);
        webView.loadUrl( contact);

//         webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" + content + "</body></html>", "text/html", "UTF-8", null);
    }


    public void lodurl(final WebView webView, final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(url);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }
}
