<%@page import="com.bean.ExpenseBean"%>
<%@page import="com.dao.CategoryDao"%>
<%@page import="com.bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	ArrayList<CategoryBean> categories = new CategoryDao().getAllCategories();
	ExpenseBean expenseBean = (ExpenseBean) request.getAttribute("bean");
	int cid = expenseBean.getCategoryId();
	int subid = expenseBean.getSubcategoryId();
	%>
	<form action="UpdatExpenseServlet" method="post">
		Expense Name: <input type="text" name="name"
			value="${bean.expenseName}" /> <Br> Category Name:<select
			name="categoryId" id="categoryId" onchange="getAllSubCategory()">
			<option value="-1">Select Category</option>
			<%
			for (CategoryBean c : categories) {
			%>
			<option <%=c.getCategoryId() == cid ? "selected=selected" : "xd"%>
				value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
			<%
			}
			%>
		</select><Br> SubCategory Name: <select id="subcategoryId"
			name="subcategoryId">
			<option value="-1" selected="${bean.subcategoryId }">Select
				Sub-Category</option>

		</select><Br> Amount: <input type="text" name="amount"
			value="${bean.amount}" /> <Br> <input type="hidden"
			name="expenseId" value="${bean.expenseId}"> <input
			type="submit" value="Update Expense">
	</form>

	<br>
	<a href="HomeServlet">Go back to home page</a>
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
					$("#subcategoryId").append(
							"<option value='-1'>Select Sub-Category</option>");
					for (i = 0; i < data.length; i++) {
						let dd = data[i].split("=");
						console.log(dd[0]);
						console.log(dd[1]);
						$("#subcategoryId").append(
								"<option value="+dd[0]+">" + dd[1]
										+ "</option>")

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