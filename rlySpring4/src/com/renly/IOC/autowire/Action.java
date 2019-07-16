 package com.renly.IOC.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月5日 下午3:01:57   
 */
public class Action {
	 @Autowired
	 private Service service;

	    public void setService(Service service) {
	        this.service = service;
	    }

	    public Service getService() {
	        return service;
	    }

	    public void execute(){
	        System.out.println("Action's execute...");
	        service.save();
	    }
}
