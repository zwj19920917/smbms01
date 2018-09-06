<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'V303.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <form action="load" method="post">
        	<p>用户名:<input type="text"  name="name"/><fm:errors path="stu.name" /> </p>
        	<p>密码:<input type="password"  name="password"/><fm:errors path="stu.password" /></p>
        	<p>邮箱:<input type="text"  name="email"/><fm:errors path="stu.email" /></p>
        	<p>出生日期:<input type="text"  name="birthday"/><fm:errors path="stu.birthday" /></p>
        	<p><input type="submit" value="提交" /> </p>
     </form>
  </body>
</html>
