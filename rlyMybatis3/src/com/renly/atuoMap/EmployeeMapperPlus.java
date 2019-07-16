 package com.renly.atuoMap;

import java.util.List;

import com.renly.bean.Employee;


/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月10日 下午2:17:46   
 */
public interface EmployeeMapperPlus {

	public Employee getEmpById(Integer id);
	
	public Employee getEmpAndDept(Integer id);
	
	public Employee getEmpByIdStep(Integer id);
	
	public List<Employee> getEmpsByDeptId(Integer deptId);
	
	public Employee getGender2(Integer id);
	
}
