package com.sb.cassandra.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sb.cassandra.service.CustomerService;

@Component
public class CustomInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Override
	   public boolean preHandle
	      (HttpServletRequest request, HttpServletResponse response, Object handler) 
	      throws Exception {
			long startTime = System.currentTimeMillis();
			request.setAttribute("startTime", startTime);
	      
	      logger.info("HTTP Method received: " +request.getMethod());
	      return true;
	   }
	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, ModelAndView modelAndView) throws Exception {
		   long startTime = (Long)request.getAttribute("startTime");
			
			long endTime = System.currentTimeMillis();

			long executeTime = endTime - startTime;
			
		  if(logger.isDebugEnabled()){ logger.debug("[" + handler + "] executeTime : "
		  + executeTime + "ms"); }
		 
	      
	      logger.info("Execution time taken to serve the request : "+executeTime +"ms");
	   }
	   @Override
	   public void afterCompletion
	      (HttpServletRequest request, HttpServletResponse response, Object 
	      handler, Exception exception) throws Exception {
		  logger.info("Request and Response is completed");
	      
	   }

}
