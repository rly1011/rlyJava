 package com.renly.cache;

import com.renly.bean.Department;

public interface DepartmentMapperCache {
	public Department getDeptById(Integer id);
	public Department getDeptByIdPlus(Integer id);
	public Department getDeptByIdStep(Integer id);

}
