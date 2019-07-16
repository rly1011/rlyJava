package com.renly.AOP.annotations;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * 
 * @ClassName:  LoggingAspect   
 * @Description:TODO(切面示例)   
 * @author: 任岚杨
 * @date:   2019年7月4日 下午1:48:42   
 *
 */
@Aspect
@Component
public class LoggingAspect {
	@Before("execution(public int com.renly.AOP.ArithmeticCalculator.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName= joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        System.out.println("The method"+methodName+" begins with"+ Arrays.asList(args) );
    }
	
	@After("execution(* com.renly.AOP.*.*(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
}
