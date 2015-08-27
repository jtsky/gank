package com.jin.gank;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jin.gank.fragment.MyFragment;
import com.jin.gank.fragment.MyImgFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private  String[] mCategoryArray = null;
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
        mCategoryArray = getResources().getStringArray(R.array.category_list);
        if (null != mToolbar) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(false);//决定左上角的图标是否可以点击
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);//给左上角图标的左边加上一个返回的图标
            mToolbar.setTitle(R.string.app_name);
        }


        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(mCategoryArray[0], MyImgFragment.class)
                .add(mCategoryArray[1], MyFragment.class)
                .add(mCategoryArray[2], MyFragment.class)
                .add(mCategoryArray[3], MyFragment.class)
                .add(mCategoryArray[4], MyFragment.class)
                .add(mCategoryArray[5], MyFragment.class)
                .add(mCategoryArray[6], MyFragment.class)
                .create());
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(adapter.getCount());//设置ViewPager缓存个数
        mSmartTabLayout.setViewPager(mViewpager);
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
