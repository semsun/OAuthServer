package com.masget.oauth.mock.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.semsun.oauth.core.entity.AuthorizeCode;
import com.semsun.oauth.dao.AuthorizeCodeDao;
import com.semsun.oauth.mock.MockDatabase;

@Component("authorizeCodeDao")
public class MockAuthorizeCodeDao implements AuthorizeCodeDao {
	
	@Autowired
	private MockDatabase db;

	@Override
	public void insert(AuthorizeCode code) {
		// TODO Auto-generated method stub
		db.insert(code);
	}

	@Override
	public void delete(AuthorizeCode code) {
		// TODO Auto-generated method stub
		db.delete(code);
	}

	@Override
	public void update(AuthorizeCode code) {
		// TODO Auto-generated method stub
		db.update(code);
	}

	@Override
	public AuthorizeCode select(AuthorizeCode code) {
		// TODO Auto-generated method stub
		return db.select(code);
	}

	@Override
	public AuthorizeCode select(String code) {
		// TODO Auto-generated method stub
		AuthorizeCode param = new AuthorizeCode();
		param.setCode(code);
		return db.select(param);
	}

}
