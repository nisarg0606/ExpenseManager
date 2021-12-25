package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.ExpenseDao;
@WebServlet("/AddExpenseServlet")
public class AddExpenseServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int subcategoryId = Integer.parseInt(request.getParameter("subcategoryId"));
		System.out.println();
		String expenseName = request.getParameter("expenseName");
		float amount = Float.parseFloat(request.getParameter("amount"));
		ExpenseBean expenseBean = new ExpenseBean();
		HttpSession session = request.getSession();
		int id= (Integer) session.getAttribute("id");
		expenseBean.setCategoryId(categoryId);
		expenseBean.setDate(date);
		expenseBean.setSubcategoryId(subcategoryId);
		expenseBean.setExpenseName(expenseName);
		expenseBean.setAmount(amount);
//		System.out.println("U/serId: "+userbean.getUserId());
		System.out.println("Id in AddExpense: "+id);
		expenseBean.setUserId(id);
		
		new ExpenseDao().addExpense(expenseBean);
		
		response.sendRedirect("home.jsp");
	}
}