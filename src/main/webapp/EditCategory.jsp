<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateCategoryServlet" method="post">
	Category_Name: <input type="text" name="Category_Name" value="${Categorybean.categoryName}">
		<input type="hidden" name="Category_ID" value="${Categorybean.categoryId}">
		<input type="submit" value="Update Category">
	</form>
	<br>
	<a href="homeadmin.jsp">Go Back to Home Page</a>
</body>
</html>