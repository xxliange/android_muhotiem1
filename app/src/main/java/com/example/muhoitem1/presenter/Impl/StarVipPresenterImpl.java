package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.VipStarData.VipStarListData;
import com.example.muhoitem1.model.network.BaseObserver;
import com.example.muhoitem1.presenter.IStarVipPresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.IStarVipCallback;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class StarVipPresenterImpl implements IStarVipPresenter {

    private IStarVipCallback mCallback = null;

    @Override
    public void registerViewCallback(IStarVipCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IStarVipCallback callback) {
        this.mCallback = null;
    }

    @Override
    public void getStarList() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getStarVipListData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<VipStarListData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {

                    }

                    @Override
                    protected void onSuccess(List<VipStarListData> data) {
                        mCallback.onGetStarList(data);
                    }
                });
    }
}
