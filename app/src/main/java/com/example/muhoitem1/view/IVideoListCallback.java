package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.VideoData.VideoListData;

import java.util.List;

public interface IVideoListCallback extends IBaseCallback {
    void onLoadVideoList(List<VideoListData> listData);

    int getListType();
}
