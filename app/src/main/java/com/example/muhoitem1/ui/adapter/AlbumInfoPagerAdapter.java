package com.example.muhoitem1.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.muhoitem1.ui.fragment.VideoFragment.AlbumInfoListDataFragment;
import com.example.muhoitem1.ui.fragment.VideoFragment.AlbumInfoListPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class AlbumInfoPagerAdapter extends FragmentPagerAdapter {
    private List<Integer> mData = new ArrayList<>();

    public AlbumInfoPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        AlbumInfoListPagerFragment albumInfoListPagerFragment = AlbumInfoListPagerFragment.newInstance();
        AlbumInfoListDataFragment albumInfoListDataFragment = AlbumInfoListDataFragment.newInstance();
        if (position == 0) {
            return albumInfoListPagerFragment;
        }else{
            return albumInfoListDataFragment;
        }
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        } else {
            return mData.size();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "简介";
        } else {
            return "目录";
        }
    }

    public void addData(List<Integer> tabList) {
        mData.clear();
        mData.addAll(tabList);
        notifyDataSetChanged();
    }
}
