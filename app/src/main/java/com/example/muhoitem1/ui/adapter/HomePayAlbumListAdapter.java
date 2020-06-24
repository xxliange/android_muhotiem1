package com.example.muhoitem1.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseApplication;
import com.example.muhoitem1.model.domain.HomeData.HomePayAlbumListData;
import com.example.muhoitem1.ui.activity.VideoActivity.TeachVideoActivity;
import com.example.muhoitem1.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePayAlbumListAdapter extends RecyclerView.Adapter<HomePayAlbumListAdapter.InnerHolder> {
    private List<HomePayAlbumListData.DataBean> mData = new ArrayList<>();
    private OnHomePayAlbumListItemClickListener mHonePayAlbumListItemClickListener = null;
    Context context;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two_lines, parent, false);
        return new InnerHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        HomePayAlbumListData.DataBean dataBean = mData.get(position);
        holder.setData(dataBean);

        holder.itemView.setOnClickListener(v -> {
            if (mHonePayAlbumListItemClickListener!=null) {
//                LogUtils.d(HomePayAlbumListAdapter.this,"data --> " + dataBean);
                mHonePayAlbumListItemClickListener.onAlbumItemClick(dataBean);
            }

        });

    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        } else if (mData.size() >= 4) {
            return 4;
        } else {
            return mData.size();
        }
    }

    public void setData(List<HomePayAlbumListData.DataBean> payAlbumListData) {
        mData.clear();
        mData.addAll(payAlbumListData);
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

        public void setData(HomePayAlbumListData.DataBean dataBean) {
            title.setText(dataBean.getName());
            Glide.with(itemView.getContext()).load(dataBean.getThumb()).into(thumb);
        }
    }

    public void setOnHomePayAlbumListItemClickListener(OnHomePayAlbumListItemClickListener listener){
        this.mHonePayAlbumListItemClickListener = listener;
    }

    public interface OnHomePayAlbumListItemClickListener {
        void onAlbumItemClick(HomePayAlbumListData.DataBean DataBean);
    }

    public interface PayAlbumItem{
        String getName();
        String getSid();
    }
}
