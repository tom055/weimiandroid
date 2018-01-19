package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.PaymentReceivedAdapter;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.Collection;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 已还款
 */
public class PaymentReceivedFragment extends BaseFragment {
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    Unbinder unbinder;
    private Activity mActivity;
    private MyApplication application;
    private PaymentReceivedAdapter adapter; //当前页数
    private int pageNum = 1;
    //每一页显示的行数
    private int epage = 10;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "PaymentReceivedFragment";

    public PaymentReceivedFragment(){
        
    }
    public static PaymentReceivedFragment newInstance(String param1) {
        PaymentReceivedFragment fragment = new PaymentReceivedFragment();
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

    private void getPaymentReceived(final boolean isRefresh) {
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
        map.put("type","collection");
        map.put("currentPage",pageNum+"");
//        map.put("epage",epage+"");
        application.apiService.getCollection(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Collection>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onNext(Collection collection) {
                        for (int i = 0; i < collection.getCollections().size(); i++) {
                            collection.getCollections().get(i);
                        }
                        if (isRefresh) {
                            adapter.clear();
                            adapter.addAll(collection.getCollections());
                        } else {
                            adapter.addAll(collection.getCollections());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void init() {
        mActivity = getActivity();
        application = (MyApplication) mActivity.getApplication();
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new PaymentReceivedAdapter(mActivity);
        easyRecyclerView.setAdapter(adapter);
        getPaymentReceived(false);
        easyRecyclerView.setErrorView(R.layout.error_layout);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getPaymentReceived(true);
            }
        });
        adapter.setMore(R.layout.load_more_layout, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getPaymentReceived(false);
            }
        });
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_payment_received;
    }

    @Override
    public Object bindFragment() {
        return this;
    }


}
