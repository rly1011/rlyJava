 package com.renly.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.renly.bean.EmpStatus;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月15日 上午11:12:35   
 */
public class MyEnumEmpStatusTypeHandler implements TypeHandler<EmpStatus> {

	@Override
	public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
		//需要根据从数据库中拿到的枚举的状态码返回一个枚举对象
		int code = rs.getInt(columnName);
		System.out.println("从数据库中获取的状态码："+code);
		EmpStatus status = EmpStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public EmpStatus getResult(ResultSet rs, int columnIndex)
			throws SQLException {
		int code = rs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码："+code);
		EmpStatus status = EmpStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public EmpStatus getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		int code = cs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码："+code);
		EmpStatus status = EmpStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType arg3) throws SQLException {
		System.out.println("要保存的状态码："+parameter.getCode());
		ps.setString(i, parameter.getCode().toString());
		 
	}

}
