package com.semsun.oauth.profit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.semsun.oauth.core.entity.Client;

@Controller
public class LoginController {
	
	@RequestMapping("oauth2loginc")
	public String oauth2Login(Model model, HttpServletRequest request) {
//		Client client = (Client) model.get("client");
//		Client client = (Client) request.getAttribute("client");
		model.addAttribute("test", "testLogin");
		return "login";
	}

}
