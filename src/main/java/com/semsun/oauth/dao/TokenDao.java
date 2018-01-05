package com.semsun.oauth.dao;

import com.semsun.oauth.core.entity.Token;

public interface TokenDao {

	/**
	 * 新增令牌
	 * @param token
	 */
	public void insert(Token token);
	
	/**
	 * 删除令牌
	 * @param token
	 */
	public void delete(Token token);
	
	/**
	 * 修改令牌，必须带有accessTocken属性
	 * @param token
	 */
	public void update(Token token);
	
	/**
	 * 根据accessTocken属性，获取令牌
	 * @param accessTocken
	 * @return
	 */
	public Token select(Token accessTocken);
	
	/**
	 * 根据accessTocken属性，获取令牌
	 * @param accessTocken
	 * @return
	 */
	public Token select(String accessTocken);

}
