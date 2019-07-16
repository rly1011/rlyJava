package com.renly.dao;

import java.util.List;

import com.renly.bean.Employee;

public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	public List<Employee> getEmps();
	
}
