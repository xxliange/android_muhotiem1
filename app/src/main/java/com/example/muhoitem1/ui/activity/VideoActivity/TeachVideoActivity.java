package com.example.muhoitem1.ui.activity.VideoActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.model.domain.VideoData.TeachVideoData;
import com.example.muhoitem1.presenter.ITeachVideoPresenter;
import com.example.muhoitem1.ui.fragment.VideoFragment.TeachVideoDetailFragment;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.view.ITeachVideoCallback;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * 普通教学视频详情页
 */
public class TeachVideoActivity extends BaseActivity implements TeachVideoDetailFragment.TeachVideoDetailListener {
//    @BindView(R.id.tool_title)
//    public TextView toolTitle;
//    @BindView(R.id.back_toolbar)
//    public ImageView back;
    @BindView(R.id.teachVideo_player)
    public StandardGSYVideoPlayer videoPlayer;
    public ImageView videoThumb;
    private OrientationUtils orientationUtils;
    private int mSid;
    private String mName;
    private boolean isPlay;
    private boolean isPause;

    @Override
    protected void loadData() {
    }

    @Override
    protected void initPresent() {

    }

    private void initVideo(String url, int cid){
        videoThumb = findViewById(R.id.item_video_thumb);
        Map<String, String> header = new HashMap<>();
        header.put("ee","33");
        header.put("allowCrossProtocolRedirects", "true");
        GSYVideoOptionBuilder gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
        gsyVideoOptionBuilder
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(false)
                .setUrl(url)
                .setThumbImageView(videoThumb)
                .setMapHeadData(header)
                .setCacheWithPlay(false)
                .setVideoAllCallBack(new GSYSampleCallBack(){
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        orientationUtils.setEnable(true);
                        isPlay = true;

                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        if (orientationUtils!=null) {
                            orientationUtils.backToProtVideo();
                        }
                    }
                })
                .setLockClickListener((view, lock) -> {
                    if (orientationUtils!=null) {
                        orientationUtils.setEnable(!lock);
                    }
                })
                .build(videoPlayer);
        videoPlayer.getBackButton().setOnClickListener(v -> {
            finish();
        });
        videoPlayer.getFullscreenButton().setOnClickListener(v -> {
            orientationUtils.resolveByClick();
            videoPlayer.startWindowFullscreen(TeachVideoActivity.this,false,true);
        });
    }

    private GSYVideoPlayer getCurPlay(){
        LogUtils.d(this, "videoPlayer --> " + videoPlayer);
        if (videoPlayer.getFullWindowPlayer()!=null) {
            return videoPlayer.getFullWindowPlayer();
        }
        return videoPlayer;
    }

    @Override
    public void onBackPressed() {
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }
        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        videoPlayer.getCurrentPlayer().onVideoPause();
//        getCurPlay().onVideoPause();
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        videoPlayer.getCurrentPlayer().onVideoResume(false);
//        getCurPlay().onVideoResume(false);
        super.onResume();
        isPause = false;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(videoPlayer != null){
            if (isPlay) {
                videoPlayer.getCurrentPlayer().release();
    //            getCurPlay().release();
            }
            if (orientationUtils!=null) {
                orientationUtils.releaseListener();
            }
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (isPlay&&!isPause) {
            videoPlayer.onConfigurationChanged(this,newConfig,orientationUtils,true,true);
        }
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mSid = intent.getIntExtra("sid", 18);
        mName = intent.getStringExtra("name");
        LogUtils.d(this,"sid --> " + mSid + " name --> " + mName);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.teachVideo_container, new TeachVideoDetailFragment())
                .commit();
        orientationUtils = new OrientationUtils(this, videoPlayer);
        orientationUtils.setEnable(false);
    }

    @Override
    protected void initEvent() {
        super.initEvent();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_teachvideo;
    }

    @Override
    public void showItem(TeachVideoData bean) {
//        LogUtils.d(this, "data --> " + bean);
        initVideo(bean.getVideo(), bean.getCid());
        videoPlayer.getTitleTextView().setText(bean.getTitle());
        videoPlayer.getTitleTextView().setMaxLines(1);
        videoPlayer.getTitleTextView().setTextSize(12);
        videoPlayer.getTitleTextView().setEllipsize(TextUtils.TruncateAt.END);
        videoPlayer.getTitleTextView().setPadding(0,0,5,0);
    }
}
