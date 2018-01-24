package com.masget.oauth.profit.masget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.masget.oauth.core.entity.User;
import com.masget.oauth.core.service.UserService;
import com.masget.oauth.dao.UserDao;

@Service("userService")
public class MasgetUserService implements UserService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		return user;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(userId);
		
		userDao.delete(user);
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		User param = new User();
		param.setId(userId);
		User user = userDao.select(param);
		
		user.setPassword(newPassword);
		
		userDao.update(user);
	}

	@Override
	public User findOne(Long userId) {
		// TODO Auto-generated method stub
		User param = new User();
		param.setId(userId);
		return userDao.select(param);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll(new User());
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		if( null == username || username.isEmpty() ) return null;
		
		User param = new User();
		param.setUsername(username);
		List<User> list = userDao.selectAll(param);
		if( null != list && list.size() == 1 ) {
			return list.get(0);
		}
		return null;
	}

}
