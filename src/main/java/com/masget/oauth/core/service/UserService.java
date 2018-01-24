package com.masget.oauth.core.service;

import java.util.List;

import com.masget.oauth.core.entity.User;

public interface UserService {
	
	/**
	 * 创建用户
	 * @param user
	 * @return
	 */
	public User createUser(User user);  
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public User updateUser(User user);
	
	/**
	 * 删除用户
	 * @param userId
	 */
	public void deleteUser(Long userId);
	
	/**
	 * 修改密码
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword);
	
	/**
	 * 根据id查找用户
	 * @param userId
	 * @return
	 */
	public User findOne(Long userId);
	
	/**
	 * 得到所有用户
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

}
