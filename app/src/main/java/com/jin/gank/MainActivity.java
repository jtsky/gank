package com.jin.gank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jin.gank.data.Constant;
import com.jin.gank.network.RetrofitHelp;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Bind(R.id.tv)
    TextView mTv;
    @Bind(R.id.im)
    ImageView mIm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RetrofitHelp.getApi().listGankCategory(Constant.API_VIDEO,10, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(gank -> Observable.just(gank.getResults()))
                .subscribe(listGank -> {
                    mTv.setText(listGank.get(0).getType());
                    Glide.with(MainActivity.this).load(listGank.get(0).getUrl()).into(mIm);
                }, err -> Log.e(TAG, "err=====>" + err.toString()));

    }


}
