package com.example.muhoitem1.ui.activity.mineActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.utils.ToastUtils;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {
    public ImageView back;
    @Override
    protected void initView() {
        back = findViewById(R.id.login_backTool).findViewById(R.id.back_toolbar);
        back.setOnClickListener(v -> {
            finish();
        });
        // TODO:
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }
}
