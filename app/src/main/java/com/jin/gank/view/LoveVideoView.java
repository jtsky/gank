package com.jin.gank.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * It's a lovely adult video view.
 * Created by drakeet on 8/14/15.
 */
public class LoveVideoView extends WebView {

    public LoveVideoView(Context context) {
        this(context, null);
    }

    public LoveVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoveVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        setWebViewClient(new LoveClient());
        WebSettings webSettings = getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSaveFormData(false);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setLoadWithOverviewMode(false);
        webSettings.setUseWideViewPort(true);
    }

    private class LoveClient extends WebViewClient {

        @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
