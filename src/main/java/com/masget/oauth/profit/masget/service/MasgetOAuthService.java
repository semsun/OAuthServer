package com.masget.oauth.profit.masget.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.masget.oauth.core.entity.AuthorizeCode;
import com.masget.oauth.core.entity.Client;
import com.masget.oauth.core.entity.Token;
import com.masget.oauth.core.service.OAuthService;
import com.masget.oauth.dao.AuthorizeCodeDao;
import com.masget.oauth.dao.ClientDao;
import com.masget.oauth.dao.TokenDao;

@Service("oAuthService")
public class MasgetOAuthService implements OAuthService {
	
	@Autowired
	@Qualifier("authorizeCodeDao")
	private AuthorizeCodeDao authorizeCodeDao;
	
	@Autowired
	@Qualifier("tokenDao")
	private TokenDao tokenDao;
	
	@Autowired
	@Qualifier("clientDao")
	private ClientDao clientDao;

	@Override
	public void addAuthCode(AuthorizeCode authorizeCode, String username) {
		// TODO Auto-generated method stub
		authorizeCodeDao.insert(authorizeCode);
	}

	@Override
	public void addAccessToken(Token accessToken, String username) {
		// TODO Auto-generated method stub
		tokenDao.insert(accessToken);
	}

	@Override
	public boolean checkAuthCode(String authCode) {
		// TODO Auto-generated method stub
		if( null == authorizeCodeDao.select(authCode) ) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean checkAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		if( null == tokenDao.select(accessToken) ) {
			return false;
		}
		
		return true;
	}

	@Override
	public String getUsernameByAuthCode(String authCode) {
		// TODO Auto-generated method stub
		AuthorizeCode code = authorizeCodeDao.select(authCode);
		return code.getCode();
	}

	@Override
	public String getUsernameByAccessToken(String accessToken) {
		// TODO Auto-generated method stub
		Token toke = tokenDao.select(accessToken);
				
		return toke.getAccessToken();
	}

	@Override
	public long getExpireIn() {
		// TODO Auto-generated method stub
		return Token.DEFAULT_EXPIRE_IN;
	}

	@Override
	public boolean checkClientId(String clientId) {
		// TODO Auto-generated method stub
		Client param = new Client();
		param.setClientId(clientId);
		
		List<Client> client = clientDao.selectAll(param);
		if( null == client || client.size() != 1 ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkClientSecret(String clientSecret) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Client param = new Client();
		param.setClientSecret(clientSecret);
		
		List<Client> client = clientDao.selectAll(param);
		if( null == client || client.size() != 1 ) {
			return false;
		}
		return true;
	}

}
