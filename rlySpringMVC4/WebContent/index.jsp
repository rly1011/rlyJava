<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello SpringMVC</h1>

	<a href="test2">Test RequestMapping</a>
	<br>
	<br>
	<a href="testParamsAndHeaders?username=rly&age=12">Test ParamsAndHeaders</a>
	<br><br>
	<a href="testAntPath/XXXXXmnxyz/abc">Test AntPath</a>
	<br><br>
	<a href="testPathVariable/1">Test PathVariable</a>
	<br><br>
	<a href="testRequestParam?username=熊大&age=11">测试请求参数</a>
	<br><br>
	<a href="testRequestHeader">测试请求头参数</a>
	<br><br>
	<a href="testCookieValue">测试cookie请求头参数</a>
	<br><br>
	<h4>测试POJO作为参数，包括级联参数</h4>
		<form action="testPojo" method="post">
		username: <input type="text" name="username"/>
		<br>
		password: <input type="password" name="password"/>
		<br>
		email: <input type="text" name="email"/>
		<br>
		age: <input type="text" name="age"/>
		<br>
		city: <input type="text" name="address.city"/>
		<br>
		province: <input type="text" name="address.province"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>

	<a href="testServletAPI">测试servlet原生属性</a>
	<br><br>
	<a href="testModelAndView">测试目标方法的返回值是 ModelAndView类型</a>
	<br><br>
	
	<a href=testMap>目标方法可以添加 Map类型</a>
	<br><br>
	
	<a href=testSessionAttributes>session设值</a>
	<br><br>
	
	<!--  
		模拟修改操作
		1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
		2. 密码不能被修改.
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	-->
	<form action="testModelAttribute" method="Post">
		<input type="hidden" name="id" value="1"/>
		username: <input type="text" name="username" value="Tom"/>
		<br>
		email: <input type="text" name="email" value="tom@163.com"/>
		<br>
		age: <input type="text" name="age" value="12"/>
		<br>
		<input type="submit" value="Submit"/>
	</form>
	<br><br>
	<a href=testView>自定义视图</a>
	<br><br>
	<a href="testRedirect">重定向</a>
	<br><br>
	
	<a href="success">直接转发，不过hander</a>
	<br><br>
	
	<a href="emps">获取所有数据</a>
	<br><br>
	
</body>
</html>