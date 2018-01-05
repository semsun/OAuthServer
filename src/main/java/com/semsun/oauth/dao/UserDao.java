package com.semsun.oauth.dao;

import java.util.List;

import com.semsun.oauth.core.entity.User;

public interface UserDao {
	
	/**
	 * 添加用户
	 * @param data
	 */
	public void insert(User data);
	
	/**
	 * 删除用户
	 * @param data
	 */
	public void delete(User data);
	
	/**
	 * 修改用户
	 * @param data
	 */
	public void update(User data);
	
	/**
	 * 获取用户
	 * @param data
	 * @return
	 */
	public User select(User data);
	
	/**
	 * 查询多个用户
	 * @param data
	 * @return
	 */
	public List<User> selectAll(User data);

}
