package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoCachData;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoListData;

import java.util.List;

public interface IAlbumInfoListCallback extends IBaseCallback {
    /**
     * 获取专辑教练信息
     * @param cachData
     */
    void onAlbumCoachDataLoad(AlbumInfoCachData cachData);
    /**
     * 获取专辑数据列表
     * @param listData
     */
    void onAlbumListDataLoad(List<AlbumInfoListData> listData);
}
