 package com.renly.bean;

import java.util.List;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月10日 下午2:46:01   
 */
public class Department {
	private Integer id;
	private String departmentName;
	private List<Employee> emps;
	
	
	
	public Department(Integer id) {
		super();
		this.id = id;
	}

	public Department() {
		super();
	}
	
	public Department(Integer id, String departmentName, List<Employee> emps) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.emps = emps;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", emps=" + emps + "]";
	}
	
	
	

}
