package com.semsun.oauth.profit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.semsun.oauth.core.entity.User;
import com.semsun.oauth.core.service.UserService;
import com.semsun.oauth.dao.UserDao;

@Service("userService")
public class MasgetUserService implements UserService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

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
		User param = new User();
		param.setUsername(username);
		List<User> list = userDao.selectAll(param);
		if( null != list && list.size() == 1 ) {
			return list.get(0);
		}
		return null;
	}

}
