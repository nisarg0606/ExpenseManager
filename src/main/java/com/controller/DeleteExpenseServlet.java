package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConnection;
@SuppressWarnings("serial")
@WebServlet("/DeleteExpenseServlet")
public class DeleteExpenseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ExpenseId = Integer.parseInt(request.getParameter("Expense_ID"));
		int i = -1;
		try {
			
			//in daoo
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from expense where Expense_ID=?");
			pstmt.setInt(1, ExpenseId);
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = null;
		
		if(i == 1)
		{
			rd =request.getRequestDispatcher("HomeServlet");
		}
		else {
			request.setAttribute("error", "Invalid Expense Id");
			rd = request.getRequestDispatcher("fail.jsp");
		}
		
		rd.forward(request, response);
	}
}

