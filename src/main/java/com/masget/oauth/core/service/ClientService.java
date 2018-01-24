package com.masget.oauth.core.service;

import java.util.List;

import com.semsun.oauth.core.entity.Client;

public interface ClientService {
	/**
	 * 创建客户端  
	 * @param client
	 * @return
	 */
	public Client createClient(Client client);
	
	/**
	 * 更新客户端  
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client);
	
	/**
	 * 删除客户端 
	 * @param clientId
	 */
	public void deleteClient(Long clientId);
	
	/**
	 * 根据id查找客户端 
	 * @param clientId
	 * @return
	 */
	Client findOne(Long clientId);
	
	/**
	 * 查找所有
	 * @return
	 */
	List<Client> findAll();
	
	/**
	 * 根据客户端id查找客户端 
	 * @param clientId
	 * @return
	 */
	Client findByClientId(String clientId);
	
	/**
	 * 根据客户端安全KEY查找客户端
	 * @param clientSecret
	 * @return
	 */
	Client findByClientSecret(String clientSecret);
}
