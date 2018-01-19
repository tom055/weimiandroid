package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.MoneyRecordDetailAdapter;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.MoneyRecordDetail;
import com.dql.g150t.fyhs.view.TopBar;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoneyRecordDetailActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private Activity mActivity;
    private MyApplication application;
    private MoneyRecordDetailAdapter adapter;
    private int currentPage = 1 ;
    private static final String TAG = "MoneyRecordDetailActivity";
    @Override
    public void init() {
        mActivity = MoneyRecordDetailActivity.this;
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
        adapter = new MoneyRecordDetailAdapter(mActivity) ;

        getMoneyRecordDetail(true);

        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        easyRecyclerView.addItemDecoration(new DividerDecoration(R.color.material_white, 1));
        easyRecyclerView.setAdapter(adapter);

        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPage = 1 ;
                getMoneyRecordDetail(true);
            }
        });

        adapter.setMore(R.layout.load_more_layout, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                currentPage ++ ;
                getMoneyRecordDetail(false);
            }
        }) ;

    }
    private void getMoneyRecordDetail(final boolean isRefresh){
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
        map.put("currentPage",currentPage+"");
        application.apiService.getMoneyRecordDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MoneyRecordDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onNext(MoneyRecordDetail moneyRecordDetail) {
                        if (isRefresh){
                            adapter.clear();
                            adapter.addAll(moneyRecordDetail.getLogs());
                        }else{
                            adapter.addAll(moneyRecordDetail.getLogs());
                        }

                    }
                });
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_money_record_detail;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


}
