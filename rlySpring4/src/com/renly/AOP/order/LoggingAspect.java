 package com.renly.AOP.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月4日 下午4:03:03   
 */
@Order(3)
@Component
@Aspect
public class LoggingAspect {
	/*
	 * 用于声明切面表达式，一般地，该方法中不再需要添加其他的代码
	 */
	@Pointcut("execution(* com.renly.AOP.order.*.*(..))")
	public void declareJointPointExpression() {
	}
	
	@Before(value = "declareJointPointExpression()")
	public void beforeArgs() {
		System.out.println("我是登录的切面");
	}
}
