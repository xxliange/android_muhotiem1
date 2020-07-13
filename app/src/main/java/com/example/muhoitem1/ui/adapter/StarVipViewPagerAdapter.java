package com.example.muhoitem1.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bumptech.glide.Glide;
import com.example.muhoitem1.R;
import com.example.muhoitem1.model.domain.HomeData.HomePayAlbumListData;
import com.example.muhoitem1.model.domain.VipStarData.VipStarListData;
import com.example.muhoitem1.ui.fragment.HotListFragment;
import com.example.muhoitem1.ui.fragment.StarVipDetailFragment;
import com.example.muhoitem1.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class StarVipViewPagerAdapter extends FragmentPagerAdapter {
    private List<VipStarListData> mDataList = new ArrayList<>();
    private OnStarVipListDataLoad mOnStarVipListDataLoad = null;
    private Context mContext;
    public TextView item_star_tab_text;
    public ImageView item_star_tab_thumb;
    public ImageView item_star_tab_symbol;
    public RelativeLayout item_star_tab_back;
    public LinearLayout starVip_container;

    public StarVipViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position).getName();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        StarVipDetailFragment starVipDetailFragment = StarVipDetailFragment.newInstance();
        return starVipDetailFragment;
    }


    @Override
    public int getCount() {
        if (mDataList == null) {
            return 0;
        } else {
            return mDataList.size();
        }
    }

    public void addData(List<VipStarListData> data) {
        mDataList.clear();
        mDataList.addAll(data);
        notifyDataSetChanged();
        if (mOnStarVipListDataLoad!=null) {
            mOnStarVipListDataLoad.onDataLoad();
        }
    }

    public void setmOnStarVipListDataLoad(OnStarVipListDataLoad listener){
        this.mOnStarVipListDataLoad = listener;
    }

    public View getTabView(int i, Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_star_tab_item, null);
        item_star_tab_text = view.findViewById(R.id.item_star_tab_text);
        item_star_tab_thumb = view.findViewById(R.id.item_star_tab_thumb);
        item_star_tab_symbol = view.findViewById(R.id.item_star_tab_symbol);
        item_star_tab_back = view.findViewById(R.id.item_star_tab_back);
        starVip_container = view.findViewById(R.id.starVip_container);
        item_star_tab_text.setText(mDataList.get(i).getName());
        Glide.with(context).load(mDataList.get(i).getAvatar()).into(item_star_tab_thumb);
        Glide.with(context).load(mDataList.get(i).getSymbolpic()).into(item_star_tab_symbol);
        item_star_tab_back.setBackgroundColor(Color.parseColor(mDataList.get(i).getTheme()));
        return view;
    }

    public interface OnStarVipListDataLoad {
        void onDataLoad();
    }
}
