 package com.renly.AOP.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

/**
 * @Description: 通知类 
 * @author 任岚杨
 * @date 2019年7月4日 下午2:29:15   
 */
public class LoggingAspect {
	/**
	 * 
	 * @Description:前置通知
	 */
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	/**
	 * 
	 * @Description:后置通知
	 */
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	/**
	 * 
	 * @Description:返回通知
	 */
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	/**
	 * 
	 * @Description:异常通知
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs excetion:" + e);
	}

}
