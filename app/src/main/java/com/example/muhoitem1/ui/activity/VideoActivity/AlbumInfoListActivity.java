package com.example.muhoitem1.ui.activity.VideoActivity;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.ui.fragment.VideoFragment.AlbumInfoListFragment;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class AlbumInfoListActivity extends BaseActivity  {
    @BindView(R.id.thumb_info_list_player)
    public StandardGSYVideoPlayer mPlayer;
    @Override
    protected void initPresent() {

    }

    @Override
    protected void initView() {
        setTransparentStatusBar();
        initVideo();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.album_info_list_container,new AlbumInfoListFragment())
                .commit();
    }

    private void initVideo() {
        String url = "https://m.muho.tv/bXVob1RW_1594268354.MP4";
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
                .setMapHeadData(header)
                .setCacheWithPlay(false)
                .setVideoAllCallBack(new GSYSampleCallBack(){
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                    }
                }).build(mPlayer);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_album_info_list;
    }
}
