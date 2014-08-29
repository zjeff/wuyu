package com.wuyu.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextHelp implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		applicationContext = ctx;
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public static <T> T getBean(String beanName, Class<T> className) {
		return applicationContext.getBean(beanName, className);
	}

}
