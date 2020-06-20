package com.example.muhoitem1.base;

import com.example.muhoitem1.view.IHomeCallback;

public interface IBaseViewPresenter<T> {
    /**
     * 注册UI通知接口
     * @param callback
     */
    void registerViewCallback(T callback);

    /**
     * 取消UI通知接口
     * @param callback
     */
    void unregisterViewCallback(T callback);
}
