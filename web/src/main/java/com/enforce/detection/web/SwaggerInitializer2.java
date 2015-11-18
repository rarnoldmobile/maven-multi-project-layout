package com.enforce.detection.web;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SwaggerInitializer2  implements ServletContextListener {

	  public void contextInitialized(ServletContextEvent servletContextEvent) {
		    System.out.println("test");
	        BeanConfig beanConfig = new BeanConfig();
	        beanConfig.setVersion( "1.0.2" );
	        beanConfig.setResourcePackage( "com.enforce.detection.web.api" ); // replace with your packages
	        beanConfig.setBasePath( "http://localhost:8080" );
	        beanConfig.setDescription( "My RESTful resources" );
	        beanConfig.setTitle( "My RESTful API" );
	        beanConfig.setScan( true );
	    }
	  
	    public void contextDestroyed(ServletContextEvent servletContextEvent) {
	    }
	    
}
