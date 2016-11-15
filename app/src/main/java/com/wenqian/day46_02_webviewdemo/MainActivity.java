package com.wenqian.day46_02_webviewdemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wenqian.entity.LoginInfo;

public class MainActivity extends AppCompatActivity {

    private WebView webView_main;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //关于WebView的操作
        aboutWebView();
    }

    /**
     * 关于WebView的操作
     */
    private void aboutWebView() {
        // 创建WebView对象
        webView_main = (WebView) findViewById(R.id.webView_main);

        // 设置WebView初始化尺寸，参数为百分比
        webView_main.setInitialScale(100);

        //设置WebView可触摸放大缩小
        webView_main.getSettings().setSupportZoom(true);
        webView_main.getSettings().setBuiltInZoomControls(true);
        //WebView双击变大，再双击后变小，当手动放大后，双击可以恢复到原始大小
        webView_main.getSettings().setUseWideViewPort(true);

        // 获取WebSettings对象
        webSettings = webView_main.getSettings();
        // 设置WebView支持运行普通的Javascript
        webSettings.setJavaScriptEnabled(true);

        // 设置WebChromeClient，以支持运行特殊的Javascript
        webView_main.setWebChromeClient(new WebChromeClient());


        // 阻止网络图片加載
        webView_main.getSettings().setBlockNetworkImage(true);
        // 点击超链接后不弹出浏览器窗口，而在WebView控件中加载URL
        webView_main.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 允许加载网络图片
                webView_main.getSettings().setBlockNetworkImage(false);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // 将一个Java对象绑定到一个Javascript对象中。
        //Javascript:语法与java很类似。
        webView_main.addJavascriptInterface(new LoginInfo(), "iGetInfo");
        // 加载写有Javascript语句的资产目录下网页
        webView_main.loadUrl("file:///android_asset/LoginInfo.html");
        // webView_main.loadUrl("javascript:方法名()");
    }
}
