package com.example.muhoitem1.ui.activity.VideoActivity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.utils.LogUtils;

import butterknife.BindView;

public class TeachVideoActivity extends BaseActivity {
    @BindView(R.id.tool_title)
    public TextView toolTitle;
    @BindView(R.id.back_toolbar)
    public ImageView back;
    private int mSid;
    private String mName;

    @Override
    protected void initPresent() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mSid = intent.getIntExtra("sid", 1);
        mName = intent.getStringExtra("name");
        LogUtils.d(this,"sid --> " + mSid + " name --> " + mName);
        toolTitle.setText("普通教学");
        back.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_teachvideo;
    }
}
