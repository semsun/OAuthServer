package com.masget.oauth.profit.masget.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.masget.oauth.core.entity.SessionInfo;
import com.masget.oauth.core.service.SessionService;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("sessionService")
	private SessionService sessionService;
	
	@RequestMapping("oauth2loginc")
	public String oauth2Login(Model model, HttpServletRequest request) {
//		Client client = (Client) model.get("client");
//		Client client = (Client) request.getAttribute("client");
		model.addAttribute("test", "testLogin");
		return "login";
	}
	
	@RequestMapping("login_action")
	@ResponseBody
	public String login_action(HttpServletRequest request, HttpServletResponse response, String backUrl) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		if( null == backUrl || backUrl.isEmpty() ) return "0";
		SessionInfo session = sessionService.getSessionInfo();
		session.setLogin(true);
		
		return backUrl;
	}
	
	@RequestMapping("login")
	public String login(Model model, HttpServletRequest request) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

		model.addAttribute("test", "testLogin");
		
		return "login";
	}
	
	@RequestMapping("login/auth")
	public String doLogin(Model model, HttpServletRequest request, String username, String password) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject currentUser = SecurityUtils.getSubject();
		
		currentUser.getSession().setAttribute("SessionValue", "SessionValue");
		currentUser.login(token);

		String sessionId = request.getSession().getId();
		model.addAttribute("userName", currentUser.getPrincipal());
		model.addAttribute("sessionId", sessionId);
		
		return "index";
	}
	
	@RequestMapping("loginout")
	public String loginOut(Model model, HttpServletRequest request) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return "login";
	}
	
	@RequestMapping("index")
	public String index(Model model, HttpServletRequest request) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

		Subject currentUser = SecurityUtils.getSubject();
		model.addAttribute("userName", currentUser.getSession().getAttribute("SessionValue"));
		
		return "index";
	}
	
	@RequestMapping("session")
	public String testSession(Model model, HttpServletRequest request, HttpServletResponse response) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

		SessionKey key = new WebSessionKey("0c126e8f-e836-4d2d-8fa9-5a0d9bca551e", request, response);
		Session session = SecurityUtils.getSecurityManager().getSession(key);
		
		model.addAttribute("userName", session.getAttribute("username"));
		model.addAttribute("sessionId", session.getId());
		
		return "index";
	}

}
