package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.Collection;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by ST on 2017/7/22.
 */

public class PaymentReceivedViewHolder extends BaseViewHolder<Collection.CollectionsBean>{
    private TextView tv_invest_title,tv_invest_money, tv_collected_money, tv_apr;
    public PaymentReceivedViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_payment_received);
        tv_invest_title = $(R.id.tv_invest_title);//标的名字
        tv_invest_money = $(R.id.tv_invest_money);//投资金额
        tv_collected_money = $(R.id.tv_collected_money);//已收利息
        tv_apr = $(R.id.tv_apr);//年华利率
    }

    @Override
    public void setData(Collection.CollectionsBean data) {
        super.setData(data);
        tv_invest_title.setText(data.getB_name()+"");
        tv_invest_money.setText(data.getBt_account()+"");
        tv_apr.setText(data.getB_apr() + "%");
        tv_collected_money.setText(data.getInterest()+"");
    }
}
