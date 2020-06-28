package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.VideoData.TeachVideoData;
import com.example.muhoitem1.model.domain.VideoData.TeachVideoRandomData;
import com.example.muhoitem1.model.network.BaseObserver;
import com.example.muhoitem1.presenter.ITeachVideoPresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.ITeachVideoCallback;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class TeachVideoPresenterImpl implements ITeachVideoPresenter {
    private ITeachVideoCallback mCallback = null;

    @Override
    public void getTeachVideoData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getTeachVideoData(91)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<TeachVideoData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {
                        LogUtils.d(TeachVideoPresenterImpl.this, "onFailur --> " + message );
                    }

                    @Override
                    protected void onSuccess(List<TeachVideoData> data) {
//                        LogUtils.d(TeachVideoPresenterImpl.this, "onSuccess --> " + data.size());
//                        LogUtils.d(TeachVideoPresenterImpl.this, "onSuccess --> " + data.toString());
                        mCallback.onShowTeachVideoInfo(data);
                    }
                });
    }

    @Override
    public void getTeachVideoRandom() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getTeachVideoRandomData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<TeachVideoRandomData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {

                    }

                    @Override
                    protected void onSuccess(List<TeachVideoRandomData> data) {
//                        LogUtils.d(TeachVideoPresenterImpl.this, "data --> " + data.toString());
                        mCallback.onGetTeachVideoRandomData(data);
                    }
                });
    }

    @Override
    public void registerViewCallback(ITeachVideoCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(ITeachVideoCallback callback) {
        mCallback = null;
    }
}
