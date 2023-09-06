package com.spring.mvc.practice.springmvcpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages="com.spring.mvc.practice.springmvcpractice")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurationSupport{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	} 
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("css/**", "images/**")
         .addResourceLocations("classpath:/css/", "classpath:/images/");
	}

	
}
