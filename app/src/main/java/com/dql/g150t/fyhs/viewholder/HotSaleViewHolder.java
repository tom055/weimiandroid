package com.dql.g150t.fyhs.viewholder;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.Invest;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.DecimalFormat;

/**
 * Created by ST on 2017/7/25.
 */

public class HotSaleViewHolder extends BaseViewHolder<Invest.BorrowsBean>{
    private TextView tv_title,tv_day,tv_money,tv_invest_values,tv_apr,tv_tward;
    private ProgressBar pb;
    private static final String TAG = "HotSaleViewHolder";
    public HotSaleViewHolder(ViewGroup parent) {
        //Log.e(TAG, "HotSaleViewHolder: "+R.layout.item_hot_sale );
        super(parent, R.layout.item_hot_sale);
        tv_title = $(R.id.tv_title);
        tv_day = $(R.id.tv_day);
        tv_money = $(R.id.tv_money);
        tv_invest_values = $(R.id.tv_invest_values);
        tv_apr = $(R.id.tv_apr);
        tv_tward = $(R.id.tv_tward);
        pb = $(R.id.pb);
    }

    @Override
    public void setData(Invest.BorrowsBean data) {
        super.setData(data);
        DecimalFormat df = new DecimalFormat("0.00");
        tv_apr.setText(df.format(data.getApr())+"%");
        tv_title.setText(data.getName()+"");
        tv_invest_values.setText(data.getB_t_type_name());
        tv_money.setText((int) (data.getAccount() - data.getAccount_yes())+"");
        if (data.getIs_day()==1){
            tv_day.setText(data.getTime_limit()+"天");
        }else{
            tv_day.setText(data.getTime_limit()+"个月");
        }
        if (data.getFunds() == 0 && data.getPart_account() == 0) {
            tv_tward.setVisibility(View.GONE);
        } else if (data.getFunds() == 0 /*| investDetail.getBorrow().getPart_account().equals("0")*/) {
            tv_tward.setVisibility(View.VISIBLE);
            tv_tward.setText("已减 "+data.getPart_account() + "元");
        } else if (data.getPart_account() == 0/* | investDetail.getBorrow().getFunds().equals("0")*/) {
            tv_tward.setVisibility(View.VISIBLE);
            tv_tward.setText("已加 "+data.getFunds() + "%");

        }
        Log.e(TAG, "setData: "+(data.getAccount_yes() / data.getAccount()*100));
        pb.setProgress((int) (data.getAccount_yes() / data.getAccount()*100));
        ObjectAnimator animator = ObjectAnimator.ofInt(pb, "progress", 0, (int) (data.getAccount_yes() / data.getAccount()*100));
        animator.setDuration(3000);
        animator.start();

    }
}
