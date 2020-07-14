package com.example.muhoitem1.presenter;

import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.view.IAlbumInfoListCallback;

public interface IAlbumInfoListPresenter extends IBaseViewPresenter<IAlbumInfoListCallback> {

    /**
     * 获取专辑教练信息
     */
    void getAlbumICoachInfoData();

    /**
     * 获取专辑列表数据
     */
    void getAlbumListData();
}
