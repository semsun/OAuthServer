package com.masget.oauth.core.entity;

public class SessionInfo {

	private String userName;	// 登陆名称
	
	private boolean isLogin;	// 是否已登陆标志：true:已登陆；false:未登陆

	/**
	 * 登陆名称
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 登陆名称
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 是否已登陆标志：true:已登陆；false:未登陆
	 * @return
	 */
	public boolean isLogin() {
		return isLogin;
	}

	/**
	 * 是否已登陆标志：true:已登陆；false:未登陆
	 * @param isLogin
	 */
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
}
