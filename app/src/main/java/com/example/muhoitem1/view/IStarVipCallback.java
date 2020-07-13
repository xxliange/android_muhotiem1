package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.VipStarData.VipStarListData;

import java.util.List;

public interface IStarVipCallback extends IBaseCallback {

    void onGetStarList(List<VipStarListData> data);

}
