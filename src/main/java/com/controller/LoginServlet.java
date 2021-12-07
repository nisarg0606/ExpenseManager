package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
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
		boolean type = UserDao.User_Type(userBean);
		String name = UserDao.User_name(userBean);
		if(status)
		{
			if(type)
			{
				rd = request.getRequestDispatcher("homeadmin.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("username", name);
			}
			else
			{
				rd = request.getRequestDispatcher("home.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("username", name);
			}
		}
		else {
			rd = request.getRequestDispatcher("fail.jsp");
		}
		
		rd.forward(request, response);
		
	}
}
