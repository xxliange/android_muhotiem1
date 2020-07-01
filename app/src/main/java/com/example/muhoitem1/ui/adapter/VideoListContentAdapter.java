package com.example.muhoitem1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.muhoitem1.R;
import com.example.muhoitem1.model.domain.VideoData.VideoListData;
import com.example.muhoitem1.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoListContentAdapter extends RecyclerView.Adapter<VideoListContentAdapter.InnerHolder> {
    private List<VideoListData> mData = new ArrayList<>();
    private int mType = 0;
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two_lines, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        VideoListData videoListData = mData.get(position);
        holder.setData(videoListData);
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }else{
            return mData.size();
        }
    }

    public void setData(List<VideoListData> listData, Integer type) {
        mType = type;
        mData.clear();
        mData.addAll(listData);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_twoLine_title)
        public TextView title;
        @BindView(R.id.item_twoLine_thumb)
        public ImageView thumb;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(VideoListData videoListData) {
                LogUtils.d(this, "mType" + mType);
            if (mType == 3) {
                title.setText(videoListData.getTitle());
            }else{
                title.setText(videoListData.getTitle() == "" ? videoListData.getTitle() : videoListData.getName());
            }
            Glide.with(itemView.getContext()).load(videoListData.getThumb()).placeholder(R.drawable.placeholder).into(thumb);
        }
    }
}
