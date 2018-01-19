package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.activity.BindCardActivity;
import com.dql.g150t.fyhs.activity.InvsetDetailTwoActivity;
import com.dql.g150t.fyhs.activity.LoginActivity;
import com.dql.g150t.fyhs.activity.MoreRepaymentActivity;
import com.dql.g150t.fyhs.activity.MoreSellOutActivity;
import com.dql.g150t.fyhs.activity.RealnameActivity;
import com.dql.g150t.fyhs.adapter.HotSaleAdapter;
import com.dql.g150t.fyhs.adapter.RepaymentAdapter;
import com.dql.g150t.fyhs.adapter.SellOutAdapter;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.Index;
import com.dql.g150t.fyhs.model.Invest;
import com.dql.g150t.fyhs.model.ToRealname;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 理财
 */
public class InvestFragment extends BaseFragment {

    private static boolean isRealName = false;//是否实名认证的标志
    private static boolean isBindBankCard = false;//是否绑定银行卡的标志

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    @BindView(R.id.tv_more_one)
    TextView tvMoreOne;
    @BindView(R.id.easy_recycler_view_two)
    EasyRecyclerView easyRecyclerViewTwo;
    @BindView(R.id.tv_more_two)
    TextView tvMoreTwo;
    @BindView(R.id.easy_recycler_view_three)
    EasyRecyclerView easyRecyclerViewThree;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    /*@BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;*/
    private Activity mActivity;
    private MyApplication application;
    private HotSaleAdapter adapter;
    private SellOutAdapter sellOutAdapter;
    private RepaymentAdapter repaymentAdapter;
    private String id = null;
    private Index.BorrowsBean borrows = null;
    private Index.BorrowNewBean borrowsNew = null;

    //当前页数
    private int pageNum = 1;
    //每一页显示的行数
    private int epage = 10;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "InvestFragment";

    public InvestFragment() {

    }

