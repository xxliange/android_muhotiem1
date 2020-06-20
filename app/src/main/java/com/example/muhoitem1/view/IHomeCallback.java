package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.BannerData;

import java.util.List;

public interface IHomeCallback extends IBaseCallback {
    void onBannerDataLoad(List<BannerData.DataBeanX> bannerData);
}
