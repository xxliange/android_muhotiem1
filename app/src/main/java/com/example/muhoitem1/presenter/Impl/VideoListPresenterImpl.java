package com.example.muhoitem1.presenter.Impl;

import com.example.muhoitem1.model.Api;
import com.example.muhoitem1.model.domain.VideoData.VideoListData;
import com.example.muhoitem1.model.network.BaseObserver;
import com.example.muhoitem1.presenter.IVideoListPresenter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.RetrofitManaget;
import com.example.muhoitem1.view.IVideoListCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class VideoListPresenterImpl implements IVideoListPresenter {
    private Map<Integer, Integer> pagesInfo = new HashMap<>();
    public static final int DEFAULT_PAGE = 1;
    private List<IVideoListCallback> callbacks = new ArrayList<>();

    @Override
    public void registerViewCallback(IVideoListCallback callback) {
        if (!callbacks.contains(callback)) {
            callbacks.add(callback);
        }
    }

    @Override
    public void unregisterViewCallback(IVideoListCallback callback) {
        callbacks.remove(callback);
    }

    /**
     * 获取列表信息
     *
     * @param type
     */
    @Override
    public void getVideoListData(int type) {
        Integer targetPage = pagesInfo.get(type);
        if (targetPage == null) {
            targetPage = DEFAULT_PAGE;
            pagesInfo.put(type, targetPage);
        }
        switch (type) {
            case 1:
            case 4:
                //季度教学
                getTeachList(type);
                break;
            case 2:
                //精品专辑
                getAlbumList(type);
                break;
            case 3:
                getNewList(type);
                //最新教学
                break;
            //技巧教学
            case 5:
                getHotList(type);
                //热点视频
                break;
            default:
                return;
        }
//        LogUtils.d(this, "type --> " + type);
    }

    private void getHotList(int type) {
        Integer page = pagesInfo.get(type);
//        LogUtils.d(this, "pagesInfo" + type + "--> " + page);
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getHomeVideoListData(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<VideoListData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {
                    }

                    @Override
                    protected void onSuccess(List<VideoListData> data) {
                        LogUtils.d(VideoListPresenterImpl.this, "Data --> " + data.toString());
                        handleHomePageContentResult(data, type);

                    }
                });
    }

    private void getNewList(int type) {
        Integer page = pagesInfo.get(type);
//        LogUtils.d(this, "pagesInfo" + type + "--> " + page);
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getVideoListNewData(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<VideoListData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {
                    }

                    @Override
                    protected void onSuccess(List<VideoListData> data) {
                        LogUtils.d(VideoListPresenterImpl.this, "Data --> " + data.toString());
                        handleHomePageContentResult(data, type);
                    }
                });
    }

    private void getAlbumList(int type) {
        Integer page = pagesInfo.get(type);
//        LogUtils.d(this, "pagesInfo" + type + "--> " + page);
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getVideoListAlbumData(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<VideoListData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {
                    }

                    @Override
                    protected void onSuccess(List<VideoListData> data) {
                        LogUtils.d(VideoListPresenterImpl.this, "Data --> " + data.toString());
                        handleHomePageContentResult(data, type);
                    }
                });
    }

    private void getTeachList(int type) {
        Integer page = pagesInfo.get(type);
//        LogUtils.d(this, "pagesInfo" + type + "--> " + page);
        Retrofit retrofit = RetrofitManaget.getInstance().getRetrofit();
        retrofit.create(Api.class)
                .getVideoListData(1, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<VideoListData>>() {
                    @Override
                    protected void onFailure(Throwable e, String message) {
                    }

                    @Override
                    protected void onSuccess(List<VideoListData> data) {
                        LogUtils.d(VideoListPresenterImpl.this, "Data --> " + data.toString());
//                        LogUtils.d(VideoListPresenterImpl.this, "type --> " + mCall.getListType());
//                        mCall.onLoadVideoList(data, type);
                        handleHomePageContentResult(data, type);
                    }
                });
    }

    private void handleHomePageContentResult(List<VideoListData> data, int type) {
        List<VideoListData> listData = data;
//            LogUtils.d(this, "callbacks --> " + callbacks);
        for (IVideoListCallback callback : callbacks) {
            if (callback.getListType() == type) {
                if (data == null || data.size() == 0) {
                    callback.onEmpty();
                } else {
                    callback.onLoadVideoList(listData);
                }
            }
        }
    }

    /**
     * 下拉加载更多
     *
     * @param type
     */
    @Override
    public void loadMore(int type) {

    }
}
