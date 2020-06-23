package com.example.muhoitem1.utils;

import com.example.muhoitem1.presenter.IMineLoginPresenter;
import com.example.muhoitem1.presenter.Impl.MIneLoginPresenterImpl;

public class PresentManager {
    private static final PresentManager outInstance = new PresentManager();
    private final IMineLoginPresenter mMineLoginPresenter;

    public static PresentManager getInstance() {
        return outInstance;
    }

    public IMineLoginPresenter getMineLoginPresenter() {
        return mMineLoginPresenter;
    }

    private PresentManager() {
        mMineLoginPresenter = new MIneLoginPresenterImpl();
    }
}
