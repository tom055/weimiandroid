package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.InvestRecord;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.DecimalFormat;

/**
 * Created by ST on 2017/7/22.
 */

public class InvestRecordViewHolder extends BaseViewHolder<InvestRecord.BorrowsBean> {
    private TextView tv_invest_title, tv_time_limit_day, tv_invest_money, tv_collected_money, tv_apr;

    public InvestRecordViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_invest_record);
        tv_invest_title = $(R.id.tv_invest_title);//标的名字
        tv_time_limit_day = $(R.id.tv_time_limit_day);//标的时间
        tv_invest_money = $(R.id.tv_invest_money);//标的总金额
        tv_collected_money = $(R.id.tv_collected_money);//待收利息
        tv_apr = $(R.id.tv_apr);//年华利率
    }

    @Override
    public void setData(InvestRecord.BorrowsBean data) {
        super.setData(data);
        tv_invest_title.setText(data.getB_name()+"");
        DecimalFormat df = new DecimalFormat("0");
        String leftByDays = data.getLeft_days().toString();
        if ("未满标".equals(leftByDays)){
            tv_time_limit_day.setText("未满标");
        }else {
            long days= (long) Double.parseDouble(leftByDays);
            if (0==days) {
                tv_time_limit_day.setText("今日到期");
            }else if(days>0){
                tv_time_limit_day.setText(df.format(data.getLeft_days()) + "天后到期");
            }else{
                tv_time_limit_day.setText("已逾期"+Math.abs(days)+"天");
            }
        }
        tv_invest_money.setText(data.getAccount()+"");
        tv_apr.setText(data.getB_apr() + "%");
        tv_collected_money.setText(data.getInterest()+"");
    }
}
