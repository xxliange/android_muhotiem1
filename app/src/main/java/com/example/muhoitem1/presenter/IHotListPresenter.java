package com.example.muhoitem1.presenter;

import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.view.IHotListCallback;

public interface IHotListPresenter extends IBaseViewPresenter<IHotListCallback> {
    /**
     * 获取热点列表数据
     */
    void getHotListData();

    /**
     * 加载更多
     */
    void loadMore();

    void reload();

    void refreshLoad();



}
