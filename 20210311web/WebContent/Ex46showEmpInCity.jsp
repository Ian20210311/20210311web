<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<%
		ArrayList<beans.Ex46simpleEmp> list=new ArrayList<beans.Ex46simpleEmp>();
		list=(ArrayList<beans.Ex46simpleEmp>)session.getAttribute("emps");
		for(beans.Ex46simpleEmp ep:list){
		%>
			<tr>
			<td><%= ep.getId()%></td>
			<td><%= ep.getFname()%></td>
			<td><%= ep.getLname()%></td>
			<td><%= ep.getEmail()%></td>
			</tr>
		<%
		}
		%>
	</table>

</body>
</html>