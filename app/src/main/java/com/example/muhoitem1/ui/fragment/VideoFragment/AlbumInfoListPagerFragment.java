package com.example.muhoitem1.ui.fragment.VideoFragment;

import android.view.View;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;

public class AlbumInfoListPagerFragment extends BaseFragment {

    public static AlbumInfoListPagerFragment newInstance(){
        return new AlbumInfoListPagerFragment();
    }
    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_album_info_list_pager;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
    }
}
