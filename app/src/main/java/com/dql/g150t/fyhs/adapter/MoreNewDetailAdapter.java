package com.dql.g150t.fyhs.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dql.g150t.fyhs.model.PlatformAnnouncement;
import com.dql.g150t.fyhs.viewholder.MoreNewDetailViewHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by ST on 2017/7/25.
 */

public class MoreNewDetailAdapter extends RecyclerArrayAdapter<PlatformAnnouncement.AnnouncementBean>{
    public MoreNewDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoreNewDetailViewHolder(parent);
    }
}
