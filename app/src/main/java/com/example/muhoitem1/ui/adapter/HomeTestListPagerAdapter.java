package com.example.muhoitem1.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.muhoitem1.ui.fragment.HomeDayUpdateFragment;
import com.example.muhoitem1.ui.fragment.HomeFragment;
import com.example.muhoitem1.ui.fragment.HomejiduFragment;
import com.example.muhoitem1.ui.fragment.HomejiqiaoFragment;
import com.example.muhoitem1.ui.fragment.HomeyanjiusuoFragment;
import com.example.muhoitem1.ui.fragment.HotListFragment;
import com.example.muhoitem1.ui.fragment.VideoFragment.HomeJiDuFragment;
import com.example.muhoitem1.utils.LogUtils;

public class HomeTestListPagerAdapter extends FragmentStateAdapter {
    public HomeTestListPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new HotListFragment();
            case 2:
                return new HomejiduFragment();
            case 3:
                return new HomejiqiaoFragment();
            case 4:
                return new HomeyanjiusuoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
