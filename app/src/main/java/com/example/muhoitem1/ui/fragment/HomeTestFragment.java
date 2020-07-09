package com.example.muhoitem1.ui.fragment;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VideoTagsListData;
import com.example.muhoitem1.ui.adapter.HomeTestListPagerAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.StatusBarUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeTestFragment extends BaseFragment {
    private List<String> evenList = new ArrayList<>();
    @BindView(R.id.homeTest_tab)
    public TabLayout tabLayout;
    @BindView(R.id.homeTest_pager)
    public ViewPager2 viewPager2;
    @BindView(R.id.homeTest_tabContainer)
    public LinearLayout homeTest_tabContainer;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home_test;
    }

    @Override
    protected void initView(View rootView) {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        viewPager2.setSaveEnabled(false);
        setUpState(State.SUCCESS);
        viewPager2.setAdapter(new HomeTestListPagerAdapter(this));
        evenList.add("推荐");
        evenList.add("每日更新");
        evenList.add("季度教学");
        evenList.add("技巧教学");
        evenList.add("研究所");
//        ViewGroup.LayoutParams layoutParams = homeTest_view.getLayoutParams();
//        layoutParams.height = getStatusBarHeight();
//        homeTest_view.setLayoutParams(layoutParams);

//        ViewGroup.LayoutParams layoutParams1 = tabLayout.getLayoutParams();
//        layoutParams1.height = 200;
//        tabLayout.setLayoutParams(layoutParams1);
        homeTest_tabContainer.setPadding(0,getStatusBarHeight(),0,0);
        LogUtils.d(this, "evenList ---> " + evenList);
        super.initView(rootView);
        new TabLayoutMediator(tabLayout, viewPager2, false, (tab, position) -> {
            LogUtils.d(HomeTestFragment.this, "text --> " + evenList.get(position));
            tab.setText(evenList.get(position));
        }).attach();
        getStatusBarHeight();

    }

    public int getStatusBarHeight() {
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        LogUtils.d("CompatToolbar", "状态栏高度：" + pxToDp(getContext(),statusBarHeight) + "dp");
        return statusBarHeight;
    }

    public int pxToDp(Context context, int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
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
