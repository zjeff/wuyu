package com.wuyu.mina.client.test;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wuyu.mina.client.MinaClientHandler;

public class MinaClientHandlerTest {

    ApplicationContext ctx = null;
    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext(new String[]{
        		"applicationContext.xml", "applicationContext-mina.xml", "wuyumvc-servlet.xml"});
    }
    
	@Test
	public void testEnv() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>>....");
	}
	
	@Test
	public void test() {
		System.out.println("abcd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "hello");
		MinaClientHandler minaClientHandler = new MinaClientHandler(map);
		System.out.println("begin connect");
		minaClientHandler.connect();
		
		System.out.println("send message end");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>>>....");
	}
}
