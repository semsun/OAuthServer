package com.semsun.oauth.core.entity;

import java.util.Set;

public class AuthorizeCode {
	
	private String userId;			// 用户ID
	
	private String userName;		// 用户名
	
	private String code;			// 授权代码
	
	private String responseType;	// 响应类型
	
	private String clientId;		// 客户端ID
	
	private Set<String> scope;		// 范围

	/**
	 * 用户ID
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户ID
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 授权代码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 授权代码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 响应类型
	 * @return
	 */
	public String getResponseType() {
		return responseType;
	}

	/**
	 * 响应类型
	 * @param responseType
	 */
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	/**
	 * 客户端ID
	 * @return
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * 客户端ID
	 * @param clientId
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * 范围
	 * @return
	 */
	public Set<String> getScope() {
		return scope;
	}

	/**
	 * 范围
	 * @param scope
	 */
	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

}
