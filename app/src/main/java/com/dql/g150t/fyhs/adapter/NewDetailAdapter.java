package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.model.NewDetail;
import com.dql.g150t.fyhs.viewholder.NewDetailViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/24.
 */

public class NewDetailAdapter extends RecyclerArrayAdapter<NewDetail.ListBean>{
    public NewDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewDetailViewHolder(parent);
    }
}
