 package com.renly.dynamicSQL;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.renly.atuoMap.DepartmentMapper;
import com.renly.atuoMap.EmployeeMapperPlus;
import com.renly.bean.Department;
import com.renly.bean.Employee;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月12日 上午10:50:18   
 */
public class DynamicSQLMainTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testDynamicSQL() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(21, "求求其其切Tomaaaa", null, null,null);
//			List<Employee> list=mapper.getEmpsByConditionIf(employee);
//			for (Employee emp : list) {
//				System.out.println(emp);
//			}
//			mapper.updateEmp(employee);
//			List<Integer> list = new ArrayList<Integer>();
//			list.add(21);
//			list.add(22);
//			List<Employee> list2=mapper.getEmpsByConditionForeach(list);
//			for (Employee emp : list2) {
//				System.out.println(emp);
//			}
			
			//bing的用法，有疑惑
//			List<Employee> list = mapper.getEmpsTestInnerParameter(employee);
//			for (Employee e : list) {
//				System.out.println(e);
//			}
			
			
			//批量保存
			List<Employee> emps = new ArrayList<>();
			emps.add(new Employee(null, "smith0x1", "smith0x1@atguigu.com", "1",new Department(1, null, emps)));
			emps.add(new Employee(null, "allen0x1", "allen0x1@atguigu.com", "0",new Department(1)));
			mapper.addEmps(emps);
			
		} finally {
			openSession.close();
		}
		
	}

}
