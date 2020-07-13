package com.example.muhoitem1.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VipStarData.VipStarListData;
import com.example.muhoitem1.presenter.IStarVipPresenter;
import com.example.muhoitem1.ui.adapter.StarVipViewPagerAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.utils.Utils;
import com.example.muhoitem1.view.IStarVipCallback;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

public class StarVipFragment extends BaseFragment implements IStarVipCallback, StarVipViewPagerAdapter.OnStarVipListDataLoad {

    private IStarVipPresenter mStarVipPresenter;

    @BindView(R.id.starVip_view)
    public ViewPager mViewPager;
    @BindView(R.id.starVip_tab)
    public TabLayout mTabLayout;
    @BindView(R.id.starVip_container)
    public LinearLayout starVip_container;
    @BindView(R.id.starVip_headerImg)
    public ImageView starVip_headerImg;
    private StarVipViewPagerAdapter mStarVipViewPagerAdapter;
    private List<VipStarListData> mData = new ArrayList<>();

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_starvip;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);

        starVip_container.setPadding(0, Utils.getStatusBarHeight(Objects.requireNonNull(getContext())),0,0);
        mTabLayout.setupWithViewPager(mViewPager);
        mStarVipViewPagerAdapter = new StarVipViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mStarVipViewPagerAdapter);
    }

    @Override
    protected void loadData() {
        mStarVipPresenter.getStarList();
        LogUtils.d(this, "count --> " + mTabLayout.getTabCount() );
    }

    @Override
    protected void initPresenter() {
        mStarVipPresenter = PresentManager.getInstance().getStarVipPresenter();
        mStarVipPresenter.registerViewCallback(this);
    }

    @Override
    public void onGetStarList(List<VipStarListData> data) {
        LogUtils.d(this, "data --> " + data);
        mData.clear();
        mData.addAll(data);
        Glide.with(Objects.requireNonNull(getContext())).load(data.get(0).getSymbol()).into(starVip_headerImg);
        if (mStarVipViewPagerAdapter != null) {
            mStarVipViewPagerAdapter.addData(data);
        }
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
    protected void release() {
        if (mStarVipPresenter != null) {
            mStarVipPresenter.unregisterViewCallback(this);
        }
    }

    @Override
    public void onDataLoad() {
        int tabCount = mTabLayout.getTabCount();
        LogUtils.d(this, "success Data" + tabCount);
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tabAt = mTabLayout.getTabAt(i);
            if (tabAt != null) {
                tabAt.setCustomView(mStarVipViewPagerAdapter.getTabView(i,getContext()));
            }
        }
    }

    @Override
    protected void initListener() {
        mStarVipViewPagerAdapter.setmOnStarVipListDataLoad(this);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.d(StarVipFragment.this, "position --> " + position);
                if (mData!=null) {
                Glide.with(Objects.requireNonNull(getContext())).load(mData.get(position).getSymbol()).into(starVip_headerImg);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
