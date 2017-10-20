package com.zhoumushui.website;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private WebView webView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialLayout();
    }

    private int urlIndex = 0;

    private void initialLayout() {
        webView = findViewById(R.id.webView);
        loadUrl(webView, Constant.URL.INDEX);

        final ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(Constant.URL.INDEX);
        arrayList.add(Constant.URL.ESSAY);
        arrayList.add(Constant.URL.MOVIE);
        arrayList.add(Constant.URL.DREAM);
        arrayList.add(Constant.URL.NOVEL);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (urlIndex >= 0 && urlIndex < arrayList.size()) {
                } else {
                    urlIndex = 0;
                }
                loadUrl(webView, arrayList.get(urlIndex));
                urlIndex++;
            }
        });


    }


    /**
     * 加载网页
     *
     * @param webView
     * @param url
     */
    private void loadUrl(WebView webView, String url) {
        webView.loadUrl(url);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); //启用支持javascript
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 启用缓存
        // settings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 不使用缓存
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) { // 网页加载完成

                } else { // 加载中

                }

            }
        });
    }
}
