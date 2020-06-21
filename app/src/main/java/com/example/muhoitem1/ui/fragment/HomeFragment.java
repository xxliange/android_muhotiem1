package com.example.muhoitem1.ui.fragment;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.BannerData;
import com.example.muhoitem1.model.domain.StarListData;
import com.example.muhoitem1.presenter.IHomePresenter;
import com.example.muhoitem1.presenter.Impl.HomePresenterImpl;
import com.example.muhoitem1.ui.adapter.HomeStarListAdapter;
import com.example.muhoitem1.ui.adapter.LooperPagerAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.SizeUtils;
import com.example.muhoitem1.view.IHomeCallback;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeCallback {

    //获取banner控件
    @BindView(R.id.looper_pager)
    public ViewPager looperPager;
    //获取banner指示点控件
    @BindView(R.id.looper_point_container)
    public LinearLayout looperPointContainer;
    @BindView(R.id.homeStarLsit)
    public RecyclerView mHomeStarList;

    private IHomePresenter mHomePresenter;
    private LooperPagerAdapter mLooperPagerAdapter;
    private HomeStarListAdapter mHomeStarListAdapter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        //初始化控件

        //创建轮播图适配器
        mLooperPagerAdapter = new LooperPagerAdapter();
        //设置适配器
        looperPager.setAdapter(mLooperPagerAdapter);

        //创建球星列表适配器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHomeStarList.setLayoutManager(linearLayoutManager);
        mHomeStarListAdapter = new HomeStarListAdapter();
        //设置球星列表适配器
        mHomeStarList.setAdapter(mHomeStarListAdapter);


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
    }

    @Override
    public void onBannerDataLoad(List<BannerData.DataBeanX> bannerData) {
        setUpState(State.SUCCESS);
        //加载的数据就会从这里会来
        mLooperPagerAdapter.setData(bannerData);
        looperPointContainer.removeAllViews();
//        int dx = Integer.MAX_VALUE / 2;
//        int targetCenterPosition = (Integer.MAX_VALUE / 2) - dx;

//        looperPager.setCurrentItem(Integer.MAX_VALUE / 2);
//        LogUtils.d(this,"dx --> " + dx);
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
                point.setBackgroundResource(R.drawable.shape_indicator_point);
            } else {
                point.setBackgroundResource(R.drawable.shape_indicator_normal);
            }

            looperPointContainer.addView(point);
        }
    }

    @Override
    public void onStarListDataLoad(List<StarListData.DataBean> starListData) {
//        LogUtils.d(this, "starListData --> " + starListData);
        mHomeStarListAdapter.setData(starListData);
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
}
