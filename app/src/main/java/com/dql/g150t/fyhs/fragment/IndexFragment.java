package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.activity.BindCardActivity;
import com.dql.g150t.fyhs.activity.InvestDetailActivity;
import com.dql.g150t.fyhs.activity.InviteActivity;
import com.dql.g150t.fyhs.activity.LoginActivity;
import com.dql.g150t.fyhs.activity.NewBigBagActivity;
import com.dql.g150t.fyhs.activity.PlatformAnnouncementDetailActivity;
import com.dql.g150t.fyhs.activity.RealnameActivity;
import com.dql.g150t.fyhs.activity.WebViewActivity;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.Index;
import com.dql.g150t.fyhs.model.Login;
import com.dql.g150t.fyhs.model.MyInfo;
import com.dql.g150t.fyhs.model.PlatformAnnouncement;
import com.dql.g150t.fyhs.model.ToRealname;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.taobao.library.BaseBannerAdapter;
import com.taobao.library.VerticalBannerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 首页
 */
public class IndexFragment extends BaseFragment {
    private static boolean isRealName = false;//是否实名认证的标志
    private static boolean isBindBankCard = false;//是否绑定银行卡的标志

    @BindView(R.id.convenient_banner)//轮播图
            ConvenientBanner convenientBanner;
//    @BindView(R.id.tv_site_notice)//网站公告
//            MarqueeTextView tvSiteNotice;

    @BindView(R.id.tv_site_notice)//网站公告
            VerticalBannerView tvSiteNotice;
    /*@BindView(R.id.tv_more)//更多
            TextView tvMore;*/
    @BindView(R.id.ll_new_gift)//新手大礼包
            LinearLayout llNewGift;
    @BindView(R.id.ll_invite)//推荐有奖
            LinearLayout llInvite;
    //    @BindView(R.id.ll_sign_in)//签到有礼
//            LinearLayout llSignIn;
    @BindView(R.id.tv_invest_values)//标的类型--新手还是日常
            TextView tvInvestValues;
    @BindView(R.id.tv_invest_title)//标名
            TextView tvInvestTitle;
    @BindView(R.id.tv_apr)//利率
            TextView tvApr;
   /* @BindView(R.id.tv_invest_type)//计息类型
            TextView tvInvestType;*/
    @BindView(R.id.tv_day)//天数
            TextView tvDay;
    @BindView(R.id.tv_invest_money)//最少多少起投
            TextView tvInvestMoney;
    @BindView(R.id.btn_buy)//购买按钮
            Button btnBuy;
    @BindView(R.id.swipe_refresh)//刷新
            SwipeRefreshLayout swipeRefresh;
    private Activity mActivity;
    private MyApplication application;
    private ArrayList<String> localImages = new ArrayList<>();//轮播图资源集合
    private ArrayList<String> pptUrl = new ArrayList<>();//链接集合
    private ArrayList<String> noticeList = new ArrayList<>();//公告集合
    private Index.BorrowsBean borrows = null;
    private Index.BorrowNewBean borrowsNew = null;
    private static boolean isNew = false;
    private Login login = null;
    private DecimalFormat df = new DecimalFormat("0.00");
    private static final String TAG = "IndexFragment";
    //当前页数
    private int pageNum = 1,isdayNew;

