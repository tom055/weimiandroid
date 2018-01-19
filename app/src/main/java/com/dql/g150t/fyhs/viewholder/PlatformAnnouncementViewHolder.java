package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.PlatformAnnouncement;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ST on 2017/7/24.
 */

public class PlatformAnnouncementViewHolder extends BaseViewHolder<PlatformAnnouncement.AnnouncementBean>{
    private TextView tv_name,tv_day/*,tv_content*/;
    public PlatformAnnouncementViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_platform_announcement);
        tv_name = $(R.id.tv_name);
        tv_day = $(R.id.tv_day);
        //tv_content = $(R.id.tv_content);
    }

    @Override
    public void setData(PlatformAnnouncement.AnnouncementBean data) {
        super.setData(data);
        tv_name.setText(data.getTitle());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(Long.valueOf(data.getIssueDate()) * 1000);
        tv_day.setText(sdf.format(date));
        //tv_content.setText(data.getContent());
    }
}