    public static InvestFragment newInstance(String param1) {
        InvestFragment fragment = new InvestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void init() {
        mActivity = getActivity();
        application = (MyApplication) mActivity.getApplication();
        isBind();
        isReal();
        LinearLayoutManager linearLayout = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };

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
        /*easyRecyclerView.setNestedScrollingEnabled(false);
        easyRecyclerViewTwo.setNestedScrollingEnabled(false);
        easyRecyclerViewThree.setNestedScrollingEnabled(false);*/
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        easyRecyclerViewTwo.setLayoutManager(new LinearLayoutManager(mActivity));
        easyRecyclerViewThree.setLayoutManager(new LinearLayoutManager(mActivity));

        adapter = new HotSaleAdapter(mActivity);
        sellOutAdapter = new SellOutAdapter(mActivity);
        repaymentAdapter = new RepaymentAdapter(mActivity);

        easyRecyclerView.setAdapter(adapter);
        easyRecyclerViewTwo.setAdapter(sellOutAdapter);
        easyRecyclerViewThree.setAdapter(repaymentAdapter);

        getHotSale(false);
        getSellOut(false);
        getRepayment(false);

        easyRecyclerView.setErrorView(R.layout.error_layout);
        easyRecyclerViewTwo.setErrorView(R.layout.error_layout);
        easyRecyclerViewThree.setErrorView(R.layout.error_layout);

        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getHotSale(true);
            }
        });

        easyRecyclerViewTwo.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getSellOut(true);
            }
        });

        easyRecyclerViewThree.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getRepayment(true);
            }
        });

        adapter.setMore(R.layout.load_none, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

            }
        });
        sellOutAdapter.setMore(R.layout.load_none, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

            }
        });
        repaymentAdapter.setMore(R.layout.load_none, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    if (!isRealName) {
                        Log.e(TAG, "onViewClicked: " + isRealName);
                        startActivity(new Intent(mActivity, RealnameActivity.class));
                        ToastUtil.showToast(mActivity, "您未进行实名认证");
                    } else if (!isBindBankCard) {
                        Log.e(TAG, "onViewClicked: " + isBindBankCard);
                        startActivity(new Intent(mActivity, BindCardActivity.class));
                        ToastUtil.showToast(mActivity, "您未绑定银行卡");
                    } else {
                        Map<String, String> map = new HashMap<>();
                        map.put("status", "3");
                        application.apiService.getIvest(map)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<Invest>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(Invest invest) {
                                        Intent intent = new Intent(mActivity, InvsetDetailTwoActivity.class);
                                        intent.putExtra("id", adapter.getItem(position).getId() + "");
                                        startActivity(intent);


                                    }
                                });
                    }

                }
            }
        });
        sellOutAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    if (!isRealName) {
                        Log.e(TAG, "onViewClicked: " + isRealName);
                        startActivity(new Intent(mActivity, RealnameActivity.class));
                        ToastUtil.showToast(mActivity, "您未进行实名认证");
                    } else if (!isBindBankCard) {
                        Log.e(TAG, "onViewClicked: " + isBindBankCard);
                        startActivity(new Intent(mActivity, BindCardActivity.class));
                        ToastUtil.showToast(mActivity, "您未绑定银行卡");
                    } else {
                        Map<String, String> map = new HashMap<>();
                        map.put("status", "5");
                        application.apiService.getIvest(map)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<Invest>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onNext(Invest invest) {
                                        Intent intent = new Intent(mActivity, InvsetDetailTwoActivity.class);
                                        Log.e(TAG, "onNext: id:" + id);
                                        intent.putExtra("id", sellOutAdapter.getItem(position).getId() + "");
                                        startActivity(intent);


                                    }
                                });
                    }


                }
            }
        });
        repaymentAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    if (!isRealName) {
                        Log.e(TAG, "onViewClicked: " + isRealName);
                        startActivity(new Intent(mActivity, RealnameActivity.class));
                        ToastUtil.showToast(mActivity, "您未进行实名认证");
                    } else if (!isBindBankCard) {
                        Log.e(TAG, "onViewClicked: " + isBindBankCard);
                        startActivity(new Intent(mActivity, BindCardActivity.class));
                        ToastUtil.showToast(mActivity, "您未绑定银行卡");
                    } else {
                        Map<String, String> map = new HashMap<>();
                        map.put("status", "6");
                        application.apiService.getIvest(map)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<Invest>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Log.e(TAG, "onError: " + e.toString());
                                    }

                                    @Override
                                    public void onNext(Invest invest) {
                                        Intent intent = new Intent(mActivity, InvsetDetailTwoActivity.class);
                                        Log.e(TAG, "onNext: id:" + id);
                                        intent.putExtra("id", repaymentAdapter.getItem(position).getId() + "");
                                        startActivity(intent);


                                    }
                                });

                    }

                }
            }
        });
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
                        Log.e("sss", "onNext: " + realNameContent);
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

    private void refresh() {
        getHotSale(true);
        getSellOut(true);
        getRepayment(true);
        isReal();
        isBind();
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.action.user.exit")) {

            } else if (intent.getAction().equals("android.action.toWithDraw")) {

            } else if (intent.getAction().equals("android.action.refresh")) {
                refresh();
            }
        }
    };

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
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            refresh();
        }
    }

    //热销中
    private void getHotSale(final boolean isRefresh) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "3");
        application.apiService.getIvest(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Invest>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //Log.e(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(Invest invest) {
                        if (isRefresh) {
                            adapter.clear();
                            adapter.addAll(invest.getBorrows());
                        } else {
                            adapter.addAll(invest.getBorrows());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    //已售罄
    private void getSellOut(final boolean isRefresh) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "5");
        //map.put("currentPage",pageNum+"");
        application.apiService.getIvest(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Invest>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(Invest invest) {
                        if (isRefresh) {
                            sellOutAdapter.clear();
                        }
                        for (int i = 0; i < 3; i++) {
                            sellOutAdapter.add(invest.getBorrows().get(i));

                        }
                        sellOutAdapter.notifyDataSetChanged();


                    }
                });
    }

    //已还款
    private void getRepayment(final boolean isRefresh) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "6");
        //map.put("currentPage",pageNum+"");
        application.apiService.getIvest(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Invest>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(Invest invest) {
                        if (isRefresh) {
                            repaymentAdapter.clear();
                        }
                        for (int i = 0; i < 3; i++) {
                            repaymentAdapter.add(invest.getBorrows().get(i));

                        }
                        repaymentAdapter.notifyDataSetChanged();


                    }
                });
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_invest;
    }

    @Override
    public Object bindFragment() {
        return this;
    }


    @OnClick({R.id.tv_more_one, R.id.tv_more_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_more_one:
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    startActivity(new Intent(mActivity, MoreSellOutActivity.class));
                }
                break;
            case R.id.tv_more_two:
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    startActivity(new Intent(mActivity, MoreRepaymentActivity.class));
                }
                break;
        }
    }
}
