package com.example.muhoitem1.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;

public class StarVipDetailFragment extends BaseFragment {

    public static StarVipDetailFragment newInstance(){
        StarVipDetailFragment starVipDetailFragment = new StarVipDetailFragment();
        Bundle bundle = new Bundle();
        starVipDetailFragment.setArguments(bundle);
        return starVipDetailFragment;
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_staripdetail;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
    }
}
