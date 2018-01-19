package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dql.g150t.fyhs.Constants;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.NewDetail;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ST on 2017/7/24.
 */

public class NewDetailViewHolder extends BaseViewHolder<NewDetail.ListBean>{
    private TextView tv_name,tv_day;
    private ImageView iv_img;
    public NewDetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_new_detail);
        tv_day = $(R.id.tv_day);
        tv_name = $(R.id.tv_name);
        iv_img = $(R.id.iv_img);

    }

    @Override
    public void setData(NewDetail.ListBean data) {
        super.setData(data);
        tv_name.setText(data.getActivity_name()+"");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(Long.valueOf(data.getAdd_time()) * 1000);
        tv_day.setText(sdf.format(date));
        String img = Constants.BASE_URL_IMG+data.getImg();
        Glide.with(getContext()).load(img).into(iv_img);
    }
}
