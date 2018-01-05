package com.semsun.oauth.core.service;

import com.semsun.oauth.core.entity.AuthorizeCode;
import com.semsun.oauth.core.entity.Token;

public interface OAuthService {
	/**
	 * 添加 auth code
	 * @param authCode
	 * @param username
	 */
	public void addAuthCode(AuthorizeCode authorizeCode, String username);
	
	/**
	 * 添加 access token
	 * @param accessToken
	 * @param username
	 */
	public void addAccessToken(Token accessToken, String username);
	
	/**
	 * 验证auth code是否有效
	 * @param authCode
	 * @return
	 */
	public boolean checkAuthCode(String authCode);
	
	/**
	 * 验证access token是否有效
	 * @param accessToken
	 * @return
	 */
	public boolean checkAccessToken(String accessToken);
	
	/**
	 * 根据auth code获取用户名
	 * @param authCode
	 * @return
	 */
	public String getUsernameByAuthCode(String authCode);
	
	/**
	 * 根据access token获取用户名
	 * @param accessToken
	 * @return
	 */
	public String getUsernameByAccessToken(String accessToken);
	
	/**
	 * auth code / access token 过期时间
	 * @return
	 */
	public long getExpireIn();
	
	/**
	 * 检查客户端id是否存在
	 * @param clientId
	 * @return
	 */
	public boolean checkClientId(String clientId);
	
	/**
	 * 检查客户端安全KEY是否存在
	 * @param clientSecret
	 * @return
	 */
	public boolean checkClientSecret(String clientSecret);
}
