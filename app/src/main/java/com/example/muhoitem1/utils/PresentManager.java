package com.example.muhoitem1.utils;

import com.example.muhoitem1.presenter.IMineLoginPresenter;
import com.example.muhoitem1.presenter.ITeachVideoPresenter;
import com.example.muhoitem1.presenter.Impl.MIneLoginPresenterImpl;
import com.example.muhoitem1.presenter.Impl.TeachVideoPresenterImpl;

public class PresentManager {
    private static final PresentManager outInstance = new PresentManager();
    private final IMineLoginPresenter mMineLoginPresenter;
    private final ITeachVideoPresenter mTeachVideoPresenter;

    public static PresentManager getInstance() {
        return outInstance;
    }

    public IMineLoginPresenter getMineLoginPresenter() {
        return mMineLoginPresenter;
    }
    public ITeachVideoPresenter getTeachVideoPresenter() {return mTeachVideoPresenter;}

    private PresentManager() {
        mMineLoginPresenter = new MIneLoginPresenterImpl();
        mTeachVideoPresenter = new TeachVideoPresenterImpl();
    }
}
