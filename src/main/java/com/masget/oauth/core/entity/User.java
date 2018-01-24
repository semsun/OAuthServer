package com.masget.oauth.core.entity;

public class User {
	
	private long id;			// 编号 主键
	
	private String username;	// 用户名
	
	private String password;	// 密码
	
	private String salt;		// 盐

	/**
	 * 编号 主键
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * 编号 主键
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 用户名
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户名
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 盐
	 * @return
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 盐
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
