package com.sb.cassandra.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CustomInterceptorAppConfig implements WebMvcConfigurer{

	@Autowired
	CustomInterceptor customInterceptor;
	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(customInterceptor);
	   }
}
