 package com.renly.atuoMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.renly.bean.Department;
import com.renly.bean.Employee;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月10日 下午2:50:58   
 */
public class AtuoMapMainTest {
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/*
	 * 自定义映射
	 */
	@Test
	public void testAutoMap() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperPlus mapperPlus = openSession.getMapper(EmployeeMapperPlus.class);
			
//			Employee employee = mapperPlus.getEmpById(21);
//			Employee employee = mapperPlus.getEmpAndDept(20);
//			Employee employee = mapperPlus.getEmpByIdStep(21);
//			List<Employee> employees = mapperPlus.getEmpsByDeptId(1);
			Employee employee = mapperPlus.getGender2(23);
			System.out.println(employee);
			
			DepartmentMapper departmentMapper= openSession.getMapper(DepartmentMapper.class);
//			Department department = departmentMapper.getDeptById(1);
//			Department department = departmentMapper.getDeptByIdPlus(1);
//			Department department = departmentMapper.getDeptByIdStep(1);
//			System.out.println(department);
		} finally {
			openSession.close();
		}
		
	}

}
