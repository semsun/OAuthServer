package com.masget.oauth.core.service;

import com.semsun.oauth.core.entity.SessionInfo;

public interface SessionService {

	/**
	 * 获取当前登陆信息
	 * @return
	 */
	public SessionInfo getSessionInfo();
}
