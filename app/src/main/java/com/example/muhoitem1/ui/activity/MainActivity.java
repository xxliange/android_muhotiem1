package com.example.muhoitem1.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.network.NetWorkManager;
import com.example.muhoitem1.ui.fragment.HomeFragment;
import com.example.muhoitem1.ui.fragment.HotListFragment;
import com.example.muhoitem1.ui.fragment.MineFragment;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.MuhoCache;
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

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(android.R.color.white));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragment();
        initListener();
        initCache();
        NetWorkManager.getInstance().init();
        switchFragment(mHomeFragment);
//        switchFragment(mMineFragment);
    }

    private void initCache() {
        MuhoCache.getInstance().init(getApplicationContext());
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
