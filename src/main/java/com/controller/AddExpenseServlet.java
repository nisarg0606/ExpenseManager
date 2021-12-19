package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ExpenseBean;

public class AddExpenseServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String categoryName = request.getParameter("categoryName");
		String subcategoryName = request.getParameter("subcategoryName");
		String expenseName = request.getParameter("expenseName");
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		ExpenseBean expenseBean = new ExpenseBean();
		
		expenseBean.setDate(date);
		expenseBean.set
		
	}
}
