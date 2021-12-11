<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateSubCategoryServlet" method="post">
	SubCategory_Name: <input type="text" name="SubCategory_Name" value="${SubCategorybean.subcategoryName}">
		<input type="text" name="Category_ID" value="${SubCategorybean.categoryId}">
		<input type="hidden" name="SubCategory_ID" value="${SubCategorybean.subcategoryId}">
		<input type="submit" value="Update SubCategory">
	</form>
	<br>
	<a href="homeadmin.jsp">Go Back to Home Page</a>
</body>
</html>