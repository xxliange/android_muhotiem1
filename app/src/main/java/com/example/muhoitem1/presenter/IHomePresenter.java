/**
 * 获取首页接口
 */
package com.example.muhoitem1.presenter;


import com.example.muhoitem1.base.IBaseViewPresenter;
import com.example.muhoitem1.view.IHomeCallback;

public interface IHomePresenter extends IBaseViewPresenter<IHomeCallback> {
    /**
     * 获取banner图数据
     */
    void getBannerData();

    /**
     * 获取球星列表数据
     */
    void getStarListData();

    /**
     * 获取精品专辑数据
     */
    void getPayAlbumData();

    /**
     * 获取幕后教学列表数据
     */
    void getHomeTeachData();

    /**
     * 获取研究所列表数据
     */
    void getHomeGraduateData();


}
