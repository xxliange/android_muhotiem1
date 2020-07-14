package com.example.muhoitem1.presenter;

import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.view.IAlbumInfoListDataCallback;

public interface IAlbumInfoListDataPresenter extends IBaseViewPresenter<IAlbumInfoListDataCallback> {

    void getAlbumInfoListData();
}
