package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.DBConnection;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		UserBean userBean = new UserBean();	
		userBean.setEmail(username);
		userBean.setPassword(password);
		boolean status = UserDao.validate(userBean);
		RequestDispatcher rd= null;
		boolean type = UserDao.User_Type(userBean);//modify validate method so you will get all user info at once no need to call database query more than one in login 
		String name = UserDao.User_name(userBean);
		int id = UserDao.User_id(userBean);
		if(status)
		{
			if(type)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", name);
				rd = request.getRequestDispatcher("homeadmin.jsp");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", name);
				session.setAttribute("id", id);
				try {
					
					//read all expense using dao and bean 
					Connection conn = DBConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement("select category.Category_Name, sub_category.SubCategory_Name, Expense_ID, Expense_Name, Amount from expense JOIN category on category.Category_ID = expense.Category_ID JOIN sub_category ON sub_category.SubCategory_ID = expense.SubCategory_ID where expense.User_id = "+id);
					ResultSet rs = pstmt.executeQuery();
					request.setAttribute("expenseTable", rs);
				} catch (Exception e) {
					
				}
				rd = request.getRequestDispatcher("home.jsp");
			}
		}
		else {
			rd = request.getRequestDispatcher("fail.jsp");
		}
		
		rd.forward(request, response);
		
	}
}
