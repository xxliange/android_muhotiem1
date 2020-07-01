package com.example.muhoitem1.ui.activity.VideoActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.ui.fragment.VideoFragment.VideoListFragment;

import butterknife.BindView;

public class VideoListActivity extends BaseActivity {
//    @BindView(R.id.tool_back_title)
//    public TextView toolTitle;
//    @BindView(R.id.back_toolbar)
//    public ImageView back;
    @Override
    protected void initPresent() {

    }

    @Override
    protected void initView() {
//        toolTitle.setText("视频列表");
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.white));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.teachList_container, new VideoListFragment())
                .commit();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_video_list;
    }

    @Override
    protected void initEvent() {
//        back.setOnClickListener(v -> {
//            finish();
//        });
    }
}
