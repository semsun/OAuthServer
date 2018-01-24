package com.masget.oauth.dao;

import java.util.List;

import com.semsun.oauth.core.entity.Client;

public interface ClientDao {
	
	/**
	 * 添加客户端
	 * @param data
	 */
	public void insert(Client data);
	
	/**
	 * 删除客户端
	 * @param data
	 */
	public void delete(Client data);
	
	/**
	 * 修改客户端
	 * @param data
	 */
	public void update(Client data);
	
	/**
	 * 获取单个客户端
	 * @param data
	 * @return
	 */
	public Client select(Client data);
	
	/**
	 * 获取多个客户端
	 * @param data
	 * @return
	 */
	public List<Client> selectAll(Client data);

}
