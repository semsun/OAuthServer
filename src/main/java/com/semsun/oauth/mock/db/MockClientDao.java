package com.semsun.oauth.mock.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.semsun.oauth.core.entity.Client;
import com.semsun.oauth.dao.ClientDao;
import com.semsun.oauth.mock.MockDatabase;

@Component("clientDao")
public class MockClientDao implements ClientDao {
	
	@Autowired
	private MockDatabase db;
	
	@Override
	public void insert(Client data) {
		db.insert(data);
	}

	@Override
	public void delete(Client data) {
		db.delete(data);
	}

	@Override
	public void update(Client data) {
		db.update(data);
	}

	@Override
	public Client select(Client data) {
		return db.select(data);
	}

	@Override
	public List<Client> selectAll(Client data) {
		return db.selectAll(data);
	}

}
