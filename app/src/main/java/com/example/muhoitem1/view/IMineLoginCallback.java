package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.MineData.MineLoginData;

import java.util.List;

public interface IMineLoginCallback extends IBaseCallback {

    void onSuccessLogin(MineLoginData.DataBean userData);
}
