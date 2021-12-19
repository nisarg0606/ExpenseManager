package com.controller;

import java.io.IOException;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.ExpenseDao;
import com.dao.UserDao;
// import com.util.DBConnection;

@WebServlet("/EditExpenseServlet")
public class EditExpenseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int expenseId = Integer.parseInt(request.getParameter("Expense_ID"));
		ExpenseDao dao = new ExpenseDao();
		ExpenseBean bean = dao.getExpenseById(expenseId);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("EditExpense.jsp").forward(request, response);
	}
}
