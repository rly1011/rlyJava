 package com.renly.IOC.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月5日 下午3:06:34   
 */
public class MainTest {

	public static void main(String[] args) {
		   ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext( "beans-autowire.xml" );
	       Action action = (Action) ctx.getBean( "action");
	       System.out.println(action);
	}

}
