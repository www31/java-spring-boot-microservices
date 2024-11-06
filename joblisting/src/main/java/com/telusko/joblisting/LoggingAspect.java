package com.telusko.joblisting;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.telusko.joblisting.controller.PostController.getAllPosts())")
	public void logBefore()
	{
		LOGGER.info("getAliens method called from aspect");
	}
	
	@AfterReturning("execution(public * com.telusko.joblisting.controller.PostController.getAllPosts())")
	public void logAfter()
	{
		LOGGER.info("getAliens method Executrd");
	}
	
	@AfterThrowing("execution(public * com.telusko.joblisting.controller.PostController.getAllPosts())")
	public void logException()
	{
		LOGGER.info("Issue");
	}
}
