package com.example.muhoitem1.ui.fragment.VideoFragment;

import android.view.View;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VideoTagsListData;
import com.example.muhoitem1.ui.adapter.VideoListPagerAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class VideoListFragment extends BaseFragment {
    @BindView(R.id.teachList_pager)
    public ViewPager teachListPager;
    @BindView(R.id.teachList_tab)
    public TabLayout teachListTab;
    private VideoListPagerAdapter mVideoListPagerAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_video_list;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
        teachListTab.setupWithViewPager(teachListPager);
        mVideoListPagerAdapter = new VideoListPagerAdapter(getChildFragmentManager());
        teachListPager.setAdapter(mVideoListPagerAdapter);
        setPagerTitle();

    }

    private void setPagerTitle() {
        List<VideoTagsListData> mVideoListData = new ArrayList<>();
        VideoTagsListData d1 = new VideoTagsListData();
        d1.setTitle("精品专辑");
        d1.setType(2);
        VideoTagsListData d2 = new VideoTagsListData();
        d2.setTitle("最新教学");
        d2.setType(3);
        VideoTagsListData d3 = new VideoTagsListData();
        d3.setTitle("季度教学");
        d3.setType(1);
        VideoTagsListData d4 = new VideoTagsListData();
        d4.setTitle("技巧教学");
        d4.setType(4);
        VideoTagsListData d5 = new VideoTagsListData();
        d5.setTitle("热点视频");
        d5.setType(5);
        mVideoListData.add(d1);
        mVideoListData.add(d2);
        mVideoListData.add(d3);
        mVideoListData.add(d4);
        mVideoListData.add(d5);
        LogUtils.d(this, "data --> " + mVideoListData.toString());
        mVideoListPagerAdapter.setTitle(mVideoListData);
    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

}
