 package com.renly.AOP.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月4日 下午2:43:10   
 */
public class MainTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-xml.xml");
		ArithmeticCalculator arithmeticCalculator =  (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		int result = arithmeticCalculator.div(1, 1);
		System.out.println("result:" + result);
	}

}
