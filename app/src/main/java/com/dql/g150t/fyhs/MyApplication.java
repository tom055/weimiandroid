package com.dql.g150t.fyhs;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.blankj.utilcode.util.Utils;
import com.dql.g150t.fyhs.http.ApiService;
import com.dql.g150t.fyhs.http.RetrofitClient;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by G150T on 2017/7/7.
 */

public class MyApplication extends Application {
    public boolean mRememberPassword = false;
    public boolean isFirstStart = true;
    public boolean isFirstOpen = true;
    public SharedPreferences mSharedPreferences = null;
    public ApiService apiService;
    public boolean isLogin = false;
    public String userId = "";
    public String username = "";

    /* private static MyApplication mInstance;

     public static MyApplication getInstance() {

         return mInstance;
     }
 */
    @Override
    public void onCreate() {
        super.onCreate();
        // mInstance = this ;
        initOkHttp();
        mSharedPreferences = getSharedPreferences(AppConfig.SHARED_PATH, MODE_PRIVATE);
        initLoginParams();
        Retrofit retrofit = RetrofitClient.getInstance();
        apiService = retrofit.create(ApiService.class);
        Utils.init(this);
    }

    public void initLoginParams() {
        SharedPreferences preferences = getSharedPreferences(AppConfig.SHARED_PATH, MODE_PRIVATE);
        Integer id = preferences.getInt(Constants.USERID, 0);
        String userName = preferences.getString(Constants.USERNAMECOOKIE, null);
        String userPwd = preferences.getString(Constants.USERPASSWORDCOOKIE, null);
        String phone = preferences.getString(Constants.PHONECOOKIE, null);
        Boolean userRemember = preferences.getBoolean(Constants.USERREMEMBERCOOKIE, false);
        isFirstOpen = preferences.getBoolean(Constants.FIRST_OPEN, true);
        isFirstStart = preferences.getBoolean(Constants.ISFIRSTSTART, true);
        if (!TextUtils.isEmpty(id + "") && !"0".equals(id + "")) {
            this.userId = id + "";
            isLogin = true;
            this.username = userName;
        } else {
            this.userId = "";
            isLogin = false;
            this.username = "";
        }
    }

    public void updateLoginParams(boolean flag, String userId, String username) {
        isLogin = flag;
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (mRememberPassword) {
            this.userId = userId;
            this.username = username;
            editor.putInt(Constants.USERID, Integer.parseInt(userId));
            editor.putString(Constants.USERNAMECOOKIE, username);
            editor.putBoolean(Constants.ISFIRSTSTART, false);
            editor.putBoolean(Constants.FIRST_OPEN, false);
        } else {
            this.userId = userId;
            this.username = username;
            editor.putInt(Constants.USERID, Integer.parseInt(userId));
            editor.putString(Constants.USERNAMECOOKIE, username);
            editor.putBoolean(Constants.ISFIRSTSTART, false);
            editor.putBoolean(Constants.FIRST_OPEN, false);
        }
        editor.commit();
        isFirstOpen = false;
        isFirstStart = false;
    }

    private void initOkHttp() {
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);

    }

    /**
     * 清空登录信息
     */
    public void clearLoginParams() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.commit();
        userId = null;
        isLogin = false;
        isFirstStart = true;
    }

}
