package com.jin.gank;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.DecelerateInterpolator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/8/27.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Bind(R.id.AppBarLayout)
    AppBarLayout mAppBarLayout;
    @Bind(R.id.common_toolbar)
    Toolbar mToolbar;

    protected boolean mIsHiddenToolBar = false;

    abstract protected int provideContentViewId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());
        ButterKnife.bind(this);
        setToolBar();
    }

    public void setToolBar() {
        if (null != mToolbar) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(false);//决定左上角的图标是否可以点击
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);//给左上角图标的左边加上一个返回的图标
            mToolbar.setTitle(R.string.app_name);
        }
    }


    protected void setAppBar(float alpha) {
        getSupportActionBar().setHomeButtonEnabled(true);//决定左上角的图标是否可以点击
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//给左上角图标的左边加上一个返回的图标
        mAppBarLayout.setAlpha(alpha);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }

    protected void hideOrShowToolbar() {
        mAppBarLayout.animate()
                .translationY(mIsHiddenToolBar ? 0 : -mAppBarLayout.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();

        mIsHiddenToolBar = !mIsHiddenToolBar;
    }


}
