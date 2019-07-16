 package com.renly.pageHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renly.bean.Employee;

/**
 * @author 任岚杨
 * @date 2019年7月15日 上午10:02:27   
 */
public class MainTestPage {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testPage() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperPage mapper = openSession.getMapper(EmployeeMapperPage.class);
			PageHelper.startPage(2, 10);
			List<Employee> emps = mapper.getEmps();
			//传入要连续显示多少页
			PageInfo<Employee> info = new PageInfo<>(emps, 10);
			for (Employee employee : emps) {
				System.out.println(employee);
			}
			System.out.println("当前页码："+info.getPageNum());
			System.out.println("总记录数："+info.getTotal());
			System.out.println("每页的记录数："+info.getPageSize());
			System.out.println("总页码："+info.getPages());
			System.out.println("是否第一页："+info.isIsFirstPage());
			System.out.println("连续显示的页码：");
			int[] nums = info.getNavigatepageNums();
			for (int i = 0; i < nums.length; i++) {
				System.out.println(nums[i]);
			}
		} finally {
			openSession.close();
		}

	}
}
