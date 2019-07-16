package com.renly.HW;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("hw");
		System.out.println(helloWorld.toString());
	}

}
