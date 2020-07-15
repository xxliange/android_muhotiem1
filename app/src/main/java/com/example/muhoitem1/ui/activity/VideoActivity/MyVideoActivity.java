package com.example.muhoitem1.ui.activity.VideoActivity;

import android.content.Context;
import android.util.AttributeSet;

import com.example.muhoitem1.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class MyVideoActivity extends StandardGSYVideoPlayer {


    public MyVideoActivity(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public MyVideoActivity(Context context) {
        super(context);
    }

    public MyVideoActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return R.layout.sample_teach_video;
    }
}
