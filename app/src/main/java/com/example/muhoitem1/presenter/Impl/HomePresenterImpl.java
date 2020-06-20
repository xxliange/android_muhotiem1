package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.BannerData;
import com.example.muhoitem1.presenter.IHomePresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.IHomeCallback;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements IHomePresenter {
    private IHomeCallback mCallback = null;

    @Override
    public void getBannerData() {
        if (mCallback != null) {
            mCallback.onLoading();
        }
        //加载banner图
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<BannerData> task = api.getBannerData(2, 1);
        task.enqueue(new Callback<BannerData>() {
            @Override
            public void onResponse(Call<BannerData> call, Response<BannerData> response) {
                //数据结果
                int code = response.code();
                LogUtils.d(HomePresenterImpl.this, "result --> " + code);
                if (code == HttpURLConnection.HTTP_OK) {
                    //请求成功
                    List<BannerData.DataBeanX> banner = response.body().getData();
                    if (mCallback != null) {
                        if (banner == null || banner.size() == 0) {
                            mCallback.onEmpty();
                        } else {
                            //LogUtils.d(HomePresenterImpl.this, banner.toString());
                            //LogUtils.d(HomePresenterImpl.this, data.size() + "");
                            mCallback.onBannerDataLoad((List<BannerData.DataBeanX>) banner);
                        }
                    }
                } else {
                    //请求失败
                    LogUtils.i(HomePresenterImpl.this, "请求失败！");
                    if (mCallback!=null) {
                        mCallback.onNetworkError();
                    }
                }
            }

            @Override
            public void onFailure(Call<BannerData> call, Throwable t) {
                //加载失败的结果
                //TODO:
                LogUtils.e(HomePresenterImpl.this, t.toString());
                if (mCallback!=null) {
                    mCallback.onNetworkError();
                }
            }
        });

    }

    @Override
    public void registerViewCallback(IHomeCallback iHomeCallback) {
        this.mCallback = iHomeCallback;
    }

    @Override
    public void unregisterViewCallback(IHomeCallback iHomeCallback) {
        mCallback = null;

    }
}
