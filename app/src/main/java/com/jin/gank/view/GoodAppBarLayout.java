package com.jin.gank.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;

/**
 * A good boy! AppBarLayout is bad boy!
 * Created by drakeet on 8/11/15.
 */
public class GoodAppBarLayout extends AppBarLayout {

    public int offset;
    OnOffsetChangedListener mOnOffsetChangedListener;

    public GoodAppBarLayout(Context context) {
        this(context, null);
    }

    public GoodAppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void notifyRemoveOffsetListener() {
        this.removeOnOffsetChangedListener(mOnOffsetChangedListener);
    }

    public void notifyAddOffsetListener() {
        this.addOnOffsetChangedListener(mOnOffsetChangedListener);
    }
}
