package com.example.muhoitem1.presenter;

import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.view.ITeachVideoCallback;

public interface ITeachVideoPresenter extends IBaseViewPresenter<ITeachVideoCallback> {
    void getTeachVideoData();

    void getTeachVideoRandom();
}
