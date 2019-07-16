 package com.renly.HW;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.renly.bean.Employee;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月9日 上午9:54:40   
 */
public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	/*
	 * 增加用户
	 */
	public void addEmp(Employee employee); 
	
	/*
	 * 删除用户
	 */
	public boolean delEmpById(Integer id);
	
	/*
	 * 修改
	 */
	public boolean updateEmp(Employee employee);
	
	/*
	 * 多参数查询
	 */
	public Employee getEmpByIdAndLastName(@Param("id")int id,@Param("lastName") String lastName);  
	
	/*
	 * 多参数Map查询
	 */
	public Employee getEmpByMap(Map<String, Object> map);
}
