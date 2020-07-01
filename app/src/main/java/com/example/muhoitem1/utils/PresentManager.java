package com.example.muhoitem1.utils;

import com.example.muhoitem1.presenter.IMineLoginPresenter;
import com.example.muhoitem1.presenter.ITeachVideoPresenter;
import com.example.muhoitem1.presenter.IVideoListPresenter;
import com.example.muhoitem1.presenter.Impl.MIneLoginPresenterImpl;
import com.example.muhoitem1.presenter.Impl.TeachVideoPresenterImpl;
import com.example.muhoitem1.presenter.Impl.VideoListPresenterImpl;

public class PresentManager {
    private static final PresentManager outInstance = new PresentManager();
    private final IMineLoginPresenter mMineLoginPresenter;
    private final ITeachVideoPresenter mTeachVideoPresenter;
    private final IVideoListPresenter mVideoListPresenter;

    public static PresentManager getInstance() {
        return outInstance;
    }

    public IMineLoginPresenter getMineLoginPresenter() {
        return mMineLoginPresenter;
    }

    public ITeachVideoPresenter getTeachVideoPresenter() {
        return mTeachVideoPresenter;
    }

    public IVideoListPresenter getVideoListPresenter() {
        return mVideoListPresenter;
    }

    private PresentManager() {
        mMineLoginPresenter = new MIneLoginPresenterImpl();
        mTeachVideoPresenter = new TeachVideoPresenterImpl();
        mVideoListPresenter = new VideoListPresenterImpl();
    }
}
