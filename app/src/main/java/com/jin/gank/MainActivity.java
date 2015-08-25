package com.jin.gank;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jin.gank.data.Constant;
import com.jin.gank.fragment.MyFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Bind(R.id.common_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.smartTabLayout)
    SmartTabLayout mSmartTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (null != mToolbar) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(false);//决定左上角的图标是否可以点击
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);//给左上角图标的左边加上一个返回的图标
            mToolbar.setTitle(R.string.app_name);
        }


        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(Constant.API_ALL, MyFragment.class)
                .add(Constant.API_ANDROID, MyFragment.class)
                .add(Constant.API_IOS, MyFragment.class)
                .add(Constant.API_WELFARE, MyFragment.class)
                .add(Constant.API_FRONT, MyFragment.class)
                .add(Constant.API_VIDEO, MyFragment.class)
                .add(Constant.API_RESOURCE, MyFragment.class)
                .create());
        mViewpager.setAdapter(adapter);
        mSmartTabLayout.setViewPager(mViewpager);



        /*RetrofitHelp.getApi().listGankCategory(Constant.API_VIDEO,10, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(gank -> Observable.just(gank.getResults()))
                .subscribe(listGank -> {
                    mTv.setText(listGank.get(0).getType());
                    Glide.with(MainActivity.this).load(listGank.get(0).getUrl()).into(mIm);
                }, err -> Log.e(TAG, "err=====>" + err.toString()));*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {

            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


}
