package com.semsun.oauth.profit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.semsun.oauth.core.entity.Client;
import com.semsun.oauth.core.entity.SessionInfo;
import com.semsun.oauth.core.service.SessionService;

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
	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, String backUrl) {
		
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		if( null == backUrl || backUrl.isEmpty() ) return "0";
		SessionInfo session = sessionService.getSessionInfo();
		session.setLogin(true);
		
		return backUrl;
	}

}
