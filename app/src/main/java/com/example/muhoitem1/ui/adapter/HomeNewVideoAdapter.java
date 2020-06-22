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
import com.example.muhoitem1.model.domain.HomeData.HomeNewVideoData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeNewVideoAdapter extends RecyclerView.Adapter<HomeNewVideoAdapter.InnerHolder> {
    private List<HomeNewVideoData.DataBean> mData = new ArrayList<>();
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two_lines, parent, false);
        return  new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        HomeNewVideoData.DataBean dataBean = mData.get(position);
        holder.setData(dataBean);
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }else if(mData.size() >= 4){
            return 4;
        }else {
            return mData.size();
        }
    }

    public void setData(List<HomeNewVideoData.DataBean> newVideoData) {
        mData.clear();
        mData.addAll(newVideoData);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_twoLine_title)
        public TextView name;
        @BindView(R.id.item_twoLine_thumb)
        public ImageView thumb;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(HomeNewVideoData.DataBean dataBean) {
            name.setText(dataBean.getName());
            Glide.with(itemView.getContext()).load(dataBean.getThumb()).into(thumb);
        }
    }
}
