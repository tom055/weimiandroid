package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.activity.PlatformAnnouncementDetailActivity;
import com.dql.g150t.fyhs.adapter.PlatformAnnouncementAdapter;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.PlatformAnnouncement;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 平台公告
 */
public class PlatformAnnouncementFragment extends BaseFragment {
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private Activity mActivity;
    private MyApplication application;
    private PlatformAnnouncementAdapter adapter;
    //当前页数
    private int pageNum = 1;
    //每一页显示的行数
    private int epage = 10;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "InvestRecordFragment";

    public PlatformAnnouncementFragment() {
    }

    public static PlatformAnnouncementFragment newInstance(String param1) {
        PlatformAnnouncementFragment fragment = new PlatformAnnouncementFragment();
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

    @Override
    public void init() {
        mActivity = getActivity();
        application = (MyApplication) mActivity.getApplication();
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new PlatformAnnouncementAdapter(mActivity);
        easyRecyclerView.setAdapter(adapter);
        getPlatformAnnouncement(false);
        easyRecyclerView.setErrorView(R.layout.error_layout);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getPlatformAnnouncement(true);
            }
        });
        adapter.setMore(R.layout.load_more_layout, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getPlatformAnnouncement(false);
            }
        });
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

    private void getPlatformAnnouncement(final boolean isRefresh) {
        Map<String, String> map = new HashMap<>();
        map.put("currentPage", pageNum + "");
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
    public int getFragmentId() {
        return R.layout.fragment_platform_announcement;
    }

    @Override
    public Object bindFragment() {
        return this;
    }

}
