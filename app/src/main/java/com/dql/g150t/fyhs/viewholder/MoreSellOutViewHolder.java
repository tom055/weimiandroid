package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.Invest;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by ST on 2017/7/26.
 */

public class MoreSellOutViewHolder extends BaseViewHolder<Invest.BorrowsBean>{
    private TextView tv_title,tv_apr,tv_day;
    public MoreSellOutViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_sell_out);
        tv_title = $(R.id.tv_title);
        tv_apr = $(R.id.tv_apr);
        tv_day = $(R.id.tv_day);
    }

    @Override
    public void setData(Invest.BorrowsBean data) {
        super.setData(data);
        tv_apr.setText(data.getApr()+"%");
        tv_title.setText(data.getName()+"");
        if (data.getIs_day()==1){
            tv_day.setText(data.getTime_limit()+"天");
        }else{
            tv_day.setText(data.getTime_limit()+"个月");
        }
    }
}
