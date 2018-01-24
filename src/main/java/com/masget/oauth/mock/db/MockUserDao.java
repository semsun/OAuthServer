package com.masget.oauth.mock.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masget.oauth.core.entity.User;
import com.masget.oauth.dao.UserDao;
import com.masget.oauth.mock.MockDatabase;

@Component("userDao")
public class MockUserDao implements UserDao {
	
	@Autowired
	private MockDatabase db;

	public MockDatabase getDb() {
		return db;
	}

	public void setDb(MockDatabase db) {
		this.db = db;
	}

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
