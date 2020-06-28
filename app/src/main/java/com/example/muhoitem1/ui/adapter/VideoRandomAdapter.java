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
import com.example.muhoitem1.model.domain.VideoData.TeachVideoRandomData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoRandomAdapter extends RecyclerView.Adapter<VideoRandomAdapter.InnerHolder> {
    private List<TeachVideoRandomData> mData = new ArrayList<>();
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two_lines, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        TeachVideoRandomData teachVideoRandomData = mData.get(position);
        holder.setData(teachVideoRandomData);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<TeachVideoRandomData> data) {
        mData.clear();
        mData.addAll(data);
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

        public void setData(TeachVideoRandomData teachVideoRandomData) {
            title.setText(teachVideoRandomData.getName());
            Glide.with(itemView.getContext()).load(teachVideoRandomData.getIcon()).into(thumb);

        }
    }
}
