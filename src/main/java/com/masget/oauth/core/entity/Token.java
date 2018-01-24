package com.masget.oauth.core.entity;

public class Token {
	
	public static long DEFAULT_EXPIRE_IN = 7200;	// Token默认7200秒有效期
	
	private String accessToken;		// 访问令牌
	
	private String refreshToken;	// 更新令牌，每次验证后，必须更换
	
	private String grantType;		// 令牌获取方式:authorization_code, password, client_credentials, implicit, refresh_token
	
	private String tokenType;		// 令牌类型，根据不同的业务，将不有同的令牌类型，保护不同的资源保持
	
	private long expiresIn = DEFAULT_EXPIRE_IN;	// 令牌过期时间
	
	private String authorizeCode;	// 授权码，通过该授权码获取到的令牌

	/**
	 * 访问令牌
	 * @return
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * 访问令牌
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 更新令牌，每次验证后，必须更换
	 * @return
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * 更新令牌，每次验证后，必须更换
	 * @param refreshToken
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * 令牌获取方式:authorization_code, password, client_credentials, implicit, refresh_token
	 * @return
	 */
	public String getGrantType() {
		return grantType;
	}

	/**
	 * 令牌获取方式:authorization_code, password, client_credentials, implicit, refresh_token
	 * @param grantType
	 */
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	/**
	 * 令牌类型，根据不同的业务，将不有同的令牌类型，保护不同的资源保持
	 * @return
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * 令牌类型，根据不同的业务，将不有同的令牌类型，保护不同的资源保持
	 * @param tokenType
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * 令牌过期时间
	 * @return
	 */
	public long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * 令牌过期时间
	 * @param expiresIn
	 */
	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * 授权码，通过该授权码获取到的令牌
	 * @return
	 */
	public String getAuthorizeCode() {
		return authorizeCode;
	}

	/**
	 * 授权码，通过该授权码获取到的令牌
	 * @param authorizeCode
	 */
	public void setAuthorizeCode(String authorizeCode) {
		this.authorizeCode = authorizeCode;
	}

}
