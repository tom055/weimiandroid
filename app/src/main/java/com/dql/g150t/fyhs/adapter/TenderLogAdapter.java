package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.model.InvestDetail;
import com.dql.g150t.fyhs.viewholder.TenderLogViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/25.
 */

public class TenderLogAdapter extends RecyclerArrayAdapter<InvestDetail.TendersBean>{
    public TenderLogAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TenderLogViewHolder(parent);
    }
}
