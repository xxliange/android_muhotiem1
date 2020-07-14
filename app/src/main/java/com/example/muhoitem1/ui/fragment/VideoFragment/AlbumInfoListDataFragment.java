package com.example.muhoitem1.ui.fragment.VideoFragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoListData;
import com.example.muhoitem1.presenter.IAlbumInfoListDataPresenter;
import com.example.muhoitem1.ui.adapter.AlbumInfoListDataAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.view.IAlbumInfoListDataCallback;

import java.util.List;

import butterknife.BindView;

public class AlbumInfoListDataFragment extends BaseFragment implements IAlbumInfoListDataCallback {

    @BindView(R.id.album_info_list_data_view)
    public RecyclerView mContentList;

    private IAlbumInfoListDataPresenter mAlbumInfoListDataPresenter;
    private AlbumInfoListDataAdapter mAlbumInfoListDataAdapter;

    public static AlbumInfoListDataFragment newInstance() {
        return new AlbumInfoListDataFragment();
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_album_info_list_data;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
        mContentList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAlbumInfoListDataAdapter = new AlbumInfoListDataAdapter();
        mContentList.setAdapter(mAlbumInfoListDataAdapter);

    }

    @Override
    protected void initPresenter() {
        mAlbumInfoListDataPresenter = PresentManager.getInstance().getAlbumInfoListDataPresenter();
        if (mAlbumInfoListDataPresenter != null) {
            mAlbumInfoListDataPresenter.registerViewCallback(this);
        }
    }

    @Override
    protected void loadData() {
        mAlbumInfoListDataPresenter.getAlbumInfoListData();
    }

    @Override
    public void onAlbumListDataLoad(List<AlbumInfoListData> listData) {
        LogUtils.d(this, "data --> " + listData);
        mAlbumInfoListDataAdapter.addData(listData);
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
