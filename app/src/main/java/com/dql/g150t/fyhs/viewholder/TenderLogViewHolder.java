package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.InvestDetail;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ST on 2017/7/25.
 */

public class TenderLogViewHolder extends BaseViewHolder<InvestDetail.TendersBean> {
    private TextView tv_username, tv_money, tv_time, tv_status;
    private Date date;

    public TenderLogViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_tender_log);
        tv_username = $(R.id.tv_username);
        tv_money = $(R.id.tv_money);
        tv_time = $(R.id.tv_time);
        tv_status = $(R.id.tv_status);
    }

    @Override
    public void setData(InvestDetail.TendersBean data) {
        super.setData(data);
        tv_username.setText(data.getMobile().substring(0,3)+"****"+data.getMobile().substring(7,11));
        tv_money.setText(data.getMoney() + "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(Long.valueOf(data.getAddtime()) * 1000);
        tv_time.setText(sdf.format(date));
       // if (data.getAccount() == data.getMoney()) {
            tv_status.setText("全部通过");
       // } else {
      //      tv_status.setText("部分通过");
       // }


    }
}
