package com.semsun.oauth.dao;

import com.semsun.oauth.core.entity.AuthorizeCode;

public interface AuthorizeCodeDao {

	/**
	 * 新增授权码
	 * @param code
	 */
	public void insert(AuthorizeCode code);
	
	/**
	 * 删除授权码
	 * @param code
	 */
	public void delete(AuthorizeCode code);
	
	/**
	 * 修改授权码，必须带有code属性
	 * @param code
	 */
	public void update(AuthorizeCode code);
	
	/**
	 * 根据code属性，获取授权码
	 * @param code
	 * @return
	 */
	public AuthorizeCode select(AuthorizeCode code);
	
	/**
	 * 根据code属性，获取授权码
	 * @param code
	 * @return
	 */
	public AuthorizeCode select(String code);
	
}
