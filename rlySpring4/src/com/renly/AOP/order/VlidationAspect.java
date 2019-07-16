 package com.renly.AOP.order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: 验证切面 
 * @author 任岚杨
 * @date 2019年7月4日 下午3:58:07   
 */
@Order(2)
@Component
@Aspect
public class VlidationAspect {
	/*
	 * 用于声明切面表达式，一般地，该方法中不再需要添加其他的代码
	 */
	@Pointcut("execution(* com.renly.AOP.order.Logging.*(..))")
	public void declareJointPointExpression() {
	}
	
	@Before(value = "declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("我是验证的切面");
	}
}
