package com.steven.android12.webviewtwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView webView_main;
	private String urlString = "http://www.qq.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView_main = (WebView) findViewById(R.id.webView_main);
		webView_main.getSettings().setJavaScriptEnabled(true);// 支持运行javascript
		webView_main.setWebChromeClient(new WebChromeClient());// 支持运行特殊的javascript（例如：alert()）
		webView_main.setWebViewClient(new WebViewClient());// 当点击超链地址后不会新打开浏览器来访问，而是始终在本app中浏览页面
		// webView_main.loadUrl(urlString);
		String data = "<a href='http://www.baidu.com'>百度</a><form method='post' action=''><input type='text' name='username' id='username'><br/>"
				+ "<input type='password' name='password'><br/>"
				+ "<input type='submit' value='提交'>"
				+ "</form><script>if(document.getElementById('username').value=='') "
				+ "{alert('用户名不可以为空！');document.getElementById('username').value = '史泰龙';}</script>";
		// webView_main.loadData(data, "text/html",
		// "utf-8");//这个方法中虽然设置了字符集，但是运行效果中发现依然中文会显示乱码。为了解决这个问题，建议使用loadDataWithBaseURL()方法。
		webView_main
				.loadDataWithBaseURL(null, data, "text/html", "utf-8", null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
