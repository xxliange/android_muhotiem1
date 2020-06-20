package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.HotListData;

import java.util.List;

public interface IHotListCallback extends IBaseCallback {
    /**
     * 数据加载回来
     * @param contents
     */
    void onContentLoaded(List<HotListData.DataBean> contents);

    void onError();

    void onLoadMoreError();

    void onLoadMoreEmpty();

    void onLoadMoreLoaded(List<HotListData.DataBean> contents);

    void onRefreshLoaded(List<HotListData.DataBean> contents);

}
