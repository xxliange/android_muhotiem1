package com.example.muhoitem1.ui.activity.mineActivity;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tool_title)
    public TextView toolTitle;
    public ImageView back;
    @Override
    protected void initView() {
        back = findViewById(R.id.login_backTool).findViewById(R.id.back_toolbar);
        back.setOnClickListener(v -> {
            finish();
        });
        // TODO:
        toolTitle.setText("密码登陆");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }
}
