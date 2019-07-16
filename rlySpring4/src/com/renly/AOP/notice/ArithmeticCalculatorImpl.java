 package com.renly.AOP.notice;

import org.springframework.stereotype.Component;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月4日 下午2:05:30   
 */
 @Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
	@Override
	public int add(int i, int j) {
		return i+j;
	}
	@Override
	public int sub(int i, int j) {
		return i-j;
	}

	@Override
	public int mul(int i, int j) {
		return i*j;
	}

	@Override
	public int div(int i, int j) {
		return i/j;
	}

}
