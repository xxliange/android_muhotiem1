package com.example.muhoitem1.ui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.muhoitem1.R;
import com.example.muhoitem1.model.domain.HomeData.StarListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeStarListAdapter extends RecyclerView.Adapter<HomeStarListAdapter.InnerHolder> {
    private List<StarListData.DataBean> mData = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        StarListData.DataBean dataBean = mData.get(position);
        holder.setData(dataBean);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<StarListData.DataBean> starListData) {
        mData.clear();
        mData.addAll(starListData);
        notifyDataSetChanged();

    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_starList_thumb)
        public ImageView imageView;
        @BindView(R.id.home_starList_name)
        public TextView name;
        @BindView(R.id.home_starList_symbol)
        public ImageView symbol;
        @BindView(R.id.home_starList_back)
        public RelativeLayout thumbBack;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(StarListData.DataBean dataBean) {
            Glide.with(itemView.getContext())
                    .load(dataBean.getAvatar())
                    .into(imageView);
            name.setText(dataBean.getName());
            Glide.with(itemView.getContext()).applyDefaultRequestOptions(new RequestOptions()).load(dataBean.getSymbolpic()).into(symbol);
            thumbBack.setBackgroundColor(Color.parseColor(dataBean.getTheme()));


        }
    }
}
