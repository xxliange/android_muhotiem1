package com.example.muhoitem1.ui.activity.VideoActivity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.model.domain.VideoData.TeachVideoData;
import com.example.muhoitem1.presenter.ITeachVideoPresenter;
import com.example.muhoitem1.ui.fragment.VideoFragment.TeachVideoDetailFragment;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.view.ITeachVideoCallback;

import butterknife.BindView;

/**
 * 普通教学视频详情页
 */
public class TeachVideoActivity extends BaseActivity implements TeachVideoDetailFragment.TeachVideoDetailListener {
    @BindView(R.id.tool_title)
    public TextView toolTitle;
    @BindView(R.id.back_toolbar)
    public ImageView back;
    private int mSid;
    private String mName;

    @Override
    protected void loadData() {
    }

    @Override
    protected void initPresent() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mSid = intent.getIntExtra("sid", 18);
        mName = intent.getStringExtra("name");
        LogUtils.d(this,"sid --> " + mSid + " name --> " + mName);
        toolTitle.setText("普通教学");
        back.setOnClickListener(v -> {
            finish();
        });
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.teachVideo_container, new TeachVideoDetailFragment())
                .commit();
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

    }
}
