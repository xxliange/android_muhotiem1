package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.HotData.HotListData;
import com.example.muhoitem1.presenter.IHotListPresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.IHotListCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HotListPresenterImpl implements IHotListPresenter {
    private IHotListCallback mCallback = null;
    private int l = 1;

    @Override
    public void getHotListData() {
        // 去加载热点列表
        LogUtils.d(HotListPresenterImpl.this, "开始加载热点列表!");
        if (mCallback != null) {
            mCallback.onLoading();
        }
        Call<HotListData> task = createTask();
        task.enqueue(new Callback<HotListData>() {
            @Override
            public void onResponse(Call<HotListData> call, Response<HotListData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    HotListData pageContent = response.body();
                    //更新UI
                    if (pageContent == null || pageContent.getData().size() == 0) {
                        mCallback.onEmpty();
                    } else {
                        mCallback.onContentLoaded(pageContent.getData());
                    }
                } else {
                    mCallback.onError();
                }

            }

            @Override
            public void onFailure(Call<HotListData> call, Throwable t) {
                mCallback.onError();
            }
        });


    }

    private Call<HotListData> createTask() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        return api.getHotListData(l);
    }

    @Override
    public void loadMore() {
        //加载更多内容
        l++;
        LogUtils.d(this, "DEFAULT_PAGE --> " + l);
        Call<HotListData> task = createTask();
        task.enqueue(new Callback<HotListData>() {
            @Override
            public void onResponse(Call<HotListData> call, Response<HotListData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    HotListData result = response.body();
                    if (result == null || result.getData().size() == 0) {
                        l--;
                        mCallback.onLoadMoreEmpty();
                    } else {
                        mCallback.onLoadMoreLoaded(result.getData());
                    }

                } else {
                    l--;
                    mCallback.onLoadMoreError();
                }
            }

            @Override
            public void onFailure(Call<HotListData> call, Throwable t) {
                l--;
                mCallback.onLoadMoreError();
            }
        });
    }

    @Override
    public void reload() {

    }

    // 下拉刷新
    @Override
    public void refreshLoad() {
        int olderl = l;
        l = 1;
        Call<HotListData> task = createTask();
        task.enqueue(new Callback<HotListData>() {
            @Override
            public void onResponse(Call<HotListData> call, Response<HotListData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    HotListData result = response.body();
                    if (result == null || result.getData().size() == 0) {
                        l = olderl;
                        mCallback.onLoadMoreEmpty();
                    } else {
                        mCallback.onRefreshLoaded(result.getData());
                    }

                } else {
                    l = olderl;
                    mCallback.onLoadMoreError();
                }
            }

            @Override
            public void onFailure(Call<HotListData> call, Throwable t) {
                l = olderl;
                mCallback.onLoadMoreError();
            }
        });

    }

    @Override
    public void registerViewCallback(IHotListCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IHotListCallback callback) {
        this.mCallback = null;
    }
}
