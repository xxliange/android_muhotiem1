package com.example.muhoitem1.ui.activity.mineActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.model.domain.MineData.MineLoginData;
import com.example.muhoitem1.presenter.IMineLoginPresenter;
import com.example.muhoitem1.ui.activity.MainActivity;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.MuhoCache;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.utils.ToastUtils;
import com.example.muhoitem1.view.IMineLoginCallback;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener, IMineLoginCallback {
    @BindView(R.id.tool_title)
    public TextView toolTitle;
    @BindView(R.id.login_btn)
    public TextView loginBtn;
    @BindView(R.id.login_userName)
    public EditText user;
    @BindView(R.id.login_pass)
    public EditText pass;
    public ImageView back;
    private IMineLoginPresenter mMineLoginPresenter;

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
    protected void initPresent() {
        mMineLoginPresenter = PresentManager.getInstance().getMineLoginPresenter();
        if (mMineLoginPresenter != null) {
            mMineLoginPresenter.registerViewCallback(this);
        }
    }

    @Override
    protected void initEvent() {
        loginBtn.setOnClickListener(this);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(user.getText().toString()) && !TextUtils.isEmpty(pass.getText().toString())) {
                    loginBtn.setSelected(true);
                    loginBtn.setTextColor(Color.BLACK);
                } else {
                    loginBtn.setSelected(false);
                    loginBtn.setTextColor(getColor(R.color.colorGrey));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                if (!TextUtils.isEmpty(user.getText().toString()) && !TextUtils.isEmpty(pass.getText().toString())) {
                    ToastUtils.showToast("登陆");
                    user.clearFocus();
                    pass.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(getApplication().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pass.getWindowToken(), 0);
                    mMineLoginPresenter.userLogin(user.getText().toString(), pass.getText().toString());
                } else {
                    ToastUtils.showToast("账号和密码不能为空");
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void release() {
        if (mMineLoginPresenter != null) {
            mMineLoginPresenter.unregisterViewCallback(this);
        }
    }

    @Override
    public void onNetworkError() {
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onSuccessLogin(MineLoginData userData) {
        LogUtils.d(this,"data --> " + userData);
        MuhoCache.getInstance().put("userData",userData);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
