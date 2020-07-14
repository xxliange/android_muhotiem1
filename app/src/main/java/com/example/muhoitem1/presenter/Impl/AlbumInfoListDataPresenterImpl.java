package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoListData;
import com.example.muhoitem1.model.network.BaseObserver;
import com.example.muhoitem1.presenter.IAlbumInfoListDataPresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.IAlbumInfoListDataCallback;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AlbumInfoListDataPresenterImpl implements IAlbumInfoListDataPresenter {
    private IAlbumInfoListDataCallback mCallback = null;

    @Override
    public void getAlbumInfoListData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getAlbumInfoListData(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<AlbumInfoListData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {

                    }

                    @Override
                    protected void onSuccess(List<AlbumInfoListData> data) {
                        mCallback.onAlbumListDataLoad(data);
                    }
                });

    }

    @Override
    public void registerViewCallback(IAlbumInfoListDataCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IAlbumInfoListDataCallback callback) {
        mCallback = null;
    }
}
