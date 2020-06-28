package com.example.muhoitem1.ui.fragment.VideoFragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muhoitem1.R;
import com.example.muhoitem1.base.BaseFragment;
import com.example.muhoitem1.model.domain.VideoData.TeachVideoData;
import com.example.muhoitem1.presenter.ITeachVideoPresenter;
import com.example.muhoitem1.ui.adapter.VideoDetailListAdapter;
import com.example.muhoitem1.ui.adapter.VideoTagsAdapter;
import com.example.muhoitem1.utils.LogUtils;
import com.example.muhoitem1.utils.PresentManager;
import com.example.muhoitem1.view.ITeachVideoCallback;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class TeachVideoDetailFragment extends BaseFragment implements ITeachVideoCallback {

    @BindView(R.id.teachVideo_title)
    public TextView title;
    @BindView(R.id.teachVideo_name)
    public TextView name;
    @BindView(R.id.teachVideo_views)
    public TextView views;
    @BindView(R.id.teachVideo_tags_list)
    public RecyclerView tagsList;
    @BindView(R.id.teachVideo_detail_list)
    public RecyclerView detailList;
    private ITeachVideoPresenter mTeachVideoPresenter;
    private VideoTagsAdapter mVideoTagsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private VideoDetailListAdapter mVideoDetailListAdapter;


    @Override
    protected void initPresenter() {
        mTeachVideoPresenter = PresentManager.getInstance().getTeachVideoPresenter();
        if (mTeachVideoPresenter != null) {
            mTeachVideoPresenter.registerViewCallback(this);
        }
    }

    public interface TeachVideoDetailListener {
        void showItem(TeachVideoData bean);
    }

    private TeachVideoDetailListener listenter;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_teachvideodetail;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        listenter = (TeachVideoDetailListener) context;
        super.onAttach(context);
    }

    @Override
    protected void initView(View rootView) {

        setUpState(State.SUCCESS);
        setTagsAdapter();
        setDetailAdapter();
    }

    //设置标签列表适配器
    private void setTagsAdapter() {
        mLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        tagsList.setLayoutManager(mLinearLayoutManager);
        mVideoTagsAdapter = new VideoTagsAdapter();
        tagsList.setAdapter(mVideoTagsAdapter);
    }

    // 设置内容列表适配器
    private void setDetailAdapter() {
        mLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        detailList.setLayoutManager(mLinearLayoutManager);
        mVideoDetailListAdapter = new VideoDetailListAdapter();
        detailList.setAdapter(mVideoDetailListAdapter);
    }

    @Override
    protected void loadData() {
        mTeachVideoPresenter.getTeachVideoData();
    }

    /**
     * 获取视频信息
     *
     * @param data
     */
    @Override
    public void onShowTeachVideoInfo(List<TeachVideoData> data) {
        LogUtils.d(this, "data --> " + data.toString());
        title.setText(data.get(0).getTitle());
        name.setText(String.format("专辑名 : %s", data.get(0).getName()));
        views.setText(MessageFormat.format("播放量 : {0}", data.get(0).getView()));
        mVideoTagsAdapter.setData(splitTags(data.get(1).getTags()));
        mVideoDetailListAdapter.setData(data);
    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onEmpty() {

    }

    private List<String> splitTags(String s) {
        if (!TextUtils.isEmpty(s)) {
            String[] split = s.split(",");
            List<String> strings = Arrays.asList(split);
            return strings;
        } else {
            return null;
        }
    }
}
