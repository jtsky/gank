package com.jin.gank.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jin.gank.R;
import com.jin.gank.data.Constant;
import com.jin.gank.data.GankCategory;
import com.jin.gank.network.RetrofitHelp;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
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
public class MyFragment extends Fragment {
    private static final String TAG = "MyFragment";
    @Bind(R.id.progressActivity)
    ProgressActivity mProgressActivity;
    @Bind(R.id.tv)
    TextView mTv;


    private List<GankCategory.ResultsEntity> mResults;
    private String[] mCategoryArray = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategoryArray = getResources().getStringArray(R.array.category_list);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());


        if (mResults == null || mResults.size() == 0) {
            mProgressActivity.showLoading();
            RetrofitHelp.getApi().listGankCategory(mCategoryArray[position], Constant.API_COUNT, -1)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(gank -> {
                        mResults = gank.getResults();
                        return Observable.just(mResults);
                    })
                    .subscribe(listGank -> {
                        mProgressActivity.showContent();
                        mTv.setText(mResults.get(0).getType());
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
        container = (ViewGroup) inflater.inflate(R.layout.fragment_category, null, false);
        ButterKnife.bind(this, container);
        return container;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
