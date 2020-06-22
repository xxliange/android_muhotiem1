package com.example.muhoitem1.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.ui.activity.HotDetailActivity;
import com.example.muhoitem1.ui.activity.mineActivity.LoginActivity;

import org.w3c.dom.Text;

import java.util.Objects;

import butterknife.BindView;

public class MineFragment extends BaseFragment {

    @BindView(R.id.tool_title)
    public TextView toolTitle;
    @BindView(R.id.item_mine_loginBtn)
    public TextView loginBtn;
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

        setUpState(State.SUCCESS);
        toolTitle.setText(Objects.requireNonNull(getContext()).getString(R.string.text_mine));
        item_mine_vipPayTitle = rootView.findViewById(R.id.item_mine_vipPay).findViewById(R.id.item_mine_common_title);
        item_mine_historyTitle = rootView.findViewById(R.id.item_mine_history).findViewById(R.id.item_mine_common_title);
        item_mine_collectTitle = rootView.findViewById(R.id.item_mine_collect).findViewById(R.id.item_mine_common_title);
        item_mine_subscriptionTitle = rootView.findViewById(R.id.item_mine_subscription).findViewById(R.id.item_mine_common_title);

        item_mine_vipPayTitle.setText("会员购买");
        item_mine_historyTitle.setText("我的历史");
        item_mine_collectTitle.setText("我的收藏");
        item_mine_subscriptionTitle.setText("我的订阅");
    }

    @Override
    protected void initListener() {
        loginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void release() {
        super.release();
    }
}
