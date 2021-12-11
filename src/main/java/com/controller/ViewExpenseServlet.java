package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConnection;

@WebServlet("/ViewExpenseServlet")
public class ViewExpenseServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CategoryID = Integer.parseInt(request.getParameter("Expense_ID"));
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("Select * from Expense where Expense_ID=?");
			pstmt.setInt(1, CategoryID);
			
			ResultSet rs = pstmt.executeQuery();
			request.setAttribute("rs", rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ViewExpense.jsp").forward(request, response);
	}
}
