package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;

import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.PlatformAnnouncementDetail;
import com.dql.g150t.fyhs.utils.WebViewManager;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PlatformAnnouncementDetailActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.web_view)
    WebView webView;

    private Activity mActivity;
    private MyApplication application;
    private String css;
    private static final String TAG = "PlatformAnnouncementDet";

    @Override
    public void init() {
        mActivity = PlatformAnnouncementDetailActivity.this;
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
        Map<String, String> map = new HashMap<>();
        map.put("id", getIntent().getStringExtra("id"));
        application.apiService.getPlatformAnnouncementDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PlatformAnnouncementDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PlatformAnnouncementDetail platformAnnouncementDetail) {
                        topbar.setTitle(platformAnnouncementDetail.getNewsDetail().getTitle());
                        WebViewManager manager = new WebViewManager(webView);
                        manager.enableAdaptive();
                        Log.e(TAG, "onNext: "+platformAnnouncementDetail.getNewsDetail().getContent() );
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.getSettings().setBlockNetworkImage(false);
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
                                "line-height:55px !important;"+
                                "margin-left:15px;"+
                                "margin-top:15px;"+
                                "font-size:45px !important;"+
                                "}" +
                                "span {"+
                                "line-height:55px !important;"+
                                "margin-left:15px;"+
                                "margin-top:15px;"+
                                "font-size:45px !important;"+
                                "}"+
                                "div {"+
                                "line-height:55px !important;"+
                                "margin-left:15px;"+
                                "margin-top:15px;"+
                                "font-size:45px !important;"+
                                "}" +
                                "</style>";

                        webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" + replaceHtmlImgToAbsolutelyUrl(Constants.BASE_URL,platformAnnouncementDetail.getNewsDetail().getContent()) + "</body></html>", "text/html", "UTF-8", null);
                        //webView.loadDataWithBaseURL(null, "<html><header>" + css + "</header><body>" + platformAnnouncementDetail.getNewsDetail().getContent() + "</body></html>", "text/html", "UTF-8", null);
                    }
                });
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
        return R.layout.activity_platform_announcement_detail;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }



}
