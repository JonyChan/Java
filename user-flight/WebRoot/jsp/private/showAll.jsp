<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAll.jsp' starting page</title>
    
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
		<h2 align="center">展示所有联系人</h2>
		<hr/>
		<form>
			<table align="center"width="600">
				<tr>
					<td align="left"  width="20"><a href="/user-flight/jsp/private/Add.jsp"><img src="/user-flight/img/add.png" width="30"/></a></td>
					<td align="right">
					<input type="text" value=""/>
					<input type="submit" value="搜索"/></td>
				</tr>
				</table>
				<table width="600" border="1" cellspacing="0" align="center">
				<tr bgcolor="aqua">
					<td><input type="submit" value="删除选中"></td>
					<td></td>
					<td>ID</td>
					<td>Launch</td>
					<td>Land</td>
					<td>NAME</td>
					<td>Length</td>
					<td>Price</td>
					<td>删除</td>
					<td>修改</td>
				</tr>
				<% 
				List<flight> list = (List<flight>) request.getAttribute("abc");
				for(flight s:list){ %>
				<tr>
					<td><input type="checkbox"/></td>
					<td><img src="/user-flight/img/person2.png" width="30"/></td>
					<td><%=s.getId() %></td>
					<td><%=s.getLaunch() %></td>
					<td><%=s.getLand() %></td>
					<td><%=s.getName() %></td>
					<td><%=s.getLength() %></td>
					<td><%=s.getPrice() %></td>
					<td ><a href="/user-flight/private/delete?id=<%=s.getId()%>">删除</a></td>
					<td ><a href="">修改</a></td>
				</tr>
				<%} %>
			</table>
		</form>
  </body>
</html>
