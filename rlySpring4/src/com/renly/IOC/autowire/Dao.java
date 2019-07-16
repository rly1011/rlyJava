 package com.renly.IOC.autowire;


/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月5日 下午3:01:07   
 */
public class Dao {
	private String dataSource = "dbcp";

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public void save(){
        System.out.println("save by " + dataSource);
    }

    public Dao() {
        System.out.println("Dao's Constructor...");
    }
}
