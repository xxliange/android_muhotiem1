package com.example.muhoitem1.ui.fragment.VideoFragment;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
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

public class AlbumInfoListDataFragment extends BaseFragment implements IAlbumInfoListDataCallback{

    @BindView(R.id.album_info_list_data_view)
    public RecyclerView mContentList;

    private IAlbumInfoListDataPresenter mAlbumInfoListDataPresenter;
    private AlbumInfoListDataAdapter mAlbumInfoListDataAdapter;

    private AlbumInfoListDataListener listener;
    public interface AlbumInfoListDataListener {
        void showItem(AlbumInfoListData albumInfoListData);
    }

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
    protected void initListener() {
        mAlbumInfoListDataAdapter.setOnItemClickListener(data -> listener.showItem(data));
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
        mAlbumInfoListDataAdapter.addData(listData);
        listener.showItem(listData.get(0));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AlbumInfoListDataListener) {
            listener = (AlbumInfoListDataListener) context;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener = null;
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
