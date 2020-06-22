package com.example.muhoitem1.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.HotData.HotListData;
import com.example.muhoitem1.presenter.Impl.HotListPresenterImpl;
import com.example.muhoitem1.ui.activity.HotDetailActivity;
import com.example.muhoitem1.ui.adapter.HotListContentAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.SizeUtils;
import com.example.muhoitem1.utils.ToastUtils;
import com.example.muhoitem1.view.IHotListCallback;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

public class HotListFragment extends BaseFragment implements IHotListCallback, HotListContentAdapter.OnListenerItemClickListener {


    private HotListPresenterImpl mHotListPresenter;

    @Nullable
    @BindView(R.id.refreshLayout)
    public RefreshLayout refreshLayout;
    @BindView(R.id.hot_list_content_list)
    public RecyclerView mContentList;
    @BindView(R.id.tool_title)
    public TextView toolTitle;
    private HotListContentAdapter mContentApapter;


    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_hotlist;
    }

    @Override
    protected void initView(View rootView) {
        //设置布局管理器
        mContentList.setLayoutManager(new LinearLayoutManager(getContext()));
        mContentList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                int size = SizeUtils.dip2px(getContext(), 8);
                outRect.bottom = size;
            }
        });
        //创建适配器
        mContentApapter = new HotListContentAdapter();
        //设置适配器
        mContentList.setAdapter(mContentApapter);
        toolTitle.setText(Objects.requireNonNull(getContext()).getString(R.string.text_hot));
    }

    @Override
    protected void initListener() {
        mContentApapter.setOnListenerItemClickListener(this);
        refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            if (mHotListPresenter != null) {
                mHotListPresenter.loadMore();
            }
        });

        refreshLayout.setOnRefreshListener(refreshLayout1 -> {
            LogUtils.d(this, "-- refresh in --");
            if (mHotListPresenter!=null) {
                mHotListPresenter.refreshLoad();
            }
        });

    }

    @Override
    protected void initPresenter() {
        mHotListPresenter = new HotListPresenterImpl();
        mHotListPresenter.registerViewCallback(this);

    }

    @Override
    protected void loadData() {
        mHotListPresenter.getHotListData();
    }

    @Override
    public void onContentLoaded(List<HotListData.DataBean> contents) {
        setUpState(State.SUCCESS);
        // 数据列表加载到了
        LogUtils.d(this, "data --> " + contents);
        mContentApapter.setData(contents);
    }

    @Override
    public void onError() {
        setUpState(State.ERROR);
    }

    @Override
    public void onLoadMoreError() {
        ToastUtils.showToast("网络错误,请重试!");
        if (refreshLayout!=null) {
            refreshLayout.finishLoadMore(false);
            refreshLayout.finishRefresh(false);
        }
    }

    @Override
    public void onLoadMoreEmpty() {
        if (refreshLayout!=null) {
            refreshLayout.finishLoadMore(false);
            refreshLayout.finishRefresh(false);
        }
    }

    @Override
    public void onLoadMoreLoaded(List<HotListData.DataBean> contents) {
        mContentApapter.addData(contents);
        if (refreshLayout != null) {
            refreshLayout.finishLoadMore();
        }
    }

    // 重新加载数据 网络错误重新加载/下拉刷新
    @Override
    public void onRefreshLoaded(List<HotListData.DataBean> contents) {
        setUpState(State.SUCCESS);
        mContentApapter.setData(contents);
        if (refreshLayout!=null) {
            refreshLayout.finishRefresh();
        }
    }

    @Override
    public void onNetworkError() {

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
        if (mHotListPresenter != null) {
            mHotListPresenter.unregisterViewCallback(this);
        }
    }

    @Override
    protected void onRetryClick() {
        if (mHotListPresenter!=null) {
            setUpState(State.LOADING);
            mHotListPresenter.refreshLoad();
        }
    }

    @Override
    public void onItemClick(HotListData.DataBean item) {
        //列表内容
        handleItemClick(item);
    }

    private void handleItemClick(HotListData.DataBean item) {
        startActivity(new Intent(getContext(), HotDetailActivity.class));
    }
}
