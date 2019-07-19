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
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url = this.href;
			var args = {};
			$.post(url, args, function(data){
				for(var i = 0; i < data.length; i++){
					var id = data[i].id;
					var lastName = data[i].lastName;
					
					alert(id + ": " + lastName);
				}
			});
			return false;
		});
	})
</script>

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
	
	
		
	<a href="testJson" id="testJson">测试 Json</a>
	<br><br>
	
	<h4>测试Converter</h4>
		<form action="testHttpMessageConverter" method="POST" enctype="multipart/form-data">
		File: <input type="file" name="file"/>
		Desc: <input type="text" name="desc"/>
		<input type="submit" value="Submit"/>
	</form>
	
	<a href="testResponseEntity">Test ResponseEntity</a>
	
	
	<!--  
		关于国际化:
		1. 在页面上能够根据浏览器语言设置的情况对文本(不是内容), 时间, 数值进行本地化处理
		2. 可以在 bean 中获取国际化资源文件 Locale 对应的消息
		3. 可以通过超链接切换 Locale, 而不再依赖于浏览器的语言设置情况
		
		解决:
		1. 使用 JSTL 的 fmt 标签
		2. 在 bean 中注入 ResourceBundleMessageSource 的示例, 使用其对应的 getMessage 方法即可
		3. 配置 LocalResolver 和 LocaleChangeInterceptor
	-->	
	<br><br>
	<a href="i18n">I18N PAGE</a>
	
	<h1>文件上传</h1>
	<form action="testFileUpload" method="POST" enctype="multipart/form-data">
		File: <input type="file" name="file"/>
		Desc: <input type="text" name="desc"/>
		<input type="submit" value="Submit"/>
	</form>
	
	
</body>
</html>