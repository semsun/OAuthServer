package com.semsun.oauth.mock.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.semsun.oauth.core.entity.Token;
import com.semsun.oauth.dao.TokenDao;
import com.semsun.oauth.mock.MockDatabase;

@Component("tokenDao")
public class MockTokenDao implements TokenDao {

	@Autowired
	private MockDatabase db;

	@Override
	public void insert(Token token) {
		db.insert(token);
	}

	@Override
	public void delete(Token token) {
		db.delete(token);
	}

	@Override
	public void update(Token token) {
		db.update(token);
	}

	@Override
	public Token select(Token token) {
		return db.select(token);
	}

	@Override
	public Token select(String accessTocken) {
		// TODO Auto-generated method stub
		Token param = new Token();
		param.setAccessToken(accessTocken);
		return db.select(param);
	}
}
