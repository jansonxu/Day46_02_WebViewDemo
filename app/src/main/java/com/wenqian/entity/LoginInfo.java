package com.wenqian.entity;

import android.webkit.JavascriptInterface;

/**
 * Description：  Javascript语句中将调用该实体类中的内容<br/>
 * Copyright (c)   2016,  Jansonxu <br/>
 * This program is protected by copyright laws <br/>
 * Date: 2016年11月15  11:53
 *
 * @author 徐文波
 * @version : 1.0
 */
public class LoginInfo {
    private String username;
    private String password;

    public LoginInfo() {
        this.username = "施瓦辛格";
        this.password = "123456789";
    }

    @JavascriptInterface
    public LoginInfo getLoginInfos() {
        return new LoginInfo();
    }

    //必须添加此注解，否则，在JavaScript中无法调用该方法
    @JavascriptInterface
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JavascriptInterface
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
