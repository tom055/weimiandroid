package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.MoreNewDetailAdapter;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.PlatformAnnouncement;
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

public class MoreNewDetailActivity extends BaseActivity {

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private Activity mActivity;
    private MyApplication application;
    private MoreNewDetailAdapter adapter;
    private int currentPage = 1 ;
    private static final String TAG = "MoreNewDetailActivity";

    @Override
    public void init() {
        mActivity = MoreNewDetailActivity.this;
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
        adapter = new MoreNewDetailAdapter(mActivity) ;

        getMoreNewDetail(true);

        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        easyRecyclerView.addItemDecoration(new DividerDecoration(R.color.material_white, 1));
        easyRecyclerView.setAdapter(adapter);

        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPage = 1 ;
                getMoreNewDetail(true);
            }
        });

        adapter.setMore(R.layout.load_more_layout, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                currentPage ++ ;
                getMoreNewDetail(false);
            }
        }) ;
        adapter.setNoMore(R.layout.no_more_layout);
        adapter.setError(R.layout.error_layout);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent = new Intent(mActivity, PlatformAnnouncementDetailActivity.class);
                intent.putExtra("id", adapter.getItem(position).getId() + "");
                startActivity(intent);

            }
        });
    }
    private void getMoreNewDetail(final boolean isRefresh){
        Map<String,String> map = new HashMap<>();
        map.put("currentPage",currentPage+"");
        application.apiService.getPlatformAnnouncement(map)
                .subscribeOn(Schedulers.io())
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
                            platformAnnouncement.getAnnouncement().get(i);
                        }
                        if (isRefresh) {
                            adapter.clear();
                            adapter.addAll(platformAnnouncement.getAnnouncement());
                        } else {
                            adapter.addAll(platformAnnouncement.getAnnouncement());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }




    @Override
    public int getLayoutId() {
        return R.layout.activity_more_new_detail;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


}
