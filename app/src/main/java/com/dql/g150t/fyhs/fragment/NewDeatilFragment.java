package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.activity.LoginActivity;
import com.dql.g150t.fyhs.activity.NewDetailActivity;
import com.dql.g150t.fyhs.adapter.NewDetailAdapter;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.NewDetail;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 热门活动页面
 */
public class NewDeatilFragment extends BaseFragment {
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private Activity mActivity;
    private MyApplication application;
    private NewDetailAdapter adapter;
    //当前页数
    private int pageNum = 1;
    //每一页显示的行数
    private int epage = 10;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "NewDeatilFragment";

    public NewDeatilFragment() {
    }

    public static NewDeatilFragment newInstance(String param1) {
        NewDeatilFragment fragment = new NewDeatilFragment();
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
        adapter = new NewDetailAdapter(mActivity);
        easyRecyclerView.setAdapter(adapter);
        getNewDetail(false);
        easyRecyclerView.setErrorView(R.layout.error_layout);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getNewDetail(true);
            }
        });
        adapter.setMore(R.layout.load_more_layout, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getNewDetail(false);
            }
        });
        adapter.setNoMore(R.layout.no_more_layout);
        adapter.setError(R.layout.error_layout);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {

                   /* if (adapter.getItem(position).getId()==23){
                        Intent intent1 = new Intent(mActivity, ActivityById1Activity.class);
                        intent1.putExtra("url1", Constants.BASE_URL+"wap/webapp/app/newPacks.jsp");
                        intent1.putExtra("title",adapter.getItem(position).getActivity_name());
                        startActivity(intent1);
                    }else if (adapter.getItem(position).getId()==24){
                        Intent intent2 = new Intent(mActivity, ActivityById2Activity.class);
                        intent2.putExtra("url2", Constants.BASE_URL+"wap/webapp/app/inviteRegister.jsp");
                        intent2.putExtra("title",adapter.getItem(position).getActivity_name());
                        startActivity(intent2);
                    }else if (adapter.getItem(position).getId()==25){
                        Intent intent3 = new Intent(mActivity, ActivityById3Activity.class);
                        intent3.putExtra("url3", Constants.BASE_URL+"front_Counter/AccountUserCount.dql?device=app");
                        intent3.putExtra("title",adapter.getItem(position).getActivity_name());
                        startActivity(intent3);
                    }else{*/
                        Intent intent4 = new Intent(mActivity, NewDetailActivity.class);
                        intent4.putExtra("id", adapter.getItem(position).getId()+"");
                        intent4.putExtra("userid",application.userId);
                        intent4.putExtra("title",adapter.getItem(position).getActivity_name());
                        startActivity(intent4);
                    //}

                }
            }
        });
    }

    private void getNewDetail(final boolean isRefresh) {
        Map<String, String> map = new HashMap<>();
        map.put("currentPage", pageNum+"");
        application.apiService.getNewDetail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewDetail newDetail) {
                        for (int i = 0; i < newDetail.getList().size(); i++) {
                            newDetail.getList().get(i);
                        }
                        if (isRefresh) {
                            adapter.clear();
                            adapter.addAll(newDetail.getList());
                        } else {
                            adapter.addAll(newDetail.getList());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }


    @Override
    public int getFragmentId() {
        return R.layout.fragment_new_deatil;
    }

    @Override
    public Object bindFragment() {
        return this;
    }

}
