<%@page import="com.dao.CategoryDao"%>
<%@page import="com.bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	ArrayList<CategoryBean> categories = new CategoryDao().getAllCategories();
	%>
	<form action="AddExpenseServlet" method="post">
		Date: <input type="date" name="date"><br>
		<br> Category Name: <select name="categoryId" id="categoryId"
			onchange="getAllSubCategory()">
			<option value="-1">Select Category</option>
			<%
			for (CategoryBean c : categories) {
			%>
			<option value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
			<%
			}
			%>
		</select> <br>
		<br> Sub category Name: <select id="subcategoryId"
			name="subcategoryId">
			<option value="-1">Select Sub-Category</option>

		</select><br>
		<br> Expense Name: <input type="text" name="expenseName">
		<br>
		<br> Amount: <input type="text" name="amount"> <br>
		<br> <input type="submit" value="Add New Expense">
	</form>
	<script type="text/javascript">
		function getAllSubCategory() {
			let categoryId = document.getElementById("categoryId").value;
			let data = {
				"categoryId" : categoryId
			}

			$.ajax({
				url : "GetAllSubCatByCatId",
				data : data,
				success : function(result) {
					console.log(result);
					let str = result;
					str = str.substring(1, str.length - 1);
					let data = str.split(",");
					$("#subcategoryId").empty();
					$("#subcategoryId").append("<option value='-1'>Select Sub-Category</option>");
					for (i = 0; i < data.length; i++) {
						let dd = data[i].split("=");
						console.log(dd[0]);
						console.log(dd[1]);
						$("#subcategoryId").append("<option value="+dd[0]+">" + dd[1] + "</option>")

					}
				},
				error : function(error) {
					console.log(err);
				}

			});
		}
	</script>
</body>
</html>