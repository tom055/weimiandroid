package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.RedBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by ST on 2017/7/26.
 */

public class StaleViewHolder extends BaseViewHolder<RedBean> {
    private TextView tv_apr, tv_type, tv_day, tv_money, tv_limit_day;

    public StaleViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_stale);
        tv_apr = $(R.id.tv_apr);
        tv_type = $(R.id.tv_type);
        tv_day = $(R.id.tv_day);
        tv_money = $(R.id.tv_money);
        tv_limit_day = $(R.id.tv_limit_day);
    }

    @Override
    public void setData(RedBean data) {
        super.setData(data);
        switch (data.getRed_type_id()) {
            case 1://加息券
                //ll_background.setBackgroundResource(R.mipmap.icon_blue);
                tv_type.setText("加息券");
                tv_money.setText("投资金额: ≥100元");
                break;
            case 2://满减
                //ll_background.setBackgroundResource(R.mipmap.icon_org);
                tv_type.setText("抵扣券");
                tv_money.setText("投资金额: ≥"+data.getLowest_account()+"元");
                break;
        }
        tv_apr.setText(data.getRed_title());
        tv_day.setText(data.getDay_limit());
        tv_limit_day.setText("有效期: " + data.getStart_date() + "-" + data.getEnd_date());
        /*String s1=data.getEnd_date();
        String s2=data.getStart_date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=new GregorianCalendar();
        try {
            Date d1=df.parse(s1);
            Date d2=df.parse(s2);
            tv_day.setText("产品期限≥"+(int) (+(d1.getTime()-d2.getTime())/(60*60*1000*24))+"天");
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }
}
