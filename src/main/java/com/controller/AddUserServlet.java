package com.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("full-name");
		String email = request.getParameter("your-email");
		String password = request.getParameter("password");
		
		UserBean userBean = new UserBean();
		userBean.setName(name);
		userBean.setEmail(email);
		userBean.setPassword(password);
		
		int i = 0;
		
		UserDao userDao = new UserDao();
		i = userDao.insertUser(name, email, password);
		i = userDao.insertUser(userBean);
		
		RequestDispatcher rd = null;
		if(i == 1)
		{
			rd = request.getRequestDispatcher("login.jsp");
		}else {
			rd = request.getRequestDispatcher("fail.jsp");
		}
		rd.forward(request, response);
		
	}
}
