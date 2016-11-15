package com.steven.android13.webviewbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText editText_main_url;
	private WebView webView_main;
	private String url = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText_main_url = (EditText) findViewById(R.id.editText_main_url);
		webView_main = (WebView) findViewById(R.id.webView_main);
		// 让webview对象支持解析javascript语句
		webView_main.getSettings().setJavaScriptEnabled(true);
		// 让webview对象支持解析alert()等特殊的javascript语句
		webView_main.setWebChromeClient(new WebChromeClient());
		// 如果不使用该句代码，在点击超链地址后，会跳出程序，而弹出浏览器访问网页。
		webView_main.setWebViewClient(new WebViewClient());

	}

	public void clickButton(View view) {
		switch (view.getId()) {
		// 浏览器中后退键监听
		case R.id.button_main_goback:
			webView_main.goBack();
			break;
		// 浏览器前进键监听
		case R.id.button_main_goforward:
			webView_main.goForward();
			break;
		// 当输入网址后，点击该按钮，可以执行访问
		case R.id.button_main_submit:
			url = editText_main_url.getText().toString();
			if ((url == null) || url.equals("")) {
				Toast.makeText(MainActivity.this, "请输入url地址！", Toast.LENGTH_LONG).show();
			} else {
				if (url.indexOf("http://") != 0) {
					url = "http://" + url;
				}
				webView_main.loadUrl(url);
			}

			//清空用户的录入
			editText_main_url.setText("");
			break;
		// 浏览器停止加载键监听
		case R.id.button_main_stop:
			webView_main.stopLoading();
			break;
		// 浏览器刷新键监听
		default:
			break;
		}
	}
}
