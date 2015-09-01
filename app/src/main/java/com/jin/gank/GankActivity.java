package com.jin.gank;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.jin.gank.data.Constant;
import com.jin.gank.fragment.GankFragment;
import com.jin.gank.util.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;


public class GankActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private static final String TAG = "GankActivity";
    public static final String EXTRA_GANK_DATE = "gank_date";

    @Bind(R.id.pager)
    ViewPager mViewPager;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;

    GankPagerAdapter mPagerAdapter;
    Date mGankDate;

    @Override protected int provideContentViewId() {
        return R.layout.activity_gank;
    }



    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mGankDate = fmt.parse(getIntent().getStringExtra(EXTRA_GANK_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setTitle(DateUtils.toDate(mGankDate));
        setAppBar(1.0f);
        initViewPager();
        initTabLayout();
    }

    private void initViewPager() {
        mPagerAdapter = new GankPagerAdapter(getSupportFragmentManager(), mGankDate);
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

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) { hideOrShowToolbar(); }
        else { hideOrShowToolbar(); }
    }

    @Override protected void hideOrShowToolbar() {
        View toolbar = findViewById(R.id.toolbar_with_indicator);
        toolbar.animate()
            .translationY(mIsHiddenToolBar ? 0 : -mToolbar.getHeight())
            .setInterpolator(new DecelerateInterpolator(2))
            .start();
        mIsHiddenToolBar = !mIsHiddenToolBar;
        if (mIsHiddenToolBar) {
            mViewPager.setTag(mViewPager.getPaddingTop());
            mViewPager.setPadding(0, 0, 0, 0);
        }
        else {
            mViewPager.setPadding(0, (int) mViewPager.getTag(), 0, 0);
            mViewPager.setTag(null);
        }
    }

    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
       /* switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
            case KeyEvent.KEYCODE_BACK:
                if (getResources().getConfiguration().orientation
                    == Configuration.ORIENTATION_LANDSCAPE) {
                    LoveBus.getLovelySeat().post(new OnKeyBackClickEvent());
                    return true;
                }
        }*/
        return super.onKeyDown(keyCode, event);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:
               // startActivity(new Intent(this, AboutActivity.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



    @Override protected void onDestroy() {
        mViewPager.removeOnPageChangeListener(this);
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override public void onPageSelected(int position) {
        setTitle(DateUtils.toDate(mGankDate, -position));
    }

    @Override public void onPageScrollStateChanged(int state) {

    }

    public class GankPagerAdapter extends FragmentPagerAdapter {
        Date mDate;

        public GankPagerAdapter(FragmentManager fm, Date date) {
            super(fm);
            mDate = date;
        }

        @Override public Fragment getItem(int position) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(mDate);
            calendar.add(Calendar.DATE, -position);
            Log.i(TAG,"" + calendar.get(Calendar.DAY_OF_MONTH));
            return GankFragment.newInstance(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        }

        @Override public int getCount() {
            return Constant.VIEWPAGE_COUNT;
        }
    }
}