    @Override
    public void init() {
        mActivity = getActivity();
        application = (MyApplication) mActivity.getApplication();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
                refresh();
            }
        });
        swipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setRefreshing(true);
                refresh();
                swipeRefresh.setRefreshing(false);
            }
        });
        banner();
        onClickBanner();
        loadData();
        noticeTitle();
        isReal();
        isBind();
    }

    private void refresh() {
        loadData();
        isReal();
        isBind();
    }


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.action.user.exit")) {

            } else if (intent.getAction().equals("android.action.toWithDraw")) {

            } else if (intent.getAction().equals("android.action.refresh")) {
                loadData();
                isBind();
                isReal();
            }
        }
    };

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            loadData();
            isReal();
            isBind();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.action.user.exit");
        filter.addAction("android.action.toWithDraw");
        filter.addAction("android.action.refresh");
        mActivity.registerReceiver(receiver, filter);
        refresh();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity.unregisterReceiver(receiver);
    }

    @Override
    public void onStop() {
        super.onStop();
        tvSiteNotice.stop();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isStartBanner) {
            tvSiteNotice.start();
        }
    }

    /**/
    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }




    @Override
    public int getFragmentId() {
        return R.layout.fragment_index;
    }

    @Override
    public Object bindFragment() {
        return this;
    }




    /**
     * 设置轮播图
     *
     * @return
     */
    private void setBanner() {
        convenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, localImages)
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        convenientBanner.startTurning(5000);
    }

    /**
     * 网络请求轮播图和跳转地址
     */
    private void banner() {
        Map<String, String> map = new HashMap<>();
        application.apiService.index(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Index>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("sss", "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(Index index) {
                        for (int i = 0; i < index.getWxBanner().size(); i++) {
                            localImages.add(Constants.BASE_URL_IMG + index.getWxBanner().get(i).getUrl());
                            Log.e(TAG, "onNext: "+index.getWxBanner().get(i).getPpt_url() );
                            pptUrl.add(index.getWxBanner().get(i).getPpt_url());
                        }
                        setBanner();
                    }
                });

    }

    /**
     * 设置轮播图的点击跳转事件
     */
    private void onClickBanner() {
        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String s = pptUrl.get(position);
                if (TextUtils.isEmpty(s) || "http://".equals(s)) {

                } else {
                    Intent intent = new Intent(mActivity, WebViewActivity.class);
                    Log.e(TAG, "onItemClick: "+pptUrl.get(position).toString() );
                    intent.putExtra("pptUrl", pptUrl.get(position).toString());
                    startActivity(intent);
                }
            }

        });
    }

    private class LocalImageHolderView implements Holder<String> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide.with(mActivity).load(data).into(imageView);
        }
    }

    //获取首页标的信息
    private void loadData() {
        Map<String, String> map = new HashMap<>();
        application.apiService.index(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Index>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString() );
                    }

                    @Override
                    public void onNext(final Index index) {

                        if (index.getBorrowNew().size() ==0 ) {
                            return;
                        }
                        borrowsNew = index.getBorrowNew().get(0);

                        isdayNew = borrowsNew.getIs_day();

                        //未登录显示推荐新手标
                        if (!application.isLogin) {
                            tvInvestValues.setText(borrowsNew.getTypeName());
                            tvInvestTitle.setText(borrowsNew.getName());
                            tvApr.setText(df.format(borrowsNew.getApr()) + "%");
                            if (isdayNew == 0) {
                                tvDay.setText(borrowsNew.getTime_limit() + "个月");
                            } else {
                                tvDay.setText(borrowsNew.getTime_limit() + "天");
                            }
                            tvInvestMoney.setText(df.format(borrowsNew.getLowest_account()) + "");

                        } else {//登录的话有新手权限显示新手标没有新手权限显示普通标
                            Map<String, String> map = new HashMap<>();
                            map.put("userid", application.userId);
                            Log.e(TAG, "onNext:id--> "+application.userId );
                            /*Call<ResponseBody> call=application.apiService.MyInfo2(map);
                            call.enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    try {
                                        Log.e("Mytext","MyInfo2---->"+response.body().string());
                                        System.out.println(response.body().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                    Log.e("Mytext","MyInfo2---fail");
                                }
                            });*/
                            application.apiService.MyInfo(map)
                                    .subscribeOn(Schedulers.io())
                                    .unsubscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Subscriber<MyInfo>() {
                                        @Override
                                        public void onCompleted() {

                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.e(TAG, "onError: "+e.toString() );
                                        }

                                        @Override
                                        public void onNext(MyInfo myInfo) {
                                            String isNew = myInfo.getIsNew();
                                            Log.e("sss", "onNext  isnew: " + isNew);

//                                            Log.e("sss", "onNext: " + application.userId);
                                            if ("1".equals(isNew)) {
                                                tvInvestValues.setText(borrowsNew.getTypeName());
                                                tvInvestTitle.setText(borrowsNew.getName());
                                                tvApr.setText(df.format(borrowsNew.getApr()) + "%");
                                                if (isdayNew == 0) {
                                                    tvDay.setText(borrowsNew.getTime_limit() + "个月");
                                                } else {
                                                    tvDay.setText(borrowsNew.getTime_limit() + "天");
                                                }
                                                tvInvestMoney.setText(df.format(borrowsNew.getLowest_account()) + "");
                                            } else if ("0".equals(isNew)) {
                                                if (index.getBorrows().size() == 0) {
                                                    return;
                                                }
                                                borrows = index.getBorrows().get(0);
                                                final int type = borrows.getType();
                                                final int isday = borrows.getIs_day();
                                                if (type == 1) {
                                                    tvInvestValues.setText(borrows.getTypeName());
                                                    tvInvestTitle.setText(borrows.getName());
                                                    tvApr.setText(borrows.getApr() + "%");
                                                    if (isday == 0) {
                                                        tvDay.setText(borrows.getTime_limit() + "个月");
                                                    } else {
                                                        tvDay.setText(borrows.getTime_limit() + "天");
                                                    }
                                                    tvInvestMoney.setText(df.format(borrows.getLowest_account()) + "");
                                                } else if (type == 2) {
                                                    tvInvestValues.setText(borrows.getTypeName());
                                                    tvInvestTitle.setText(borrows.getName());
                                                    tvApr.setText(borrows.getApr() + "%");
                                                    if (isday == 0) {
                                                        tvDay.setText(borrows.getTime_limit() + "个月");
                                                    } else {
                                                        tvDay.setText(borrows.getTime_limit() + "天");
                                                    }
                                                    tvInvestMoney.setText(df.format(borrows.getLowest_account()) + "");
                                                } else if (type == 3) {
                                                    tvInvestValues.setText(borrows.getTypeName());
                                                    tvInvestTitle.setText(borrows.getName());
                                                    tvApr.setText(borrows.getApr() + "%");
                                                    if (isday == 0) {
                                                        tvDay.setText(borrows.getTime_limit() + "个月");
                                                    } else {
                                                        tvDay.setText(borrows.getTime_limit() + "天");
                                                    }
                                                    tvInvestMoney.setText(df.format(borrows.getLowest_account()) + "");
                                                } else if (type == 4) {
                                                    tvInvestValues.setText(borrows.getTypeName());
                                                    tvInvestTitle.setText(borrows.getName());
                                                    tvApr.setText(borrows.getApr() + "%");
                                                    if (isday == 0) {
                                                        tvDay.setText(borrows.getTime_limit() + "个月");
                                                    } else {
                                                        tvDay.setText(borrows.getTime_limit() + "天");
                                                    }
                                                    tvInvestMoney.setText(df.format(borrows.getLowest_account()) + "");
                                                } else if (type == 5) {
                                                    tvInvestValues.setText(borrows.getTypeName());
                                                    tvInvestTitle.setText(borrows.getName());
                                                    tvApr.setText(borrows.getApr() + "%");
                                                    if (isday == 0) {
                                                        tvDay.setText(borrows.getTime_limit() + "个月");
                                                    } else {
                                                        tvDay.setText(borrows.getTime_limit() + "天");
                                                    }
                                                    tvInvestMoney.setText(df.format(borrows.getLowest_account()) + "");
                                                }
                                            }
                                        }
                                    });


                        }

                    }
                });
    }

    //获取公告标题
    private void noticeTitle() {
        Map<String, String> map = new HashMap<>();
        map.put("currentPage", pageNum + "");
        application.apiService.getPlatformAnnouncement(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PlatformAnnouncement>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(PlatformAnnouncement platformAnnouncement) {
//                        Log.e(TAG, "onNext: "+platformAnnouncementDetail.getNewsDetail().getTitle()+"");
                        if (null != platformAnnouncement && null != platformAnnouncement.getAnnouncement() && platformAnnouncement.getAnnouncement().size() > 0) {
                            List<String> list = new ArrayList<>();
                            for (int i = 0; i < platformAnnouncement.getAnnouncement().size(); i++) {
                                list.add(platformAnnouncement.getAnnouncement().get(i).getTitle());
                            }
//                            mHandler.sendEmptyMessage(0);

//                            tvSiteNotice.setTextArraysAndClickListener(strings, new MarqueeTextViewClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    ToastUtil.showToast(mActivity, "a");
//                                }
//                            });

                            isStartBanner = !isStartBanner;


                            ContentBannerAdapter adapter = new ContentBannerAdapter(platformAnnouncement.getAnnouncement());
                            tvSiteNotice.setAdapter(adapter);
                            tvSiteNotice.start();
                        }


                    }
                });
    }

    boolean isStartBanner = false;


    class ContentBannerAdapter extends BaseBannerAdapter<PlatformAnnouncement.AnnouncementBean> {

        private List<PlatformAnnouncement.AnnouncementBean> mDatas;

        public ContentBannerAdapter(List<PlatformAnnouncement.AnnouncementBean> datas) {
            super(datas);
            mDatas = datas;
        }

        @Override
        public View getView(VerticalBannerView parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner_text, null);

        }

        @Override
        public void setItem(final View view, final PlatformAnnouncement.AnnouncementBean data) {
//            TextView textView = new TextView(mActivity);

            TextView textView = (TextView) view.findViewById(R.id.tv_banner_text);

//            textView.setTextColor(Color.RED);
            textView.setText(data.getTitle());
            //你可以增加点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity, PlatformAnnouncementDetailActivity.class);
                    intent.putExtra("id", data.getId() + "");
                    startActivity(intent);
                }
            });
        }
    }


    //首页公告
    private void newDetail() {
        /*Map<String, String> map = new HashMap<>();
        map.put("currentPage", pageNum + "");
        application.apiService.getPlatformAnnouncement(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PlatformAnnouncement>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(PlatformAnnouncement platformAnnouncement) {
                        //Log.e(TAG, "onNext: "+platformAnnouncementDetail.getNewsDetail().getTitle()+"");
                        for (int i = 0; i < platformAnnouncement.getAnnouncement().size(); i++) {
                            tvSiteNotice.setText(platformAnnouncement.getAnnouncement().get(i).getTitle());
                        }


                    }
                });*/
        /*tvSiteNotice.setTextArraysAndClickListener(noticeList, new MarqueeTextViewClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    //是否实名认证
    private void isReal() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        application.apiService.toReal(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ToRealname>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ToRealname toRealname) {
                        int realNameContent = toRealname.getRealName().getStatus();
                       // Log.e("sss", "onNext: " + realNameContent);
                        if (!toRealname.getRealName().equals("") && realNameContent == 1) {
                            isRealName = true;
                        } else {
                            isRealName = false;
                        }
                    }
                });
    }

    //是否绑定银行卡
    private void isBind() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        Log.e(TAG, "isBind: "+application.userId );
        application.apiService.bankcard(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BankCard>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BankCard bankCard) {
                        if (bankCard.getStatus().equals("1")) {
                            isBindBankCard = true;
                        } else {
                            isBindBankCard = false;
                        }
                    }
                });
    }


    @OnClick({R.id.tv_site_notice/*, R.id.tv_more*/, R.id.ll_new_gift, R.id.ll_invite/*, R.id.ll_sign_in*/, R.id.btn_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_site_notice://点击跳转到公告
                /*Map<String, String> map1 = new HashMap<>();
                map1.put("currentPage", pageNum + "");
                application.apiService.getPlatformAnnouncement(map1)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<PlatformAnnouncement>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(PlatformAnnouncement platformAnnouncement) {

                                for (int i = 0; i < platformAnnouncement.getAnnouncement().size(); i++) {
                                    Intent intent = new Intent(mActivity, PlatformAnnouncementDetailActivity.class);
                                    intent.putExtra("id", platformAnnouncement.getAnnouncement().get(0).getId() + "");
                                    startActivity(intent);
                                }
                            }
                        });*/
                break;
           /* case R.id.tv_more:
                startActivity(new Intent(mActivity, MoreNewDetailActivity.class));
                break;*/
            case R.id.ll_new_gift:
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    startActivity(new Intent(mActivity, NewBigBagActivity.class));
                }
                break;
            case R.id.ll_invite:
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    startActivity(new Intent(mActivity, InviteActivity.class));
                }
                break;
            case R.id.btn_buy:
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    if (!isRealName) {
                        startActivity(new Intent(mActivity, RealnameActivity.class));
                        ToastUtil.showToast(mActivity, "您未进行实名认证");
                    } else if (!isBindBankCard) {
                        startActivity(new Intent(mActivity, BindCardActivity.class));
                        ToastUtil.showToast(mActivity, "您未绑定银行卡");
                    } else {
                        Map<String, String> map = new HashMap<>();
                        application.apiService.index(map)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<Index>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(Index index) {
                                        if (index.getBorrows().size() == 0) {
                                            return;
                                        }
                                        borrows = index.getBorrows().get(0);
                                        if (index.getBorrowNew().size() == 0) {
                                            return;
                                        }
                                        borrowsNew = index.getBorrowNew().get(0);
                                        Intent intent = new Intent(mActivity, InvestDetailActivity.class);
                                        intent.putExtra("newBorrowId", borrowsNew.getId());
                                        intent.putExtra("borrowId", borrows.getId());
                                        startActivity(intent);
                                    }
                                });
                    }


                }
                break;
        }
    }
}
