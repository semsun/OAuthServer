package com.masget.oauth.profit.masget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.masget.oauth.core.entity.Client;
import com.masget.oauth.core.service.ClientService;
import com.masget.oauth.dao.ClientDao;

@Service("clientService")
public class MasgetClientService implements ClientService {
	
	@Autowired
	@Qualifier("clientDao")
	private ClientDao clientDao;

	@Override
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		clientDao.insert(client);
		
		return client;
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		clientDao.update(client);
		
		return client;
	}

	@Override
	public void deleteClient(Long clientId) {
		// TODO Auto-generated method stub
		Client data = new Client();
		data.setId(clientId);
		clientDao.delete(data);
	}

	@Override
	public Client findOne(Long clientId) {
		// TODO Auto-generated method stub
		Client data = new Client();
		data.setId(clientId);
		return clientDao.select(data);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientDao.selectAll( new Client() );
	}

	@Override
	public Client findByClientId(String clientId) {
		// TODO Auto-generated method stub
		Client data = new Client();
		data.setClientId(clientId);
		
		List<Client> list = clientDao.selectAll(data);
		if( null != list && list.size() == 1 ) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Client findByClientSecret(String clientSecret) {
		// TODO Auto-generated method stub
		Client data = new Client();
		data.setClientSecret(clientSecret);
		
		List<Client> list = clientDao.selectAll(data);
		if( null != list && list.size() == 1 ) {
			return list.get(0);
		}
		return null;
	}

}
