 package com.renly.IOC.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月5日 下午3:01:40   
 */
public class Service {
	@Autowired
	private Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Dao getDao() {
        return dao;
    }

    public void save(){
        System.out.println("Service's save");
        dao.save();
    }
}
