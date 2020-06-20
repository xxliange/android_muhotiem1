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
import com.example.muhoitem1.model.domain.HotListData;
import com.example.muhoitem1.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotListContentAdapter extends RecyclerView.Adapter<HotListContentAdapter.InnerHolder> {
    private List<HotListData.DataBean> mData = new ArrayList<>();
    private OnListenerItemClickListener mItemClickListener = null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hot_list_content, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        HotListData.DataBean dataBean = mData.get(position);
        //设置数据
        holder.setData(dataBean);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    HotListData.DataBean item = mData.get(position);
                    mItemClickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<HotListData.DataBean> contents) {
        mData.clear();
        mData.addAll(contents);
        notifyDataSetChanged();
    }

    public void addData(List<HotListData.DataBean> contents) {
        //添加之前拿到之前的size
        int olderSize = mData.size();
        mData.addAll(contents);
        notifyItemRangeChanged(olderSize, contents.size());
    }


    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hot_list_thumb)
        public ImageView imageView;
        @BindView(R.id.hot_list_item_title)
        public TextView title;
        @BindView(R.id.hot_list_item_views)
        public TextView views;
        @BindView(R.id.hot_list_item_time)
        public TextView time;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(HotListData.DataBean dataBean) {
            title.setText(dataBean.getTitle());
            Glide.with(itemView.getContext()).load(dataBean.getThumb2()).into(imageView);
            views.setText(String.format(itemView.getContext().getString(R.string.text_hot_list_item_views), dataBean.getView()));
            time.setText(dataBean.getUpdate_time());
        }
    }

    public void setOnListenerItemClickListener(OnListenerItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public interface OnListenerItemClickListener {
        void onItemClick(HotListData.DataBean item);
    }
}
