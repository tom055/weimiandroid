package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.bumptech.glide.Glide;
import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.utils.WebViewManager;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    private String css;
    private String con;
    private String imgs;
    private Activity mActivity;
    private MyApplication application;

    @Override
    public void init() {
        mActivity = DetailActivity.this;
        application = (MyApplication) getApplication();
        con = getIntent().getStringExtra("con");
        imgs = getIntent().getStringExtra("imgs");
        String[] imgs = getIntent().getStringArrayExtra("img");
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
                "font-size:45px;" +
                "}" +
                "p {" +
                "size:16px;" +
                "}" +
                "</style>";

        if (imgs==null){
            webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" + replaceHtmlImgToAbsolutelyUrl(Constants.BASE_URL_IMG+"/",con) + "</body></html>", "text/html", "UTF-8", null);
        }else{
            for (int i=0;i<imgs.length;i++){
                ImageView iv = new ImageView(this);
                Glide.with(this).load(Constants.BASE_URL_IMG + imgs[i]).into(iv);
                mLlContainer.addView(iv);
            }
            webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" + replaceHtmlImgToAbsolutelyUrl(Constants.BASE_URL_IMG+"/",con) + "</body></html>", "text/html", "UTF-8", null);
        }
        //webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" +replaceHtmlImgToAbsolutelyUrl(Constants.BASE_URL_CONTENT+"/",con) + "</body></html>", "text/html", "UTF-8", null);
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
        return R.layout.activity_detail;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


}
