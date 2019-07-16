 package com.renly.AOP.notice;

 import java.util.Arrays;

 import org.aspectj.lang.JoinPoint;
 import org.aspectj.lang.annotation.After;
 import org.aspectj.lang.annotation.AfterReturning;
 import org.aspectj.lang.annotation.AfterThrowing;
 import org.aspectj.lang.annotation.Aspect;
 import org.aspectj.lang.annotation.Before;
 import org.aspectj.lang.annotation.Pointcut;
 import org.springframework.core.annotation.Order;
 import org.springframework.stereotype.Component;

/**
 * @Description: 通知类 
 * @author 任岚杨
 * @date 2019年7月4日 下午2:29:15   
 */
@Aspect
@Component
public class LoggingAspect {
	
	/*
	 * 用于声明切面表达式，一般地，该方法中不再需要添加其他的代码
	 */
	@Pointcut("execution(public int com.renly.AOP.notice.ArithmeticCalculator.*(int, int))")
	public void declareJointPointExpression() {
	}
	
	/*
	 * 前置通知
	 */
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	/*
	 * 后置通知
	 */
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	/**
	 * 
	 * @Description:返回通知
	 */
	@AfterReturning(value="declareJointPointExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	/**
	 * 
	 * @Description:异常通知
	 */
	@AfterThrowing(value="declareJointPointExpression()",
			throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs excetion:" + e);
	}

}
