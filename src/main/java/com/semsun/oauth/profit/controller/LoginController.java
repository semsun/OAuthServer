package com.semsun.oauth.profit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/oauth2login")
	@ResponseBody
	public String oauth2login(String client) {
		return client;
	}
}
