<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Category</title>
</head>
<body>
	<form action="AddCategoryServlet" method="post">
	Category Name: <input type="text" name="categoryName">
	<br>
	<br>
	<input type="submit" name="submit" value="Add New Category">
	</form>
</body>
</html>