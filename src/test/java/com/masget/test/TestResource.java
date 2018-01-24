package com.masget.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestResource {
	 private static TestResource mInstance = null;
	 
	 private ClassPathXmlApplicationContext applicationContext;

     public static ClassPathXmlApplicationContext getApplicationContext() {
             if( null == mInstance ) {
                     mInstance = new TestResource();
             }

             return mInstance.getContext();
     }

     private TestResource() {
             applicationContext = new ClassPathXmlApplicationContext(
                             "applicationContext.xml");
             applicationContext.start();
     }
     
     public ClassPathXmlApplicationContext getContext() {
    	 return applicationContext;
     }
}
