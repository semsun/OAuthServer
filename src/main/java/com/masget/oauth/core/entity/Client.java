package com.masget.oauth.core.entity;

public class Client {

	private long id;				// 编号 主键
	
	private String clientName;		// 客户端名称
	
	private String clientId;		// 客户端id
	
	private String clientSecret;	// 客户端安全key

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
	 * 客户端名称
	 * @return
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * 客户端名称
	 * @param clientName
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * 客户端id
	 * @return
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * 客户端id
	 * @param clientId
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * 客户端安全key
	 * @return
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
}
