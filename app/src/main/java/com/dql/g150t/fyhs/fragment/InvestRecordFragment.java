package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.InvestRecordAdapter;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.InvestRecord;
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
 * 持有中
 */
public class InvestRecordFragment extends BaseFragment {
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    Unbinder unbinder;
    private Activity mActivity;
    private MyApplication application;
    private InvestRecordAdapter adapter;
    //当前页数
    private int pageNum = 1;
    //每一页显示的行数
    private int epage = 10;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "InvestRecordFragment";

    public InvestRecordFragment() {
    }

    public static InvestRecordFragment newInstance(String param1) {
        InvestRecordFragment fragment = new InvestRecordFragment();
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
        adapter = new InvestRecordAdapter(mActivity);
        easyRecyclerView.setAdapter(adapter);
        getInvestRecord(false);
        easyRecyclerView.setErrorView(R.layout.error_layout);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getInvestRecord(true);
            }
        });
        adapter.setMore(R.layout.load_none, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getInvestRecord(false);
            }
        });
    }

    private void getInvestRecord(final boolean isRefresh){
        Map<String,String > map = new HashMap<>();
        map.put("userid",application.userId);
        map.put("type","tender");
        map.put("currentPage",pageNum+"");
        application.apiService.getInvestRecord(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InvestRecord>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString() );
                    }

                    @Override
                    public void onNext(InvestRecord investRecord) {
                        for (int i = 0; i < investRecord.getBorrows().size(); i++) {
                            investRecord.getBorrows().get(i);
                        }
                        if (isRefresh) {
                            adapter.clear();
                            /*for (int i= 0 ;i<investRecord.getBorrows().size();i++){
                                if (investRecord.getBorrows().get(i).getStatus()==-1){
                                    adapter.add(investRecord.getBorrows().get(i));
                                }
                            }*/
                            adapter.addAll(investRecord.getBorrows());
                        } else {
                             /*for (int i= 0 ;i<investRecord.getBorrows().size();i++){
                                if (investRecord.getBorrows().get(i).getStatus()==-1){
                                    adapter.add(investRecord.getBorrows().get(i));
                                }
                            }*/
                            adapter.addAll(investRecord.getBorrows());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_invest_record;
    }

    @Override
    public Object bindFragment() {
        return this;
    }



}
