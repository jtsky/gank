package com.jin.gank;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.jin.gank.fragment.GankFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class GankActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private static final String TAG = "GankActivity";
    public static final String EXTRA_GANK_DATA = "gank_data";

    @Bind(R.id.pager)
    ViewPager mViewPager;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    GankPagerAdapter mPagerAdapter;
    List<String> mDates;


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_gank;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mDates = getIntent().getStringArrayListExtra(EXTRA_GANK_DATA);

        setTitle(mDates.get(0));
        setAppBar(1.0f);
        initViewPager();
        initTabLayout();
    }

    private void initViewPager() {
        mPagerAdapter = new GankPagerAdapter(getSupportFragmentManager(), mDates);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(5);//缓存ViewPager页面数
        mViewPager.addOnPageChangeListener(this);
    }

    private void initTabLayout() {
        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            mTabLayout.addTab(mTabLayout.newTab());
        }
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            hideOrShowToolbar();
        } else {
            hideOrShowToolbar();
        }
    }

    @Override
    protected void hideOrShowToolbar() {
        View toolbar = findViewById(R.id.toolbar_with_indicator);
        toolbar.animate()
                .translationY(mIsHiddenToolBar ? 0 : -mToolbar.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        mIsHiddenToolBar = !mIsHiddenToolBar;
        if (mIsHiddenToolBar) {
            mViewPager.setTag(mViewPager.getPaddingTop());
            mViewPager.setPadding(0, 0, 0, 0);
        } else {
            mViewPager.setPadding(0, (int) mViewPager.getTag(), 0, 0);
            mViewPager.setTag(null);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:
                // startActivity(new Intent(this, AboutActivity.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        mViewPager.removeOnPageChangeListener(this);
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTitle(mDates.get(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class GankPagerAdapter extends FragmentPagerAdapter {
        List<String> mDates;
        DateFormat dfm;

        public GankPagerAdapter(FragmentManager fm, List<String> dates) {
            super(fm);
            mDates = dates;
            dfm = new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public Fragment getItem(int position) {
            String[] date = mDates.get(position).split("-");
            return GankFragment.newInstance(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        }

        @Override
        public int getCount() {
            return mDates.size();
        }
    }
}
