package com.renly.AOP.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @ClassName:  MainTest   
 * @Description:TODO(测试)   
 * @author: 任岚杨
 * @date:   2019年7月4日 下午1:47:35   
 *
 */
public class MainTest {
	/**
	 * 
	 * @Title: main   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param args      
	 * @return: void      
	 * @throws
	 */
	public static void main(String[] args) {
		  	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop.xml");
	        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean( "arithmeticCalculator" );
	        System.out.println(arithmeticCalculator.getClass().getName());
	        int result = arithmeticCalculator.add( 12,12 );
	        System.out.println(result);
	}

}
