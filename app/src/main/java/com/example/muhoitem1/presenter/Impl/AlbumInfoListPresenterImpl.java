package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoCachData;
import com.example.muhoitem1.model.network.BaseObserver;
import com.example.muhoitem1.presenter.IAlbumInfoListPresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.IAlbumInfoListCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class AlbumInfoListPresenterImpl implements IAlbumInfoListPresenter {
    private IAlbumInfoListCallback mCallback = null;
    @Override
    public void getAlbumICoachInfoData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getAlbumInfoCachData(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<AlbumInfoCachData>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {
                        LogUtils.d(AlbumInfoListPresenterImpl.this, "message -->" + message);
                    }

                    @Override
                    protected void onSuccess(AlbumInfoCachData data) {
                        LogUtils.d(AlbumInfoListPresenterImpl.this, "data --> " + data.toString());
                        mCallback.onAlbumCoachDataLoad(data);
                    }
                });
    }

    @Override
    public void getAlbumListData() {

    }

    @Override
    public void registerViewCallback(IAlbumInfoListCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IAlbumInfoListCallback callback) {
        this.mCallback = null;
    }
}
