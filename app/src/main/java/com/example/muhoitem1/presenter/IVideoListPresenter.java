package com.example.muhoitem1.presenter;

import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.view.IVideoListCallback;

public interface IVideoListPresenter extends IBaseViewPresenter<IVideoListCallback> {
    void getVideoListData(int type);

    void loadMore(int type);
}
