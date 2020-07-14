package com.example.muhoitem1.ui.fragment.VideoFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoCachData;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoListData;
import com.example.muhoitem1.presenter.IAlbumInfoListPresenter;
import com.example.muhoitem1.ui.adapter.AlbumInfoPagerAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.view.IAlbumInfoListCallback;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

public class AlbumInfoListFragment extends BaseFragment implements IAlbumInfoListCallback {

    private IAlbumInfoListPresenter mAlbumInfoListPresenter;
    private List<Integer> tabList=new ArrayList<>();

    @BindView(R.id.album_info_coach_avatar)
    public ImageView cocachAvatar;
    @BindView(R.id.album_info_name)
    public TextView albumName;
    @BindView(R.id.album_info_coach_name)
    public TextView coachName;
    @BindView(R.id.album_info_coach_intro)
    public TextView coachIntro;
    @BindView(R.id.album_info_tab)
    public TabLayout albumTab;
    @BindView(R.id.album_info_pager)
    public ViewPager albumPager;
    private AlbumInfoPagerAdapter mAlbumInfoPagerAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_album_info_list;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
        tabList.add(0);
        tabList.add(1);

        albumTab.setupWithViewPager(albumPager);
        mAlbumInfoPagerAdapter = new AlbumInfoPagerAdapter(getChildFragmentManager());
        albumPager.setAdapter(mAlbumInfoPagerAdapter);
        mAlbumInfoPagerAdapter.addData(tabList);
    }

    @Override
    protected void initPresenter() {
        mAlbumInfoListPresenter = PresentManager.getInstance().getAlbumInfoListPresenter();
        if (mAlbumInfoListPresenter != null) {
            mAlbumInfoListPresenter.registerViewCallback(this);
        }
    }

    @Override
    protected void loadData() {
        mAlbumInfoListPresenter.getAlbumICoachInfoData();
    }

    @Override
    public void onAlbumCoachDataLoad(AlbumInfoCachData cachData) {
        LogUtils.d(this, "data --> " + cachData);
        Glide.with(Objects.requireNonNull(getContext())).load(cachData.getCoachThumb()).into(cocachAvatar);
        albumName.setText(cachData.getName());
        coachName.setText(String.format("训练师: %s", cachData.getAlbumName()));
        coachIntro.setText(cachData.getCoachIntro());

    }

    @Override
    public void onAlbumListDataLoad(List<AlbumInfoListData> listData) {

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
}
