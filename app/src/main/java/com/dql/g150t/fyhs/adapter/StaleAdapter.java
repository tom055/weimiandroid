package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.model.RedBean;
import com.dql.g150t.fyhs.viewholder.StaleViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/26.
 */

public class StaleAdapter extends RecyclerArrayAdapter<RedBean>{
    public StaleAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new StaleViewHolder(parent);
    }
}
