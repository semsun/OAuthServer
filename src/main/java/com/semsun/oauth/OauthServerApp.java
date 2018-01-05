package com.semsun.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="com.semsun.oauth")
public class OauthServerApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(OauthServerApp.class, args);
        System.out.println( "-------------------- OAuth Server Started ------------------" );
    }
}
