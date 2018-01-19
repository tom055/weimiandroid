package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.TobeUseAdapter;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.DiscountCoupon;
import com.dql.g150t.fyhs.model.RedBean;
import com.dql.g150t.fyhs.view.TopBar;
import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SelectRedPacketActivity extends BaseActivity {


    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.tv_red_type)
    TextView tvRedType;
    @BindView(R.id.ll_no_select_red)
    LinearLayout llNoSelectRed;
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private Activity mActivity;
    private MyApplication application;
    private TobeUseAdapter adapter;
    //当前页数
    private int pageNum = 1;
    //每一页显示的行数
    private int epage = 10;
    private String mParam1;
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "TobeUseFragment";

    @Override
    public void init() {
        mActivity = SelectRedPacketActivity.this;
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
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new TobeUseAdapter(mActivity);
        easyRecyclerView.setAdapter(adapter);
        getTobeUse(false);
        easyRecyclerView.setErrorView(R.layout.error_layout);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getTobeUse(true);
            }
        });
        adapter.setMore(R.layout.load_none, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getTobeUse(false);
            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(mActivity, InvestActivity.class);
                intent.putExtra("red", new Gson().toJson(adapter.getItem(position)));
                intent.putExtra("redname",adapter.getItem(position).getLowest_account());
               // intent.putExtra("redname",new Gson().toJson(adapter.getItem(position).getRed_title()));
               // Log.e(TAG, "onItemClick: "+new Gson().toJson(adapter.getItem(position)));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void getTobeUse(final boolean isRefresh) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        map.put("status", "0");
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
    public int getLayoutId() {
        return R.layout.activity_select_red_packet;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }




    @OnClick( R.id.ll_no_select_red)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_no_select_red:
                Intent intent = new Intent(mActivity , InvestTwoActivity.class) ;
                intent.putExtra("red" , "") ;
                setResult(RESULT_OK , intent);
                finish();
                break;
        }
    }
}
