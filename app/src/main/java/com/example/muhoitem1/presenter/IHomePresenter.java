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


}
