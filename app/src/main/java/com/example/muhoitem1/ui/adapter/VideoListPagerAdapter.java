package com.example.muhoitem1.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.muhoitem1.model.domain.VideoTagsListData;
import com.example.muhoitem1.ui.fragment.VideoFragment.VideoListPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class VideoListPagerAdapter extends FragmentPagerAdapter {
    private List<VideoTagsListData> mData = new ArrayList<>();
    public VideoListPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position).getTitle();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        VideoListPagerFragment videoListPagerFragment = VideoListPagerFragment.newInstance(mData.get(position).getType());
        return videoListPagerFragment;
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return  0;
        }else {
            return mData.size();
        }
    }

    public void setTitle(List<VideoTagsListData> mVideoListData) {
        mData.clear();
        mData.addAll(mVideoListData);
        notifyDataSetChanged();
    }
}
