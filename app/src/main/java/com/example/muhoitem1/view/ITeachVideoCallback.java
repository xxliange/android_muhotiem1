package com.example.muhoitem1.view;

import com.example.muhoitem1.base.IBaseCallback;
import com.example.muhoitem1.model.domain.VideoData.TeachVideoData;

import java.util.List;

public interface ITeachVideoCallback extends IBaseCallback {
    void onShowTeachVideoInfo(List<TeachVideoData> data);
}
