package com.example.muhoitem1.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.MineData.MineLoginData;
import com.example.muhoitem1.ui.activity.publicActivity.DialogActivity;
import com.example.muhoitem1.ui.activity.testActivity.TestActivity;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.MuhoCache;
import com.example.muhoitem1.utils.Utils;

import butterknife.BindView;

public class MineFragment extends BaseFragment {

//    @BindView(R.id.tool_title)
//    public TextView toolTitle;
    @BindView(R.id.item_mine_loginBtn)
    public TextView loginBtn;
    @BindView(R.id.mine_avatar)
    public ImageView avatar;
    @BindView(R.id.mine_nick)
    public TextView userNick;
    @BindView(R.id.login_exitBtn)
    public LinearLayout exitBtn;
    @BindView(R.id.mine_userContainer)
    public LinearLayout mine_userContainer;
    public TextView item_mine_vipPayTitle;
    public TextView item_mine_historyTitle;
    public TextView item_mine_collectTitle;
    public TextView item_mine_subscriptionTitle;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View rootView) {
        mine_userContainer.setPadding(0, Utils.getStatusBarHeight(getContext()),0,0);
        setUpState(State.SUCCESS);
        item_mine_vipPayTitle = rootView.findViewById(R.id.item_mine_vipPay).findViewById(R.id.item_mine_common_title);
        item_mine_historyTitle = rootView.findViewById(R.id.item_mine_history).findViewById(R.id.item_mine_common_title);
        item_mine_collectTitle = rootView.findViewById(R.id.item_mine_collect).findViewById(R.id.item_mine_common_title);
        item_mine_subscriptionTitle = rootView.findViewById(R.id.item_mine_subscription).findViewById(R.id.item_mine_common_title);

        item_mine_vipPayTitle.setText("会员购买");
        item_mine_historyTitle.setText("我的历史");
        item_mine_collectTitle.setText("我的收藏");
        item_mine_subscriptionTitle.setText("我的订阅");

        getUserInfo();

    }

    private void getUserInfo() {
        MineLoginData userData = MuhoCache.getInstance().get("userData", MineLoginData.class);
        if (userData != null) {
            if (userData.getMessage() != null) {
                String avatar = userData.getData().getAvatar();
                String nickname = userData.getData().getNickname();
                LogUtils.d(this, "userData --> " + userData.getStateCode());
                Glide.with(this).load(avatar).apply(RequestOptions.circleCropTransform()).into(this.avatar);
                userNick.setText(nickname);
                exitBtn.setVisibility(View.VISIBLE);
                loginBtn.setVisibility(View.GONE);
            } else {
                exitBtn.setVisibility(View.GONE);
                loginBtn.setVisibility(View.VISIBLE);
            }
        } else {
            exitBtn.setVisibility(View.GONE);
            loginBtn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initListener() {
        exitBtn.setOnClickListener(v -> {
            final DialogActivity dialog = new DialogActivity(getContext());
            dialog.setMessage("确认退出登陆嘛?");
            dialog.setOnClickBottomListener(new DialogActivity.OnClickBottomListener() {
                @Override
                public void onOK() {
                    MuhoCache.getInstance().put("userData", null);
                    exitBtn.setVisibility(View.GONE);
                    loginBtn.setVisibility(View.VISIBLE);
                    userNick.setText("登陆");
                    Glide.with(MineFragment.this).load(R.drawable.mine_unlogin_avatar).into(MineFragment.this.avatar);
                    dialog.dismiss();
                }
                @Override
                public void onCancle() {
                    dialog.dismiss();
                }
            });
            dialog.show();
        });
        loginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), TestActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void release() {
        super.release();
    }
}
