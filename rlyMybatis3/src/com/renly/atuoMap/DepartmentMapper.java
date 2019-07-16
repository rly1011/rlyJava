 package com.renly.atuoMap;

import com.renly.bean.Department;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月11日 下午2:54:38   
 */
public interface DepartmentMapper {
	public Department getDeptById(Integer id);
	public Department getDeptByIdPlus(Integer id);
	public Department getDeptByIdStep(Integer id);

}
