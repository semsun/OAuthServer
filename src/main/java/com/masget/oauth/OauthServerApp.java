package com.masget.oauth;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;


/**
 * Hello world!
 *
 */
@SpringBootApplication
//@ComponentScan(basePackages="com.semsun.oauth")
//@ServletComponentScan(basePackages="com.semsun.oauth.profit")
public class OauthServerApp extends SpringBootServletInitializer
{
	
    @Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(OauthServerApp.class);
	}

	public static void main( String[] args )
    {
		SpringApplication app = new SpringApplication(OauthServerApp.class);
		app.setWebEnvironment(true);
		Set<Object> set = new HashSet<Object>();  
        set.add("classpath:applicationContext.xml");  
        app.setSources(set);  
        app.run(args);
        System.out.println( "-------------------- OAuth Server Started ------------------" );
    }
    
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(8080);
		factory.setSessionTimeout(10, TimeUnit.MINUTES);
//		factory.addErrorPages( new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html") );
		return factory;
	}
}
