package com.semsun.oauth;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */
@SpringBootApplication
//@ComponentScan(basePackages="com.semsun.oauth")
public class OauthServerApp 
{
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
}
