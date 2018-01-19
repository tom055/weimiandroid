package com.dql.g150t.fyhs.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.Invest;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.DecimalFormat;

/**
 * Created by ST on 2017/7/25.
 */

public class RepaymentViewHolder extends BaseViewHolder<Invest.BorrowsBean>{
    private TextView tv_title,tv_apr,tv_day,tv_tward;
    public RepaymentViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_repayment);
        tv_title = $(R.id.tv_title);
        tv_apr = $(R.id.tv_apr);
        tv_day = $(R.id.tv_day);
        tv_tward = $(R.id.tv_tward);
    }


    @Override
    public void setData(Invest.BorrowsBean data) {
        super.setData(data);
        DecimalFormat df = new DecimalFormat("0.00");
        tv_apr.setText(df.format(data.getApr())+"%");
        tv_title.setText(data.getName()+"");
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

    }
}
