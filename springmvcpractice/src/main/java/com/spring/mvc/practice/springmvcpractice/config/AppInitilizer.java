package com.spring.mvc.practice.springmvcpractice.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MvcConfiguration.class);
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("mvc",
				new DispatcherServlet(context));
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/");

	}

}
