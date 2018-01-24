package com.masget.oauth.mock.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.semsun.oauth.core.entity.User;
import com.semsun.oauth.dao.UserDao;
import com.semsun.oauth.mock.MockDatabase;

@Component("userDao")
public class MockUserDao implements UserDao {
	
	@Autowired
	private MockDatabase db;

	@Override
	public void insert(User data) {
		db.insert(data);
	}

	@Override
	public void delete(User data) {
		db.delete(data);
	}

	@Override
	public void update(User data) {
		db.update(data);
	}

	@Override
	public User select(User data) {
		return db.select(data);
	}

	@Override
	public List<User> selectAll(User data) {
		return db.selectAll(data);
	}
}
