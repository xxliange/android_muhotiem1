package com.example.muhoitem1.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.HomeData.BannerData;
import com.example.muhoitem1.model.domain.HomeData.HomeGraduateData;
import com.example.muhoitem1.model.domain.HomeData.HomeNewVideoData;
import com.example.muhoitem1.model.domain.HomeData.HomePayAlbumListData;
import com.example.muhoitem1.model.domain.HomeData.HomePrivateData;
import com.example.muhoitem1.model.domain.HomeData.HomeTeachData;
import com.example.muhoitem1.model.domain.HomeData.StarListData;
import com.example.muhoitem1.presenter.IHomePresenter;
import com.example.muhoitem1.presenter.Impl.HomePresenterImpl;
import com.example.muhoitem1.ui.activity.VideoActivity.TeachVideoActivity;
import com.example.muhoitem1.ui.adapter.HomeGraduateAdapter;
import com.example.muhoitem1.ui.adapter.HomeNewVideoAdapter;
import com.example.muhoitem1.ui.adapter.HomePayAlbumListAdapter;
import com.example.muhoitem1.ui.adapter.HomePrivateAdapter;
import com.example.muhoitem1.ui.adapter.HomeStarListAdapter;
import com.example.muhoitem1.ui.adapter.HomeTeachAdapter;
import com.example.muhoitem1.ui.adapter.LooperPagerAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.SizeUtils;
import com.example.muhoitem1.view.IHomeCallback;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeCallback,HomePayAlbumListAdapter.OnHomePayAlbumListItemClickListener {
    protected Activity mActivity;
    //获取banner控件
    @BindView(R.id.looper_pager)
    public ViewPager looperPager;
    //获取banner指示点控件
    @BindView(R.id.looper_point_container)
    public LinearLayout looperPointContainer;
    @BindView(R.id.homeStarLsit)
    public RecyclerView mHomeStarList;
    @BindView(R.id.homeRefreshLayout)
    public RefreshLayout refreshLayout;
    @BindView(R.id.home_payAlbum_view)
    public RecyclerView mHomePayAlbumView;
    @BindView(R.id.home_teach_view)
    public RecyclerView mHomeTeachView;
    @BindView(R.id.home_graduate_view)
    public RecyclerView mHomeGraduateView;
    @BindView(R.id.home_newVideo_view)
    public RecyclerView mHomeNewVideoView;
    @BindView(R.id.home_private_view)
    public RecyclerView mHomePrivateView;

    private IHomePresenter mHomePresenter;
    private LooperPagerAdapter mLooperPagerAdapter;
    private HomeStarListAdapter mHomeStarListAdapter;
    private HomePayAlbumListAdapter mHomePayAlbumListAdapter;
    private HomeTeachAdapter mHomeTeachAdapter;
    private HomeGraduateAdapter mHomeGraduateAdapter;
    private HomeNewVideoAdapter mHomeNewVideoAdapter;
    private HomePrivateAdapter mHomePrivateAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {

        setBannerAdapter();
        setStarListAdapter();
        setHomeAlbumListAdapter();
        setHomeTeachAdapter();
        setHomeGraduateAdapter();
        setHomeNewVideoAdapter();
        setHomePrivateAdapter();
    }

    /**
     * 设置banner图适配器
     */
    public void setBannerAdapter() {
        //初始化控件
        //创建轮播图适配器
        mLooperPagerAdapter = new LooperPagerAdapter();
        //设置适配器
        looperPager.setAdapter(mLooperPagerAdapter);
    }

    /**
     * 设置球星列表适配器
     */
    public void setStarListAdapter() {
        //创建球星列表适配器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHomeStarList.setLayoutManager(linearLayoutManager);
        mHomeStarListAdapter = new HomeStarListAdapter();
        //设置球星列表适配器
        mHomeStarList.setAdapter(mHomeStarListAdapter);
    }

    /**
     * 设置精品专辑列表适配器
     */
    public void setHomeAlbumListAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        mHomePayAlbumView.setLayoutManager(gridLayoutManager);
        mHomePayAlbumListAdapter = new HomePayAlbumListAdapter();
        mHomePayAlbumView.setAdapter(mHomePayAlbumListAdapter);
    }

    /**
     * 设置幕后教学列表适配器
     */
    private void setHomeTeachAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        mHomeTeachView.setLayoutManager(gridLayoutManager);
        mHomeTeachAdapter = new HomeTeachAdapter();
        mHomeTeachView.setAdapter(mHomeTeachAdapter);
    }

    /**
     * 设置研究所列表适配器
     */
    private void setHomeGraduateAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        mHomeGraduateView.setLayoutManager(gridLayoutManager);
        mHomeGraduateAdapter = new HomeGraduateAdapter();
        mHomeGraduateView.setAdapter(mHomeGraduateAdapter);
    }

    /**
     * 设置最新视频列表适配器
     */
    private void setHomeNewVideoAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        mHomeNewVideoView.setLayoutManager(gridLayoutManager);
        mHomeNewVideoAdapter = new HomeNewVideoAdapter();
        mHomeNewVideoView.setAdapter(mHomeNewVideoAdapter);
    }

    /**
     * 设置私人训练列表适配器
     */
    private void setHomePrivateAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        mHomePrivateView.setLayoutManager(gridLayoutManager);
        mHomePrivateAdapter = new HomePrivateAdapter();
        mHomePrivateView.setAdapter(mHomePrivateAdapter);

    }

    @Override
    protected void initListener() {
        refreshLayout.setOnRefreshListener(refreshLayout1 -> {
            if (mHomePresenter != null) {
                refreshLayout1.finishRefresh();
            }
        });
        mHomePayAlbumListAdapter.setOnHomePayAlbumListItemClickListener(this);
    }

    @Override
    protected void initPresenter() {
        //创建presenter
        mHomePresenter = new HomePresenterImpl();
        mHomePresenter.registerViewCallback(this);
    }

    @Override
    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_home_fragment_layout, container, false);
    }

    @Override
    protected void loadData() {
        //加载数据
        mHomePresenter.getBannerData();
        mHomePresenter.getStarListData();
        mHomePresenter.getPayAlbumData();
        mHomePresenter.getHomeTeachData();
        mHomePresenter.getHomeGraduateData();
        mHomePresenter.getHomeNewVideoData();
        mHomePresenter.getHomePrivateData();
    }

    @Override
    public void onBannerDataLoad(List<BannerData.DataBeanX> bannerData) {
        setUpState(State.SUCCESS);
        //加载的数据就会从这里会来
        mLooperPagerAdapter.setData(bannerData);
        looperPointContainer.removeAllViews();
        //添加点
        for (int i = 0; i < bannerData.size(); i++) {
            View point = new View(getContext());
            int size = SizeUtils.dip2px(getContext(), 8);
//            LogUtils.d(this, "size --> " + size + " -- " + i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(size, size);
            layoutParams.leftMargin = SizeUtils.dip2px(getContext(), 5);
            layoutParams.rightMargin = SizeUtils.dip2px(getContext(), 5);
            point.setLayoutParams(layoutParams);
            if (i == 0) {
//                point.setBackgroundResource(R.drawable.shape_indicator_point);
            } else {
//                point.setBackgroundResource(R.drawable.shape_indicator_normal);
            }

            looperPointContainer.addView(point);
        }
    }

    @Override
    public void onStarListDataLoad(List<StarListData.DataBean> starListData) {
        mHomeStarListAdapter.setData(starListData);
    }

    @Override
    public void onHomePayAlbumDataLoad(List<HomePayAlbumListData.DataBean> payAlbumListData) {
//        LogUtils.d(this,"payAlbumData --> " + payAlbumListData.size());
        mHomePayAlbumListAdapter.setData(payAlbumListData);
    }

    @Override
    public void onHomeTeachDataLoad(List<HomeTeachData.DataBean> teachData) {
        mHomeTeachAdapter.setData(teachData);
    }

    @Override
    public void onHomeGraduateLoad(List<HomeGraduateData.DataBean> graduateData) {
        mHomeGraduateAdapter.setData(graduateData);
    }

    @Override
    public void onHomeNewVideoDataLoad(List<HomeNewVideoData.DataBean> newVideoData) {
        mHomeNewVideoAdapter.setData(newVideoData);
    }

    @Override
    public void onHomePrivateDataLoad(List<HomePrivateData.DataBean> privateData) {
        mHomePrivateAdapter.setData(privateData);
    }

    @Override
    public void onNetworkError() {
        setUpState(State.ERROR);
    }

    @Override
    public void onLoading() {
        setUpState(State.LOADING);
    }

    @Override
    public void onEmpty() {
        setUpState(State.EMPTY);
    }

    @Override
    protected void release() {
        //取消回调注册
        if (mHomePresenter != null) {
            mHomePresenter.unregisterViewCallback(this);
        }
    }

    @Override
    protected void onRetryClick() {
        // 网络错误，点击了重试
        //重新加载banner
        if (mHomePresenter != null) {
            mHomePresenter.getBannerData();
        }
    }

    @Override
    public void onAlbumItemClick(HomePayAlbumListData.DataBean DataBean) {
        Intent intent = new Intent(getContext(), TeachVideoActivity.class);
        intent.putExtra("sid",DataBean.getSid());
        intent.putExtra("name",DataBean.getName());
        getActivity().startActivity(intent);

    }
}
