package com.semsun.oauth.profit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 增加跨域访问链接
 * @author sunyongqian
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/authorize").allowedOrigins("*");
		registry.addMapping("/accessToken").allowedOrigins("*");
		registry.addMapping("/login").allowedOrigins("*");
		super.addCorsMappings(registry);
	}

}
