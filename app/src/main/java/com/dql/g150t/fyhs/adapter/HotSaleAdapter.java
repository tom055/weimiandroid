package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.model.Invest;
import com.dql.g150t.fyhs.viewholder.HotSaleViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/25.
 */

public class HotSaleAdapter extends RecyclerArrayAdapter<Invest.BorrowsBean>{
    public HotSaleAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotSaleViewHolder(parent);
    }
}
