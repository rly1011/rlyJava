 package com.renly.AOP.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月4日 下午4:06:34   
 */
public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-order.xml");
		Logging logging = (Logging) ctx.getBean("logging");
		logging.test();
	}
}
