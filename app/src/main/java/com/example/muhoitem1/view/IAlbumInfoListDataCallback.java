package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.VideoData.AlbumInfoListData;

import java.util.List;

public interface IAlbumInfoListDataCallback extends IBaseCallback {
    void onAlbumListDataLoad(List<AlbumInfoListData> listData);
}
