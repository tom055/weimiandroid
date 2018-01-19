package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;


import com.dql.g150t.fyhs.model.RedBean;
import com.dql.g150t.fyhs.viewholder.TobeUseViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/24.
 */

public class TobeUseAdapter extends RecyclerArrayAdapter<RedBean>{
    public TobeUseAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new TobeUseViewHolder(parent);
    }


}
