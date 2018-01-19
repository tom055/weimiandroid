package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.viewholder.MoneyRecordDetailViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by G150T on 2017/7/21.
 */

public class MoneyRecordDetailAdapter extends RecyclerArrayAdapter {
    public MoneyRecordDetailAdapter(Context context) {
        super(context);
    }
    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoneyRecordDetailViewHolder(parent);
    }

}
