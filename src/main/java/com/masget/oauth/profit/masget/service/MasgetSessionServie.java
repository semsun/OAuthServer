package com.masget.oauth.profit.masget.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.masget.oauth.core.entity.SessionInfo;
import com.masget.oauth.core.service.SessionService;

@Service("sessionService")
public class MasgetSessionServie implements SessionService {
	
	private SessionInfo session;
	
	@PostConstruct
	private void init() {
		session = new SessionInfo();
		session.setUserName("test1");
		session.setLogin(false);
	}

	@Override
	public SessionInfo getSessionInfo() {
		// TODO Auto-generated method stub
		return session;
	}

}
