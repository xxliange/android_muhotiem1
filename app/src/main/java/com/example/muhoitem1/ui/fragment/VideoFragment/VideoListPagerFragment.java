package com.example.muhoitem1.ui.fragment.VideoFragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VideoData.VideoListData;
import com.example.muhoitem1.presenter.IVideoListPresenter;
import com.example.muhoitem1.ui.adapter.HomeNewVideoAdapter;
import com.example.muhoitem1.ui.adapter.VideoListContentAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.view.IVideoListCallback;

import java.util.List;

import butterknife.BindView;

public class VideoListPagerFragment extends BaseFragment implements IVideoListCallback {

    private IVideoListPresenter mVideoListPresenter;
    private Integer mType;
    private VideoListContentAdapter mContentAdapter;
    @BindView(R.id.video_list_content)
    public RecyclerView mContent;

    public static VideoListPagerFragment newInstance(Integer type){
        VideoListPagerFragment videoListPagerFragment = new VideoListPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        videoListPagerFragment.setArguments(bundle);
        return videoListPagerFragment;
    }

    @Override
    protected void initPresenter() {
        mVideoListPresenter = PresentManager.getInstance().getVideoListPresenter();
        mVideoListPresenter.registerViewCallback(this);

    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_video_list_pager;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        mContent.setLayoutManager(gridLayoutManager);
        mContentAdapter = new VideoListContentAdapter();
        mContent.setAdapter(mContentAdapter);
    }

    @Override
    protected void loadData() {
        Bundle arguments = getArguments();
        mType = arguments.getInt("type");
        mVideoListPresenter.getVideoListData(mType);
    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onLoadVideoList(List<VideoListData> listData) {
        LogUtils.d(this, "listData --> " + listData);
        mContentAdapter.setData(listData, mType);

    }

    @Override
    public int getListType() {
        return mType;
    }
}
