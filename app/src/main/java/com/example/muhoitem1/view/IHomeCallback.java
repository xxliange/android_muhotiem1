package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.BannerData;
import com.example.muhoitem1.model.domain.HomeGraduateData;
import com.example.muhoitem1.model.domain.HomePayAlbumListData;
import com.example.muhoitem1.model.domain.HomeTeachData;
import com.example.muhoitem1.model.domain.StarListData;

import java.util.List;

public interface IHomeCallback extends IBaseCallback {
    /**
     * 获取首页banner图数据
     * @param bannerData
     */
    void onBannerDataLoad(List<BannerData.DataBeanX> bannerData);

    /**
     * 获取首页球星列表数据
     * @param starListData
     */
    void onStarListDataLoad(List<StarListData.DataBean> starListData);

    /**
     * 获取首页精品专辑列表
     * @param payAlbumListData
     */
    void onHomePayAlbumDataLoad(List<HomePayAlbumListData.DataBean> payAlbumListData);

    /**
     * 获取首页幕后教学列表
     * @param teachData
     */
    void onHomeTeachDataLoad(List<HomeTeachData.DataBean> teachData);

    /**
     * 获取首页研究所列表
     * @param graduateData
     */
    void onHomeGraduateLoad(List<HomeGraduateData.DataBean> graduateData);
}
