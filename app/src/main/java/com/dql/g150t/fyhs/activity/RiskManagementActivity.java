package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;


import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.WebViewManager;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

public class RiskManagementActivity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.web_view)
    WebView webView;
    private String css;
    private String risk_warning;
    private String con;
    private String html;
    private MyApplication application;
    private Activity mActivity;
    private static final String TAG = "RiskManagementActivity";
    @Override
    public void init() {

        mActivity = RiskManagementActivity.this;
        application = (MyApplication) getApplication();
        risk_warning = getIntent().getStringExtra("risk_warning");
        con = getIntent().getStringExtra("con");
        Log.e(TAG, "init 1: "+risk_warning );
        Log.e(TAG, "init 2: "+con );
        html = risk_warning+con;
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        //topbar.setTitle(title);
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
                "font-size:45px;" +
                "}" +
                "p {" +
                "size:16px;" +
                "}" +
                "</style>";
        /*Pattern pattern = Pattern.compile("src\\s*=\\s*\"(.+?)\"");
        Matcher matcher = pattern.matcher(html);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String str = matcher.group(0);
            if (!str.contains("http://")){
                matcher.appendReplacement(sb,str.substring(0,5)+ Constants.BASE_URL+str.substring(6));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();*/
        webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" + replaceHtmlImgToAbsolutelyUrl(Constants.BASE_URL_CONTENT+"/",risk_warning) + "</body></html>", "text/html", "UTF-8", null);
    }
    public static String replaceHtmlImgToAbsolutelyUrl(String baseUrl, String html){
        Pattern pattern = Pattern.compile("src\\s*=\\s*\"(.+?)\"");
        Matcher matcher = pattern.matcher(html);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String str = matcher.group(0);
            if (!str.contains("http://")){
                matcher.appendReplacement(sb,str.substring(0,5)+baseUrl+str.substring(6));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_risk_management;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


}
