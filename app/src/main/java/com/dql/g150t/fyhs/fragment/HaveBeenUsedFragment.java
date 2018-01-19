package com.dql.g150t.fyhs.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.HaveBeenUsedAdapter;
import com.dql.g150t.fyhs.base.BaseFragment;
import com.dql.g150t.fyhs.model.DiscountCoupon;
import com.dql.g150t.fyhs.model.RedBean;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 已使用
 */
public class HaveBeenUsedFragment extends BaseFragment {
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    Unbinder unbinder;
    private Activity mActivity;
    private MyApplication application;
    private HaveBeenUsedAdapter adapter;
    //当前页数
    private int pageNum = 1;
    //每一页显示的行数
    private int epage = 10;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "TobeUseFragment";

    public HaveBeenUsedFragment() {

    }

    public static HaveBeenUsedFragment newInstance(String param1) {
        HaveBeenUsedFragment fragment = new HaveBeenUsedFragment();
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
        adapter = new HaveBeenUsedAdapter(mActivity);
        easyRecyclerView.setAdapter(adapter);
        getHaveBeenUse(false);
        easyRecyclerView.setErrorView(R.layout.error_layout);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getHaveBeenUse(true);
            }
        });
        adapter.setMore(R.layout.load_none, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getHaveBeenUse(false);
            }
        });
    }

    private void getHaveBeenUse(final boolean isRefresh) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        map.put("status", "1");
        map.put("currentPage", pageNum + "");
        application.apiService.getDiscountCoupon(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DiscountCoupon>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString() );
                    }

                    @Override
                    public void onNext(DiscountCoupon discountCoupon) {
                        if (isRefresh) {
                            adapter.clear();
                        }
                        setData(discountCoupon);
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    private void setData(DiscountCoupon discountCoupon) {
        List<DiscountCoupon.AbleRedsBean> ableRedsBeanList = discountCoupon.getAbleReds();//满减红包
        List<DiscountCoupon.AddRedsBean> addRedsBeanList = discountCoupon.getAddReds();//加息券
        List<DiscountCoupon.RedListBean> redListBeanList = discountCoupon.getRedList();//红包列表
        for (int i = 0; i < redListBeanList.size(); i++) {
            DiscountCoupon.RedListBean redListBean = redListBeanList.get(i);
            switch (redListBean.getRed_type_id()) {
                case 1://加息券
                    for (int j = 0; j < addRedsBeanList.size(); j++) {
                        DiscountCoupon.AddRedsBean addRedsBean = addRedsBeanList.get(j);
                        if (redListBean.getRed_id() == addRedsBean.getId()) {
                            RedBean redBean = new RedBean(redListBean.getId(),
                                    redListBean.getRed_id(),
                                    redListBean.getRed_type_id(),
                                    addRedsBean.getAdd_percent() + "%",
                                    "产品期限≥"+addRedsBean.getDay_limit()+"天",
                                    0,
                                    redListBean.getStart_date(),
                                    redListBean.getEnd_date(),
                                    redListBean.getStatus());

                            adapter.add(redBean);
                            break;
                        }
                    }
                    break;
                case 2://满减券
                    for (int k = 0; k < ableRedsBeanList.size(); k++) {
                        DiscountCoupon.AbleRedsBean ableRedsBean = ableRedsBeanList.get(k);
                        if (redListBean.getRed_id() == ableRedsBean.getId()) {
                            RedBean redBean = new RedBean(redListBean.getId(),
                                    redListBean.getRed_id(),
                                    redListBean.getRed_type_id(),
                                    ableRedsBean.getRed_account() + "元",
                                    "产品期限≥"+ableRedsBean.getDay_limit()+"天",
                                    ableRedsBean.getLowest_account(),
                                    redListBean.getStart_date(),
                                    redListBean.getEnd_date(),
                                    redListBean.getStatus());
                            adapter.add(redBean);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    @Override
    public int getFragmentId() {
        return R.layout.fragment_have_been_used;
    }

    @Override
    public Object bindFragment() {
        return this;
    }


}
