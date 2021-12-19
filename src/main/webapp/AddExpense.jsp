<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Expense</title>
</head>
<body>
<%
	Connection conn = DBConnection.getConnection();
	Statement statement = conn.createStatement();
	ResultSet rs = statement.executeQuery("select * from category");
%>
	<form action="AddExpenseServlet" method="post">
		Date: <input type="date" name="date"><br><br>
		Category Name: <select name="cateogyId">
		<%
			while(rs.next())
			{
				int categoryId = rs.getInt(1);
				String categoryName = rs.getString(2);
				%>
		<option value="<%=categoryId%>"><%=categoryName%></option>
		<% 
			}
		%>
		</select>
		<!-- <input type="text" name="categoryName"> --> <br><br>
		Sub category Name: <input type="text" name="subcategoryName"> <br><br>
		Expense Name: <input type="text" name="expenseName"> <br><br>
		Amount: <input type="text" name="amount"> <br><br>
		<input type="submit" value="Add New Expense">
	</form>
</body>
</html>