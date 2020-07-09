package com.example.muhoitem1.ui.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VideoTagsListData;
import com.example.muhoitem1.ui.adapter.HomeTestListPagerAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeTestFragment extends BaseFragment {
    private List<String> evenList=new ArrayList<>();
    @BindView(R.id.homeTest_tab)
    public TabLayout tabLayout;
    @BindView(R.id.homeTest_pager)
    public ViewPager2 viewPager2;
    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home_test;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
        viewPager2.setAdapter(new HomeTestListPagerAdapter(this));
        evenList.add("推荐");
        evenList.add("每日更新");
        evenList.add("季度教学");
        evenList.add("技巧教学");
        evenList.add("研究所");
        LogUtils.d(this, "evenList --> " + evenList );
        super.initView(rootView);
        new TabLayoutMediator(tabLayout, viewPager2,true, (tab, position) -> {
            LogUtils.d(HomeTestFragment.this, "text --> " + evenList.get(position));
            tab.setText(evenList.get(position));
        }).attach();

    }

    @Override
    protected void initListener() {
        super.initListener();
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
//        mVideoListPagerAdapter.setTitle(mVideoListData);
    }
}