package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.adapter.MoreRepaymentAdapter;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.Invest;
import com.dql.g150t.fyhs.model.ToRealname;
import com.dql.g150t.fyhs.utils.ToastUtil;
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

public class MoreRepaymentActivity extends BaseActivity {
    private static boolean isRealName = false ;//是否实名认证的标志
    private static boolean isBindBankCard = false ;//是否绑定银行卡的标志

    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.easy_recycler_view)
    EasyRecyclerView easyRecyclerView;
    private Activity mActivity;
    private MyApplication application;
    private MoreRepaymentAdapter adapter;

    private int currentPage = 1 ;
    private static final String TAG = "MoneyRecordDetailActivity";
    @Override
    public void init() {
        mActivity = MoreRepaymentActivity.this;
        application = (MyApplication) getApplication();
        isReal();
        isBind();
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        adapter = new MoreRepaymentAdapter(mActivity) ;

        getRepayment(true);

        easyRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        easyRecyclerView.addItemDecoration(new DividerDecoration(R.color.material_white, 1));
        easyRecyclerView.setAdapter(adapter);

        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPage = 1 ;
                getRepayment(true);
            }
        });

        adapter.setMore(R.layout.load_none, new RecyclerArrayAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                currentPage ++ ;
                getRepayment(false);
            }
        }) ;

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position) {
                if (!application.isLogin) {
                    startActivity(new Intent(mActivity, LoginActivity.class));
                } else {
                    if (!isRealName){
                        Log.e(TAG, "onViewClicked: "+isRealName );
                        startActivity(new Intent(mActivity, RealnameActivity.class));
                        ToastUtil.showToast(mActivity,"您未进行实名认证");
                    }else if(!isBindBankCard){
                        Log.e(TAG, "onViewClicked: "+isBindBankCard );
                        startActivity(new Intent(mActivity, BindCardActivity.class));
                        ToastUtil.showToast(mActivity,"您未绑定银行卡");
                    }else {
                        Map<String, String> map = new HashMap<>();
                        map.put("status", "6");
                        map.put("currentPage", currentPage + "");
                        application.apiService.getIvest(map)
                                .subscribeOn(Schedulers.io())
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

    }

    //是否实名认证
    private void isReal(){
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
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
                        Log.e("sss", "onNext: "+realNameContent );
                        if (!toRealname.getRealName().equals("")&&realNameContent==1){
                            isRealName = true;
                        } else{
                            isRealName = false;
                        }
                    }
                });
    }
    //是否绑定银行卡
    private void isBind(){
        Map<String,String> map = new HashMap<>();
        map.put("userid",application.userId);
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
                        if (bankCard.getStatus().equals("1")){
                            isBindBankCard = true;
                        }else {
                            isBindBankCard = false;
                        }
                    }
                });
    }
    private void getRepayment(final boolean isRefresh){
        Map<String,String> map = new HashMap<>();
        map.put("status","6");
        map.put("currentPage",currentPage+"");
        application.apiService.getIvest(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Invest>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onNext(Invest invest) {
                        if (isRefresh){
                            adapter.clear();
                            adapter.addAll(invest.getBorrows());
                        }else{
                            adapter.addAll(invest.getBorrows());
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_more_repayment;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


}
