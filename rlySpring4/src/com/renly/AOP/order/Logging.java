 package com.renly.AOP.order;

import org.springframework.stereotype.Component;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月4日 下午4:09:04   
 */
 @Component("logging")
public class Logging {
	
	public void test() {
		System.out.println("正在登录。。。。。");
	}
	

}
