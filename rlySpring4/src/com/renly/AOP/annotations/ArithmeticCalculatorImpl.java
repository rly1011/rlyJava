package com.renly.AOP.annotations;

import org.springframework.stereotype.Component;
/**
 * 
 * @ClassName:  ArithmeticCalculatorImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 任岚杨
 * @date:   2019年7月4日 下午1:49:11   
 *
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
