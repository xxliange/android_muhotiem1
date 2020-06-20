package com.example.muhoitem1.ui.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.muhoitem1.model.domain.BannerData;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

public class LooperPagerAdapter extends PagerAdapter {
    private List<BannerData.DataBeanX> mData = new ArrayList<>();

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //处理越界问题
        int realPosition = position % mData.size();
        LogUtils.d(this, "realPosition --> " + realPosition);
        BannerData.DataBeanX dataBeanX = mData.get(realPosition);
        String coverUrl = UrlUtils.getCoverPath(dataBeanX.getPic());
        ImageView iv = new ImageView(container.getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        iv.setLayoutParams(layoutParams);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(container.getContext()).load(coverUrl).into(iv);
        container.addView(iv);
        return iv;
    }

    @Override
    public int getCount() {
        return mData.size() == 0 ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void setData(List<BannerData.DataBeanX> bannerData) {
        mData.clear();
        mData.addAll(bannerData);
        notifyDataSetChanged();
    }
}
