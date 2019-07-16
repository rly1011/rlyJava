 package com.renly.typeHandler;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.renly.bean.EmpStatus;
import com.renly.bean.Employee;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月15日 上午11:19:55   
 */
public class MainTestEnum {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testEnumUse(){
		EmpStatus login = EmpStatus.LOGIN;
		System.out.println("枚举的索引："+login.ordinal());
		System.out.println("枚举的名字："+login.name());
		
		System.out.println("枚举的状态码："+login.getCode());
		System.out.println("枚举的提示消息："+login.getMsg());
	}
	
	
	/**
	 * 默认mybatis在处理枚举对象的时候保存的是枚举的名字：EnumTypeHandler
	 * 改变使用：EnumOrdinalTypeHandler：
	 * @throws IOException
	 */
	@Test
	public void testEnum() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapperEnum mapper = openSession.getMapper(EmployeeMapperEnum.class);
//			Employee employee = new Employee(null,"test_enum", "enum@163.com","1");
			//mapper.addEmp(employee);
			//System.out.println("保存成功"+employee.getId());
			//openSession.commit();
			Employee empById = mapper.getEmpById(41);
			System.out.println(empById.getEmpStatus());
		}finally{
			openSession.close();
		}
	}
}
