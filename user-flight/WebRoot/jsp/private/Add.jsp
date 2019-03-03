<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Add.jsp' starting page</title>
    
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
     <!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>This is my homework</title>
	</head>
	<body>
		<h2 align="center">增加航班</h2>
		<hr/>
		<form action="/user-flight/private/add">
			<table align="center"width="600">
				<tr>
					<td>id<input type="text" value="" name ="id"/></td>
				</tr>
				<tr>
					<td>Lau<input type="text" value="" name ="lau"/></td>
				</tr>
				<tr>
					<td>lan<input type="text" value="" name ="lan"/></td>
				</tr>
				<tr>
					<td>Nam<input type="text" value="" name ="name"/></td>
				</tr>
				<tr>
					<td>Len<input type="text" value="" name ="len"/></td>
				</tr>
				<tr>
					<td>pri<input type="text" value="" name ="price"/></td>
				</tr>
				<tr>
				<td><input align="center" type="submit" value="添加"/></td>
				</tr>
				</table>
				
		</form>
  </body>
</html>
