package com.dql.g150t.fyhs.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;


import com.dql.g150t.fyhs.utils.PhoneFormatCheckUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/9/3.
 * 获取短信验证码倒计时按钮
 */
public class TimeButton extends Button implements View.OnClickListener {
    private long length = 60 * 1000;//默认60秒
    private String textAfter = "秒后重新获取";
    private String textBefore = "点击获取验证码";
    private final String TIME = "time";
    private final String CTIME = "ctime";
    private OnClickListener mOnClickListener;
    private Timer t;
    private TimerTask tt;
    private long time;
    Map<String, Long> map = new HashMap<>();
    private String phone =null;

    public void setMobile(String phone){
        this.phone = phone;
    }
    public TimeButton(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public TimeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @SuppressWarnings("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TimeButton.this.setText(time / 1000 + textAfter);
            time -= 1000;
            if (time < 0) {
                TimeButton.this.setEnabled(true);
                TimeButton.this.setText(textBefore);
                clearTimer();
            }
        }
    };

    /**
     * 初始化
     */
    private void initTimer() {
        time = length;
        t = new Timer();
        tt = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x01);
            }
        };
    }


    /**
     * 清除计时
     */
    private void clearTimer() {
        if (tt != null) {
            tt.cancel();
            tt = null;
        }
        if (t != null) {
            t.cancel();
            t = null;
        }
    }

    @Override
    public void setOnClickListener(OnClickListener listener) {
        if (listener instanceof TimeButton) {
            super.setOnClickListener(listener);
        } else {
            this.mOnClickListener = listener;
        }
    }

    @Override
    public void onClick(View view) {
        if (mOnClickListener != null) {
            mOnClickListener.onClick(view);
            if (!TextUtils.isEmpty(phone) && PhoneFormatCheckUtils.isPhoneLegal(phone.toString())) {
                initTimer();
                this.setText(time / 1000 + textAfter);
                this.setEnabled(false);
                t.schedule(tt, 0, 1000);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (map == null)
            return;
        if (map.size() <= 0)
            return;
        long time = System.currentTimeMillis() - map.get(CTIME) - map.get(TIME);
        map.clear();
        if (time > 0) {
            return;
        } else {
            initTimer();
            this.time = Math.abs(time);
            t.schedule(tt, 0, 1000);
            this.setText(time + textAfter);
            this.setEnabled(false);
        }
    }

    public TimeButton setTextAfter(String textAfter1) {
        this.textAfter = textAfter1;
        return this;
    }

    public TimeButton setTextBefore(String text0) {
        this.textBefore = text0;
        this.setText(textBefore);
        return this;
    }

    public TimeButton setLength(Long length) {
        this.length = length;
        return this;
    }
    /*private long length = 60 * 1000;//默认60秒
    private String textAfter = "秒后重新获取";
    private String textBefore = "点击获取验证码";
    private final String TIME = "time";
    private final String CTIME = "ctime";
    private OnClickListener mOnClickListener;
    private Timer t;
    private TimerTask tt;
    private long time;
    Map<String, Long> map = new HashMap<>();

    private int code ;
    private String mobile = null ;
    private String newpassword = null ;

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
    }

    public void setMobile(int code , String mobile){
        this.code = code ;
        this.mobile = mobile ;

    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public TimeButton(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public TimeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @SuppressWarnings("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TimeButton.this.setText(time / 1000 + textAfter);
            time -= 1000;
            if (time < 0) {
                TimeButton.this.setEnabled(true);
                TimeButton.this.setText(textBefore);
                clearTimer();
            }
        }
    };

    *//**
     * 初始化
     *//*
    private void initTimer() {
        time = length;
        t = new Timer();
        tt = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x01);
            }
        };
    }


    *//**
     * 清除计时
     *//*
    private void clearTimer() {
        if (tt != null) {
            tt.cancel();
            tt = null;
        }
        if (t != null) {
            t.cancel();
            t = null;
        }
    }

    @Override
    public void setOnClickListener(OnClickListener listener) {
        if (listener instanceof TimeButton) {
            super.setOnClickListener(listener);
        } else {
            this.mOnClickListener = listener;
        }
    }

    @Override
    public void onClick(View view) {
        if (mOnClickListener != null) {
            mOnClickListener.onClick(view);
            if (code == 1){
                if (!TextUtils.isEmpty(mobile) && PhoneFormatCheckUtils.isPhoneLegal(mobile.toString())){
                    if (!TextUtils.isEmpty(newpassword)){
                        initTimer();
                        this.setText(time / 1000 + textAfter);
                        this.setEnabled(false);
                        t.schedule(tt, 0, 1000);
                    }
                }
            }else if (code == 2){
                if (!TextUtils.isEmpty(mobile) && PhoneFormatCheckUtils.isPhoneLegal(mobile.toString())){
                    initTimer();
                    this.setText(time / 1000 + textAfter);
                    this.setEnabled(false);
                    t.schedule(tt, 0, 1000);
                }
            }
            *//*initTimer();
            this.setText(time / 1000 + textAfter);
            this.setEnabled(false);
            t.schedule(tt, 0, 1000);*//*
        }
    }

    public void onCreate(Bundle bundle) {
        if (map == null)
            return;
        if (map.size() <= 0)
            return;
        long time = System.currentTimeMillis() - map.get(CTIME) - map.get(TIME);
        map.clear();
        if (time > 0) {
            return;
        } else {
            initTimer();
            this.time = Math.abs(time);
            t.schedule(tt, 0, 1000);
            this.setText(time + textAfter);
            this.setEnabled(false);
        }
    }

    public TimeButton setTextAfter(String textAfter1) {
        this.textAfter = textAfter1;
        return this;
    }

    public TimeButton setTextBefore(String text0) {
        this.textBefore = text0;
        this.setText(textBefore);
        return this;
    }

    public TimeButton setLength(Long length) {
        this.length = length;
        return this;
    }*/
}
