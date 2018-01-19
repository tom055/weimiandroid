package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.model.InvestRecord;
import com.dql.g150t.fyhs.viewholder.InvestRecordViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/22.
 */

public class InvestRecordAdapter extends RecyclerArrayAdapter<InvestRecord.BorrowsBean> {
    public InvestRecordAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent ,int viewType) {
        return new InvestRecordViewHolder(parent);
    }
}
