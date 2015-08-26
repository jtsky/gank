package com.jin.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jin.gank.R;
import com.jin.gank.animators.OvershootInLeftAnimator;
import com.jin.gank.data.Constant;
import com.jin.gank.data.GankCategory;
import com.jin.gank.decoration.DividerGridItemDecoration;
import com.jin.gank.network.RetrofitHelp;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.vlonjatg.progressactivity.ProgressActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2015/8/25.
 */
public class MyImgFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {
    private static final String TAG = "MyImgFragment";
    @Bind(R.id.progressActivity)
    ProgressActivity mProgressActivity;
    @Bind(R.id.superRecyclerView_img)
    SuperRecyclerView mSuperRecyclerViewImg;


    private List<GankCategory.ResultsEntity> mResults;
    private String[] mCategoryArray = null;
    private LayoutInflater mInflater;
    private MyAdapter mAdapter;
    private int mScreenWidth, mScreenHeight;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategoryArray = getResources().getStringArray(R.array.category_list);
        mInflater = LayoutInflater.from(getActivity());
        //  获取Android获得屏幕的宽和高
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        mScreenWidth = (int) (dm.widthPixels * dm.density);
        mScreenHeight = (int) (dm.heightPixels * dm.density);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSuperRecyclerViewImg.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mSuperRecyclerViewImg.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        mSuperRecyclerViewImg.getRecyclerView().setItemAnimator(new OvershootInLeftAnimator());
        mSuperRecyclerViewImg.setRefreshListener(this);
        mSuperRecyclerViewImg.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);
        mSuperRecyclerViewImg.setupMoreListener(this, 10);


        if (mResults == null || mResults.size() == 0) {
            mProgressActivity.showLoading();
            RetrofitHelp.getApi().listGankCategory(mCategoryArray[0], Constant.API_COUNT, -1)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(gank -> {
                        mResults = gank.getResults();
                        return Observable.just(mResults);
                    })
                    .subscribe(listGank -> {
                        mProgressActivity.showContent();
                        mAdapter = new MyAdapter(mResults);
                        mSuperRecyclerViewImg.setAdapter(mAdapter);
                    }, err -> {
                        Log.e(TAG, "err=====>" + err.toString());
                        mProgressActivity.showError(null, "错误", err.toString(), "重试", null);
                    });
        } else {

        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.fragment_img, null, false);
        ButterKnife.bind(this, container);
        return container;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onMoreAsked(int i, int i1, int i2) {

    }

    @Override
    public void onRefresh() {

    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private List<GankCategory.ResultsEntity> resultsEntities;

        public MyAdapter(List<GankCategory.ResultsEntity> resultsEntities) {
            super();
            this.resultsEntities = resultsEntities;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View contentView = mInflater.inflate(R.layout.item_img, parent, false);
            MyViewHolder holder = new MyViewHolder(contentView);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mScreenWidth/2 - 1,300);
            holder.mImageView.setLayoutParams(params);
            Log.i(TAG,"W====>" + params.width + "  h=====>" + params.height);
            Glide.with(getActivity())
                    .load(resultsEntities.get(position).getUrl())
                    .override(params.width, params.height)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return resultsEntities.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView mImageView;

            public MyViewHolder(View convertView) {
                super(convertView);
                mImageView = (ImageView) convertView.findViewById(R.id.welfare_img);

            }
        }
    }


}
