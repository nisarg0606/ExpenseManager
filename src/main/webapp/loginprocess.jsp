<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.UserDao" %>
<jsp:useBean id="obj" class="com.bean.UserBean"/>
<jsp:setProperty property="*" name="obj"/>
<!DOCTYPE html>
<html>	
<head>
<meta charset="ISO-8859-1">
<title>Login Process</title>
</head>
<body>
<%
boolean status = UserDao.validate(obj);
RequestDispatcher rd = null;
if (status) {
	//out.println("You are Successfully Logged in");
	session.setAttribute("session", "true");
	rd = request.getRequestDispatcher("home.jsp");
} else {
	out.print("Sorry, email or password error");
	rd = request.getRequestDispatcher("fail.jsp");
}
rd.forward(request, response);
%>
</body>
</html>