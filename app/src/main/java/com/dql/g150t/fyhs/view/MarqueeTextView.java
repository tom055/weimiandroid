package com.dql.g150t.fyhs.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.dql.g150t.fyhs.R;

/**
 * Created by ST on 2017/8/16.
 */

public class MarqueeTextView extends LinearLayout {
//    private Context mContext;
//    private ViewFlipper viewFlipper;
//    private View marqueeTextView;
//    private String[] textArrays;
//    private MarqueeTextViewClickListener marqueeTextViewClickListener;
//
//    public MarqueeTextView(Context context) {
//        super(context);
//        mContext = context;
//        initBasicView();
//    }
//
//
//    public MarqueeTextView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        mContext = context;
//        initBasicView();
//    }
//
//    public void setTextArraysAndClickListener(String[] textArrays, MarqueeTextViewClickListener marqueeTextViewClickListener) {
//        this.textArrays = textArrays;
//        this.marqueeTextViewClickListener = marqueeTextViewClickListener;
//        initMarqueeTextView(textArrays, marqueeTextViewClickListener);
//    }
//
//    public void initBasicView() {
//        marqueeTextView = LayoutInflater.from(mContext).inflate(R.layout.marquee_textview_layout, null);
//        LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        addView(marqueeTextView, layoutParams);
//        viewFlipper = (ViewFlipper) marqueeTextView.findViewById(R.id.viewFlipper);
//        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_bottom));
//        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_top));
//        viewFlipper.startFlipping();
//    }
//
//    private static final String TAG = "MarqueeTextView";
//
//    public void initMarqueeTextView(String[] textArrays, MarqueeTextViewClickListener marqueeTextViewClickListener) {
//        if (textArrays.length == 0) {
//            return;
//        }
//
//        Log.d(TAG, "initMarqueeTextView: 开始");
//
//        int i = 0;
//        viewFlipper.removeAllViews();
//        while (i < textArrays.length) {
//            TextView textView = new TextView(mContext);
//            textView.setTextColor(Color.RED);
//            textView.setText(textArrays[i]);
//            textView.setOnClickListener(marqueeTextViewClickListener);
//            LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//            viewFlipper.addView(textView, lp);
//            i++;
//        }
//        Log.d(TAG, "initMarqueeTextView: 结束");
//    }
//
//    public void releaseResources() {
//        if (marqueeTextView != null) {
//            if (viewFlipper != null) {
//                viewFlipper.stopFlipping();
//                viewFlipper.removeAllViews();
//                viewFlipper = null;
//            }
//            marqueeTextView = null;
//        }
//    }

    private Context mContext;
    private ViewFlipper viewFlipper;
    private View marqueeTextView;
    private String[] textArrays;
    private MarqueeTextViewClickListener marqueeTextViewClickListener;

    public MarqueeTextView(Context context) {
        super(context);
        mContext = context;
        initBasicView();
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initBasicView();
    }

    public void setTextArraysAndClickListener(String[] textArrays, MarqueeTextViewClickListener marqueeTextViewClickListener) {
        this.textArrays = textArrays;
        this.marqueeTextViewClickListener = marqueeTextViewClickListener;
        initMarqueeTextView(textArrays, marqueeTextViewClickListener);
    }

    private static final String TAG = "MarqueeTextView";

    public void initBasicView() {
//        marqueeTextView = LayoutInflater.from(mContext).inflate(R.layout.marquee_textview_layout, null);
//        LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        addView(marqueeTextView, layoutParams);
//        viewFlipper = (ViewFlipper) marqueeTextView.findViewById(R.id.viewFlipper);
//        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_bottom));
//        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_top));
//        viewFlipper.startFlipping();

        Log.d(TAG, "initBasicView: ");
        marqueeTextView = LayoutInflater.from(mContext).inflate(R.layout.marquee_textview_layout, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(marqueeTextView, layoutParams);
        viewFlipper = (ViewFlipper) marqueeTextView.findViewById(R.id.viewFlipper);
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_bottom));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_top));
//        viewFlipper.startFlipping();
    }

    public void initMarqueeTextView(String[] textArrays, MarqueeTextViewClickListener marqueeTextViewClickListener) {
        if (textArrays.length == 0) {
            return;
        }
        Log.d(TAG, "initMarqueeTextView: a"+textArrays.length);
        int i = 0;
        viewFlipper.removeAllViews();
        while (i < textArrays.length) {
            Log.d(TAG, "initMarqueeTextView: "+i);
            TextView textView = new TextView(mContext);
            textView.setText(textArrays[i]);
            textView.setTextColor(Color.BLUE);
            textView.setTextSize(30f);
            textView.setOnClickListener(marqueeTextViewClickListener);
            LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            viewFlipper.addView(textView, lp);
            i++;
        }
        viewFlipper.setFlipInterval(5000);

        Log.d(TAG, "initMarqueeTextView: b");
        viewFlipper.startFlipping();
    }

    public void releaseResources() {
        if (marqueeTextView != null) {
            if (viewFlipper != null) {
                viewFlipper.stopFlipping();
                viewFlipper.removeAllViews();
                viewFlipper = null;
            }
            marqueeTextView = null;
        }
    }
}
