package com.renly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renly.bean.Employee;
import com.renly.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	public List<Employee> getEmps(){
		return employeeMapper.getEmps();
	}

}
