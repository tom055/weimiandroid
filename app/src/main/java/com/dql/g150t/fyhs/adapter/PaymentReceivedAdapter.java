package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.model.Collection;
import com.dql.g150t.fyhs.viewholder.PaymentReceivedViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/22.
 */

public class PaymentReceivedAdapter extends RecyclerArrayAdapter<Collection.CollectionsBean> {
    public PaymentReceivedAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PaymentReceivedViewHolder(parent);
    }
}
