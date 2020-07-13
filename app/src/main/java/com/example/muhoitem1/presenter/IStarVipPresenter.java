package com.example.muhoitem1.presenter;

import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.model.domain.VipStarData.VipStarListData;
import com.example.muhoitem1.view.IStarVipCallback;

import java.util.List;

public interface IStarVipPresenter extends IBaseViewPresenter<IStarVipCallback> {

    void getStarList();
}
