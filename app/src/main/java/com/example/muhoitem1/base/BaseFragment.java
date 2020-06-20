package com.example.muhoitem1.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.muhoitem1.R;
import com.example.muhoitem1.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private State currentState = State.NONE;
    private View mLoadingView;
    private View mSuccessView;
    private View mLoadErrorView;
    private View mLoadEmptyView;

    public enum State {
        NONE, LOADING, SUCCESS, ERROR, EMPTY
    }

    private Unbinder mBind;
    private FrameLayout mBaseContainer;

    @OnClick(R.id.network_error_tips)
    public void retry(){
        //点击了重新加载内容
        LogUtils.d(this,"on retry");
        onRetryClick();
    }

    /**
     * 如果子类需要知道网络错误以后的点击，那覆盖方法即可
     */
    protected void onRetryClick() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = loadRootView(inflater,container);
        mBaseContainer = rootView.findViewById(R.id.base_container);
        loadStatesView(inflater, container);
        mBind = ButterKnife.bind(this, rootView);
        initView(rootView);
        initListener();
        initPresenter();
        loadData();
        return rootView;
    }

    protected void initListener() {

    }

    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_fragment_layout,container,false);
    }

    /**
     * 加载各种状态的view
     *
     * @param inflater
     * @param container
     */
    private void loadStatesView(LayoutInflater inflater, ViewGroup container) {
        //成功的view
        mSuccessView = loadSuccessView(inflater, container);
        mBaseContainer.addView(mSuccessView);

        //Loading的view
        mLoadingView = loadLoadingView(inflater, container);
        mBaseContainer.addView(mLoadingView);

        //error的view
        mLoadErrorView = loadErrorView(inflater, container);
        mBaseContainer.addView(mLoadErrorView);

        //empty的view
        mLoadEmptyView = loadEmptyView(inflater, container);
        mBaseContainer.addView(mLoadEmptyView);
        setUpState(State.NONE);
    }

    /**
     * 子类通过这个方法来切换状态页面
     * @param state
     */
    public void setUpState(State state) {
        this.currentState = state;
        mSuccessView.setVisibility(currentState == State.SUCCESS ? View.VISIBLE : View.GONE);
        mLoadingView.setVisibility(currentState == State.LOADING ? View.VISIBLE : View.GONE);
        mLoadErrorView.setVisibility(currentState == State.ERROR ? View.VISIBLE : View.GONE);
        mLoadEmptyView.setVisibility(currentState == State.EMPTY ? View.VISIBLE : View.GONE);
    }


    /**
     * 加载成功的页面
     *
     * @param inflater
     * @param container
     * @return
     */
    protected View loadSuccessView(LayoutInflater inflater, ViewGroup container) {
        int resId = getRootViewResId();
        return inflater.inflate(resId, container, false);
    }

    /**
     * 加载loading界面
     *
     * @param inflater
     * @param container
     * @return
     */
    protected View loadLoadingView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_loading, container, false);
    }

    /**
     * 加载网络错误的页面
     *
     * @param inflater
     * @param container
     * @return
     */
    protected View loadErrorView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_error, container, false);
    }

    /**
     * 加载内容为空的页面
     *
     * @param inflater
     * @param container
     * @return
     */
    protected View loadEmptyView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_empty, container, false);
    }

    protected void initView(View rootView) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mBind != null) {
            mBind.unbind();
        }
        release();
    }

    protected void release() {
        //释放资源
    }

    protected void initPresenter() {
        //创建presenter
    }

    protected void loadData() {
        //加载数据
    }

    protected abstract int getRootViewResId();

}
