package com.jin.gank.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.bumptech.glide.Glide;
import com.jin.gank.R;
import com.jin.gank.WebActivity;
import com.jin.gank.adapter.GankListAdapter;
import com.jin.gank.data.GankCategory;
import com.jin.gank.data.GankDay;
import com.jin.gank.network.RetrofitHelp;
import com.jin.gank.util.LoveStringUtils;
import com.jin.gank.util.Once;
import com.jin.gank.util.ShareUtils;
import com.jin.gank.util.ToastUtils;
import com.jin.gank.view.GoodAppBarLayout;
import com.jin.gank.view.LoveVideoView;
import com.jin.gank.view.VideoImageView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;


public class GankFragment extends Fragment {

    private final String TAG = "GankFragment";
    private static final String ARG_YEAR = "year";
    private static final String ARG_MONTH = "month";
    private static final String ARG_DAY = "day";

    @Bind(R.id.rv_gank)
    RecyclerView mRecyclerView;
    @Bind(R.id.stub_empty_view)
    ViewStub mEmptyViewStub;
    @Bind(R.id.stub_video_view)
    ViewStub mVideoViewStub;
    @Bind(R.id.iv_video)
    VideoImageView mVideoImageView;
    @Bind(R.id.header_appbar)
    GoodAppBarLayout mAppBarLayout;
    @Bind(R.id.cl_content)
    CoordinatorLayout mLayout;
    LoveVideoView mVideoView;

    int mYear, mMonth, mDay;
    List<GankCategory.ResultsEntity> mGankList;
    String mVideoPreviewUrl;
    boolean mIsVideoViewInflated = false;
    Subscription mSubscription;
    GankListAdapter mAdapter;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static GankFragment newInstance(int year, int month, int day) {
        GankFragment fragment = new GankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_YEAR, year);
        args.putInt(ARG_MONTH, month);
        args.putInt(ARG_DAY, day);
        fragment.setArguments(args);
        return fragment;
    }

    public GankFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGankList = new ArrayList<>();
        mAdapter = new GankListAdapter(mGankList);
        parseArguments();
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    private void parseArguments() {
        Bundle bundle = getArguments();
        mYear = bundle.getInt(ARG_YEAR);
        mMonth = bundle.getInt(ARG_MONTH);
        mDay = bundle.getInt(ARG_DAY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gank, container, false);
        ButterKnife.bind(this, rootView);
        initRecyclerView();
        setVideoViewPosition(getResources().getConfiguration());
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mGankList.size() == 0) getData();
        if (mVideoPreviewUrl != null) {
            Glide.with(this).load(mVideoPreviewUrl).into(mVideoImageView);
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getData() {
        getAndParseVideoPreview();
        mSubscription = RetrofitHelp.getApi().listGankDay(mYear, mMonth, mDay)
                .observeOn(AndroidSchedulers.mainThread())
                .map(data -> data.getResults())
                .map(this::addAllResults)
                .subscribe(list -> {
                    if (list.isEmpty()) {
                        showEmptyView();
                    } else {
                        mAdapter.notifyDataSetChanged();
                    }
                }, Throwable::printStackTrace);
    }

    private void getAndParseVideoPreview() {
        OkHttpClient client = new OkHttpClient();
        String url = getString(R.string.url_gank_io) + String.format("%s/%s/%s", mYear, mMonth, mDay);
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                ToastUtils.showShort(e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String body = response.body().string();
                mVideoPreviewUrl = LoveStringUtils.getVideoPreviewImageUrl(body);
                if (mVideoPreviewUrl != null && mVideoImageView != null) {
                    mVideoImageView.post(() -> Glide.with(mVideoImageView.getContext())
                            .load(mVideoPreviewUrl)
                            .into(mVideoImageView));
                }
            }
        });
    }

    private void showEmptyView() {
        mEmptyViewStub.inflate();
    }

    private List<GankCategory.ResultsEntity> addAllResults(GankDay.ResultsEntity results) {
        if (results.getAndroid() != null) mGankList.addAll(results.getAndroid());
        if (results.getIOS() != null) mGankList.addAll(results.getIOS());
        if (results.get拓展资源() != null) mGankList.addAll(results.get拓展资源());
        if (results.get瞎推荐() != null) mGankList.addAll(results.get瞎推荐());
        if (results.get休息视频() != null) mGankList.addAll(0, results.get休息视频());
        return mGankList;
    }

    @OnClick(R.id.header_appbar)
    void onPlayVideo() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    private void setVideoViewPosition(Configuration newConfig) {
        switch (newConfig.orientation) {
            case Configuration.ORIENTATION_LANDSCAPE: {
                if (mIsVideoViewInflated) {
                    mVideoViewStub.setVisibility(View.VISIBLE);
                } else {
                    mVideoView = (LoveVideoView) mVideoViewStub.inflate();
                    mIsVideoViewInflated = true;
                    String tip = getString(R.string.tip_video_play);
                    new Once(mVideoView.getContext()).show(tip, () -> ToastUtils.showLongLongLong(tip));
                }
                if (mGankList.size() > 0 && mGankList.get(0).getType().equals("休息视频")) {
                    mVideoView.loadUrl(mGankList.get(0).getUrl());
                }
                break;
            }
            case Configuration.ORIENTATION_PORTRAIT:
            case Configuration.ORIENTATION_UNDEFINED:
            default: {
                mVideoViewStub.setVisibility(View.GONE);
                break;
            }
        }
    }

    void closePlayer() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ToastUtils.showShort(getString(R.string.daimajia_has_gone));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        setVideoViewPosition(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    /*@Subscribe public void onKeyBackClick(OnKeyBackClickEvent event) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_share:
                if (mGankList.size() != 0) {
                    GankCategory.ResultsEntity gank = mGankList.get(0);
                    String shareText = gank.getDesc() + gank.getUrl() + getString(R.string.share_from);
                    ShareUtils.share(getActivity(), shareText);
                } else {
                    ShareUtils.share(getActivity());
                }
                return true;

            case R.id.action_subject:
                openTodaySubject();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openTodaySubject() {
        String url = getString(R.string.url_gank_io) + String.format("%s/%s/%s", mYear, mMonth, mDay);
        Intent intent = new Intent(getActivity(), WebActivity.class);
        intent.putExtra(WebActivity.EXTRA_URL, url);
        intent.putExtra(WebActivity.EXTRA_TITLE, getString(R.string.action_subject));
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mVideoView != null) mVideoView.resumeTimers();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mVideoView != null) mVideoView.pauseTimers();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mSubscription != null) mSubscription.unsubscribe();
        if (mVideoView != null) mVideoView.destroy();
    }
}
