package com.masget.oauth.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.masget.oauth.core.entity.AuthorizeCode;
import com.masget.oauth.core.entity.Client;
import com.masget.oauth.core.entity.Token;
import com.masget.oauth.core.entity.User;

@Service
public class MockDatabase {
	Map<Long, User> userTable;
	Map<Long, Client> clientTable;
	Map<String, AuthorizeCode> authorizeCodeTable;
	Map<String, Token> tokenTable;
	
	@PostConstruct
	public void init() {
		userTable = new HashMap<Long, User>();
		clientTable = new HashMap<Long, Client>();
		authorizeCodeTable = new HashMap<String, AuthorizeCode>();
		tokenTable = new HashMap<String, Token>();
		
		this.initMockData();
	}
	
	private void initMockData() {
		/* 客户端 */
		Client client = new Client();
		client.setId(100000);
		client.setClientId("test1");
		client.setClientName("test1_name");
		client.setClientSecret("test1_secret");
		clientTable.put(client.getId(), client);
		
		client = new Client();
		client.setId(200000);
		client.setClientId("test2");
		client.setClientName("test2_name");
		client.setClientSecret("test2_secret");
		clientTable.put(client.getId(), client);

		/* 用户 */
		User user = new User();
		user.setId(100000);
		user.setUsername("test1");
		user.setPassword("test1");
		userTable.put(user.getId(), user);
		
		user = new User();
		user.setId(200000);
		user.setUsername("test2");
		user.setPassword("test2");
		userTable.put(user.getId(), user);
	}
	
	/* User */
	public void insert(User data) {
		userTable.put( data.getId(), data );
	}
	
	public User select(User data) {
		return userTable.get(data.getId());
	}
	
	public List<User> selectAll(User data) {
		List<User> ret = new ArrayList<User>();
		for( User user : userTable.values() ) {
			if( data.getUsername().isEmpty() ) {
				ret.add(user);
			} else {
				if( user.getUsername().equals(data.getUsername()) ) {
					ret.add(user);
				}
			}
		}
		
		return ret;
	}
	
	public void update(User data) {
		this.delete(data);
		this.insert(data);
	}
	
	public void delete(User data) {
		userTable.remove(data.getId());
	}
	
	/* Client */
	public void insert(Client data) {
		clientTable.put( data.getId(), data );
	}
	
	public Client select(Client data) {
		return clientTable.get(data.getId());
	}
	
	public List<Client> selectAll(Client data) {
		List<Client> ret = new ArrayList<Client>();
		for( Client client : clientTable.values() ) {
			if( null != data.getClientId() && !data.getClientId().isEmpty() ) {
				if( client.getClientId().equals(data.getClientId()) ) {
					ret.add(client);
				}
			} else if( null != data.getClientSecret() && !data.getClientSecret().isEmpty() ) {
				if( client.getClientSecret().equals(data.getClientSecret()) ) {
					ret.add(client);
				}
			} else {
				ret.add(client);
			}
		}
		
		return ret;
	}
	
	public void update(Client data) {
		this.delete(data);
		this.insert(data);
	}
	
	public void delete(Client data) {
		clientTable.remove(data.getId());
	}
	
	/* Token */
	public void insert(Token data) {
		tokenTable.put( data.getAccessToken(), data );
	}
	
	public Token select(Token data) {
		return tokenTable.get( data.getAccessToken() );
	}
	
	public List<Token> selectAll(Token data) {
		List<Token> ret = new ArrayList<Token>();
		for( Token token : tokenTable.values() ) {
			ret.add(token);
//			if( !token.getClientId().isEmpty() ) {
//				if( token.getClientId().equals(data.getClientId()) ) {
//					ret.add(token);
//				}
//			} else if( !token.getClientSecret().isEmpty() ) {
//				if( token.getClientSecret().equals(data.getClientSecret()) ) {
//					ret.add(token);
//				}
//			} else {
//				ret.add(token);
//			}
		}
		
		return ret;
	}
	
	public void update(Token data) {
		this.delete(data);
		this.insert(data);
	}
	
	public void delete(Token data) {
		tokenTable.remove(data.getAccessToken());
	}
	
	/* AuthorizeCode */
	public void insert(AuthorizeCode data) {
		authorizeCodeTable.put( data.getCode(), data );
	}
	
	public AuthorizeCode select(AuthorizeCode data) {
		return authorizeCodeTable.get( data.getCode() );
	}
	
	public List<AuthorizeCode> selectAll(AuthorizeCode data) {
		List<AuthorizeCode> ret = new ArrayList<AuthorizeCode>();
		for( AuthorizeCode token : authorizeCodeTable.values() ) {
			ret.add(token);
//			if( !token.getClientId().isEmpty() ) {
//				if( token.getClientId().equals(data.getClientId()) ) {
//					ret.add(token);
//				}
//			} else if( !token.getClientSecret().isEmpty() ) {
//				if( token.getClientSecret().equals(data.getClientSecret()) ) {
//					ret.add(token);
//				}
//			} else {
//				ret.add(token);
//			}
		}
		
		return ret;
	}
	
	public void update(AuthorizeCode data) {
		this.delete(data);
		this.insert(data);
	}
	
	public void delete(AuthorizeCode data) {
		authorizeCodeTable.remove(data.getCode());
	}
}
