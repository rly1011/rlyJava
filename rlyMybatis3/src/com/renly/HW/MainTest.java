 package com.renly.HW;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.renly.atuoMap.EmployeeMapperPlus;
import com.renly.bean.Employee;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月9日 上午9:28:54   
 */
public class MainTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/*
	 * 测试
	 */
	@Test
	public void test() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// 3、获取接口的实现类对象
			//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(21);
			System.out.println(employee);
		} finally {
			openSession.close();
		}
		
	}
	
	/*
	 * 测试CRUD
	 */
	@Test
	public void testCRUD() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
				EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
				//3.1、 新增数据
//				Employee employee = new Employee(null,"BB","BB@163.com","0");
//				mapper.addEmp(employee);
//				//3.2、删除数据
//				Boolean relest= mapper.delEmpById(4);
//				System.out.println(relest);
				
				//3.3、修改数据
//				Employee employee = new Employee(26, "Tom", "jerry@163.com", "0");
//				boolean updateEmp = mapper.updateEmp(employee);
//				System.out.println(updateEmp);
				
				//3.4 查询数据
				
				//3.4.1 多参数查询
//				Employee employee = mapper.getEmpByIdAndLastName(21, "Tom");
//				System.out.println(employee);
				
				//3.4.1 多参数Map查询
				Map<String, Object> map = new HashMap<>();
				map.put("id", 21);
				map.put("lastName", "Tom");
				Employee employee = mapper.getEmpByMap(map);
				System.out.println(employee);
				
			} finally {
				//4、手动提交数据
//				openSession.commit();
				
				openSession.close();
			}
		
	}
	
	
	


}
