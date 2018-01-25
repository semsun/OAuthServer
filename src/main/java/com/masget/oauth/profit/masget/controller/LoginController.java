package com.masget.oauth.profit.masget.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	public String doLogin(Model model, String username, String password) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(token);
		
		model.addAttribute("userName", (String)currentUser.getPrincipal());
		
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
		model.addAttribute("userName", currentUser.getPrincipal());
		
		return "index";
	}

}
