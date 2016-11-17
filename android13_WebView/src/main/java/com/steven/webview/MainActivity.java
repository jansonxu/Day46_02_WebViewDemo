package com.steven.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView_main;
    private String urlString = "http://m.weather.com.cn/m/pn12/weather.htm?id=101010100T";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView_main = (WebView) findViewById(R.id.webView_main);

        // //允许JS（JavaScript）执行
        webView_main.getSettings().setJavaScriptEnabled(true);
        webView_main.setWebViewClient(new WebViewClient());
        webView_main.setWebChromeClient(new WebChromeClient());

        //添加注释xxx
        //另外书写注释xxx

        // are you ready?

        //加载网页
        // webView_main.loadUrl(urlString);

        String data = "<form method='post' action='#'>用户名：<input type='text' name=''><br><input type='submit' value='提交'><script>document.write('输出内容');alert('用户名不得为空！');</script>";
       // webView_main.loadData(data, "text/html", "UTF-8");//有乱码

        webView_main
        		.loadDataWithBaseURL(null, data, "text/html", "utf-8", null);//没有乱码

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
