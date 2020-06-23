package com.example.muhoitem1.presenter;

import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.view.IMineLoginCallback;

public interface IMineLoginPresenter extends IBaseViewPresenter<IMineLoginCallback> {

    void userLogin(String user, String pass);
}
