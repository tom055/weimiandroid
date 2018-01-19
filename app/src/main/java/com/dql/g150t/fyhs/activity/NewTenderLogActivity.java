package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.TenderLogAdapter;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.InvestDetail;
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

public class NewTenderLogActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private Activity mActivity;
    private MyApplication application;
    private TenderLogAdapter adapter;
    private int currentPage = 1;
    private static final String TAG = "TenderLogActivity";

    @Override
    public void init() {
        mActivity = NewTenderLogActivity.this;
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
        adapter = new TenderLogAdapter(mActivity);

        getTenderLog(true);

        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        easyRecyclerView.addItemDecoration(new DividerDecoration(R.color.material_white, 1));
        easyRecyclerView.setAdapter(adapter);

        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPage = 1;
                getTenderLog(true);
            }
        });

        adapter.setMore(R.layout.load_more_layout, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                currentPage++;
                getTenderLog(false);
            }
        });

    }
    private void getTenderLog(final boolean isRefresh) {

        Map<String, String> map = new HashMap<>();
        map.put("borrowId", getIntent().getStringExtra("newBorrowId"));
        map.put("userid", application.userId);
        map.put("currentPage", currentPage + "");
        application.apiService.getInvestDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InvestDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(InvestDetail investDetail) {
                        for (int i = 0; i < investDetail.getTenders().size(); i++) {
                            investDetail.getTenders().get(i);
                        }
                        if (isRefresh) {
                            adapter.clear();
                            adapter.addAll(investDetail.getTenders());
                        } else {
                            adapter.addAll(investDetail.getTenders());
                        }
                    }
                });

        /*Map<String,String> map = new HashMap<>();
        map.put("borrowId",getIntent().getStringExtra("borrowId"));
        map.put("userid",application.userId);
        map.put("currentPage",currentPage+"");
        application.apiService.getInvestDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InvestDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(InvestDetail investDetail) {
                        for (int i=0;i<investDetail.getTenders().size();i++){
                            investDetail.getTenders().get(i);
                        }
                        if (isRefresh){
                            adapter.clear();
                            adapter.addAll(investDetail.getTenders());
                        }else{
                            adapter.addAll(investDetail.getTenders());
                        }
                    }
                });*/


    }



    @Override
    public int getLayoutId() {
        return R.layout.activity_new_tender_log;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }
}
