package com.example.muhoitem1.ui.fragment;

import android.view.View;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;

public class HomejiduFragment extends BaseFragment {
    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_homejidu;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
    }
}
