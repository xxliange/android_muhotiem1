package com.example.muhoitem1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumInfoListDataAdapter extends RecyclerView.Adapter<AlbumInfoListDataAdapter.InnerHolder> {
    private List<AlbumInfoListData> mData = new ArrayList<>();
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_info_list_data, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        AlbumInfoListData albumInfoListData = mData.get(position);
        holder.setData(albumInfoListData);
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }else {
            return mData.size();
        }
    }

    public void addData(List<AlbumInfoListData> listData) {
        mData.clear();
        mData.addAll(listData);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_album_info_list_data_name)
        public TextView title;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(AlbumInfoListData albumInfoListData) {
            title.setText(albumInfoListData.getTitle());
        }
    }
}
