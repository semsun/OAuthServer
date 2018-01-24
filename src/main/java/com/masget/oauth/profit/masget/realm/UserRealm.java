package com.masget.oauth.profit.masget.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.masget.oauth.core.entity.User;
import com.masget.oauth.core.service.UserService;

@Component
public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		
		String userName = (String)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String userName = (String)token.getPrincipal();
		
		User user = userService.findByUsername(userName);
		
		if( null == user ) throw new UnknownAccountException(); //没找到帐号
		
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得不好用，可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getUsername(),
				user.getPassword(),
//				ByteSource.Util.bytes(user.getSalt()),
				ByteSource.Util.bytes("default"),
				getName()
				);
		
		return authenticationInfo;
	}

	/**
	 * 清理授权数据
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}
	
	/**
	 * 清理鉴权数据
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}
	
	/**
	 * 清理所有数据
	 */
	public void clearAllCache() {
		this.clearAllCachedAuthenticationInfo();
		this.clearAllCachedAuthorizationInfo();
	}
}
