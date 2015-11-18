package com.enforce.detection.web;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class JettyMain extends AbstractHandler {

    public void handle(String target,
            Request baseRequest,
            HttpServletRequest request,
            HttpServletResponse response) 
        throws IOException, ServletException
		{
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		response.getWriter().println("<h1>Hello World</h1>");
		}

public static void main(String[] args) throws Exception
{
	ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    
	Server server = new Server(8080);
	server.setHandler(context);
	
	/* Create jersey
	 * 
	 */
    ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/webapi/*");
    jerseyServlet.setInitOrder(1);
    jerseyServlet.setInitParameter("jersey.config.server.provider.packages","com.enforce.detection.web.api");
    //jerseyServlet.setInitParameter("com.sun.jersey.config.property.packages", "io.swagger.jaxrs.json;io.swagger.sample.resource;io.swagger.jaxrs.listing");
/*
    ServletHolder swaggerServlet = context.addServlet(io.swagger.jaxrs.config.DefaultJaxrsConfig.class, "/webapi/*");
    swaggerServlet.setInitOrder(2);
    swaggerServlet.setInitParameter("swagger.api.basepath", "http://localhost:8080/doc");
    swaggerServlet.setInitParameter("swagger.api.title", "test");
    swaggerServlet.setInitParameter("api.version", "1.0.0");
    */
    
    //SwaggerInitializer test = new SwaggerInitializer();
    //context.addFilter(SwaggerInitializer.class, "/", 1);
    //context.addBean(SwaggerInitializer.class);
    //context.getServletContext().addListener(new SwaggerInitializer());
    //jerseyServlet.addLifeCycleListener((Listener) new SwaggerInitializer());
    
    ServletHolder staticServlet = context.addServlet(DefaultServlet.class,"/*");
    staticServlet.setInitParameter("resourceBase","src/main/webapp");
    staticServlet.setInitParameter("pathInfoOnly","true");
    
    
	server.start();
	server.join();
}


    
}
