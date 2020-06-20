package com.example.muhoitem1.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.ui.fragment.HomeFragment;
import com.example.muhoitem1.ui.fragment.HotListFragment;
import com.example.muhoitem1.ui.fragment.MineFragment;
import com.example.muhoitem1.utils.LogUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView mNavigationView;
    private HotListFragment mHotListFragment;
    private MineFragment mMineFragment;
    private HomeFragment mHomeFragment;
    private FragmentManager mFm;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragment();
        initListener();
        switchFragment(mHomeFragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mHotListFragment = new HotListFragment();
        mMineFragment = new MineFragment();
        mFm = getSupportFragmentManager();
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    LogUtils.i(this, "home");
                    switchFragment(mHomeFragment);
                } else if (item.getItemId() == R.id.hot) {
                    LogUtils.w(this, "hot");
                    switchFragment(mHotListFragment);
                } else if (item.getItemId() == R.id.mine) {
                    LogUtils.e(this, "mine");
                    switchFragment(mMineFragment);
                }
                return true;
            }
        });
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentTransaction fragmentTransaction = mFm.beginTransaction();
        fragmentTransaction.replace(R.id.main_page_container, targetFragment);
        fragmentTransaction.commit();

    }
}
