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
<title>Add New Sub-Category</title>
</head>
<body>
	<%
	Connection conn = DBConnection.getConnection();
	Statement statement = conn.createStatement();
	ResultSet rs = statement.executeQuery("select * from category");
	%>
	<form action="AddSubCategoryServlet" method="get">
		Sub-Category Name: <input type="text" name="subcategoryName">
		Select Category: <select name="categoryId">
			<%
			while (rs.next()) {
				String categoryName = rs.getString(2);
				int categoryId = rs.getInt(1);
			%>
			<option value="<%=categoryId%>"><%=categoryName%></option>
			<%
			}
			%>
		</select> <br> <input type="submit" name="submit"
			value="Add New Sub Category">
	</form>
</body>
</html>