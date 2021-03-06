package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.HomeData.BannerData;
import com.example.muhoitem1.model.domain.HomeData.HomeGraduateData;
import com.example.muhoitem1.model.domain.HomeData.HomeNewVideoData;
import com.example.muhoitem1.model.domain.HomeData.HomePayAlbumListData;
import com.example.muhoitem1.model.domain.HomeData.HomePrivateData;
import com.example.muhoitem1.model.domain.HomeData.HomeTeachData;
import com.example.muhoitem1.model.domain.HomeData.StarListData;
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

    /**
     * 获取banner图数据
     */
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
                            mCallback.onBannerDataLoad(banner);
                        }
                    }
                } else {
                    //请求失败
                    LogUtils.i(HomePresenterImpl.this, "请求失败！");
                    if (mCallback != null) {
                        mCallback.onNetworkError();
                    }
                }
            }

            @Override
            public void onFailure(Call<BannerData> call, Throwable t) {
                //加载失败的结果
                //TODO:
                LogUtils.e(HomePresenterImpl.this, t.toString());
                if (mCallback != null) {
                    mCallback.onNetworkError();
                }
            }
        });

    }

    /**
     * 获取球星列表数据
     */
    @Override
    public void getStarListData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<StarListData> task = api.getStarListData();
        task.enqueue(new Callback<StarListData>() {
            @Override
            public void onResponse(Call<StarListData> call, Response<StarListData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    List<StarListData.DataBean> data = response.body().getData();
                    mCallback.onStarListDataLoad(data);
                }
            }

            @Override
            public void onFailure(Call<StarListData> call, Throwable t) {

            }
        });

    }

    /**
     * 获取精品专辑列表
     */
    @Override
    public void getPayAlbumData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<HomePayAlbumListData> task = api.getHomePayAlbumListData();
        task.enqueue(new Callback<HomePayAlbumListData>() {
            @Override
            public void onResponse(Call<HomePayAlbumListData> call, Response<HomePayAlbumListData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
//                    LogUtils.d(HomePresenterImpl.this,response.body().getData().size()+"");
                    List<HomePayAlbumListData.DataBean> data = response.body().getData();
                    mCallback.onHomePayAlbumDataLoad(data);
                }

            }

            @Override
            public void onFailure(Call<HomePayAlbumListData> call, Throwable t) {

            }
        });

    }

    @Override
    public void getHomeTeachData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<HomeTeachData> task = api.getHomeTeachData();
        task.enqueue(new Callback<HomeTeachData>() {
            @Override
            public void onResponse(Call<HomeTeachData> call, Response<HomeTeachData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    List<HomeTeachData.DataBean> data = response.body().getData();
                    mCallback.onHomeTeachDataLoad(data);
                }
            }

            @Override
            public void onFailure(Call<HomeTeachData> call, Throwable t) {

            }
        });
    }

    @Override
    public void getHomeGraduateData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<HomeGraduateData> task = api.getHomeGraduateData(2, 1);
        task.enqueue(new Callback<HomeGraduateData>() {
            @Override
            public void onResponse(Call<HomeGraduateData> call, Response<HomeGraduateData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    List<HomeGraduateData.DataBean> data = response.body().getData();
                    mCallback.onHomeGraduateLoad(data);
                }
            }

            @Override
            public void onFailure(Call<HomeGraduateData> call, Throwable t) {

            }
        });
    }

    @Override
    public void getHomeNewVideoData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<HomeNewVideoData> task = api.getHomeNewVideoData();
        task.enqueue(new Callback<HomeNewVideoData>() {
            @Override
            public void onResponse(Call<HomeNewVideoData> call, Response<HomeNewVideoData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    List<HomeNewVideoData.DataBean> data = response.body().getData();
                    mCallback.onHomeNewVideoDataLoad(data);
                }
            }

            @Override
            public void onFailure(Call<HomeNewVideoData> call, Throwable t) {

            }
        });
    }

    @Override
    public void getHomePrivateData() {
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<HomePrivateData> task = api.getHomePrivateData(1);
        task.enqueue(new Callback<HomePrivateData>() {
            @Override
            public void onResponse(Call<HomePrivateData> call, Response<HomePrivateData> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    List<HomePrivateData.DataBean> data = response.body().getData();
                    mCallback.onHomePrivateDataLoad(data);
                }
            }

            @Override
            public void onFailure(Call<HomePrivateData> call, Throwable t) {

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
