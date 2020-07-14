package com.example.muhoitem1.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseActivity;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.network.NetWorkManager;
import com.example.muhoitem1.ui.fragment.HomeFragment;
import com.example.muhoitem1.ui.fragment.HomeTestFragment;
import com.example.muhoitem1.ui.fragment.HotListFragment;
import com.example.muhoitem1.ui.fragment.MineFragment;
import com.example.muhoitem1.ui.fragment.StarVipFragment;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.MuhoCache;
import com.example.muhoitem1.utils.StatusBarUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView mNavigationView;
    private HotListFragment mHotListFragment;
    private MineFragment mMineFragment;
    private HomeFragment mHomeFragment;
    private HomeTestFragment mHomeTestFragment;
    private FragmentManager mFm;
    private StarVipFragment mStarVipFragment;
    private Unbinder mBind;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        Window window = getWindow();
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(Color.TRANSPARENT);
//        super.onCreate(savedInstanceState);
////        requestWindowFeature(Window.FEATURE_NO_TITLE);
////        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_main);
//        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
////        StatusBarUtils.setRootViewFitsSystemWindows(this,true);
////        //设置状态栏透明
////        StatusBarUtils.setTranslucentStatus(this);
////        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
////        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
////        if (!StatusBarUtils.setStatusBarDarkTheme(this, true)) {
////            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
////            //这样半透明+白=灰, 状态栏的文字能看得清
////            StatusBarUtils.setStatusBarColor(this,0x55000000);
////        }
//        mBind = ButterKnife.bind(this);
//        initFragment();
//        initListener();
//        initCache();
//        NetWorkManager.getInstance().init();
//        switchFragment(mHomeTestFragment);
//    }

    @Override
    protected void initPresent() {

    }

    @Override
    protected void initView() {
        setTransparentStatusBar();
        mBind = ButterKnife.bind(this);
        initFragment();
        initListener();
        initCache();
        NetWorkManager.getInstance().init();
        switchFragment(mHomeTestFragment);
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

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mHotListFragment = new HotListFragment();
        mMineFragment = new MineFragment();
        mHomeTestFragment = new HomeTestFragment();
        mStarVipFragment = new StarVipFragment();
        mFm = getSupportFragmentManager();
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    LogUtils.i(this, "home");
                    switchFragment(mHomeTestFragment);
                } else if (item.getItemId() == R.id.hot) {
                    LogUtils.w(this, "hot");
                    switchFragment(mStarVipFragment);
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
