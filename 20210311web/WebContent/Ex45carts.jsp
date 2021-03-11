<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="cart" scope="session" class="beans.Ex45myBean"/>
<jsp:setProperty property="*" name="cart"/>
<% cart.processRequest(); %>

<br> You have the following items in your cart:
<%
String[] items = cart.getItems();
pageContext.setAttribute("carts", items);//讓物件變成可以讓EL語法使用
%>

<o1>
	<c:forEach var="current" items="${carts}">
		<li>
			<c:out value="${current }"/>
		</li>
	</c:forEach>
</o1>


</body>
</html>