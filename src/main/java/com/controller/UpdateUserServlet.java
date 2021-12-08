package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Name = request.getParameter("name");
		String email = request.getParameter("email");
		String Password = request.getParameter("password");
		int userId = Integer.parseInt(request.getParameter("User_id"));

		UserBean userBean = new UserBean();
		userBean.setName(Name);
		userBean.setEmail(email);
		userBean.setPassword(Password);
		userBean.setUserId(userId);

		int i = 0;

		UserDao userDao = new UserDao();
		i = userDao.UpdateUser(userBean);

		RequestDispatcher rd = null;
		if (i == 1) {
			rd = request.getRequestDispatcher("homeadmin.jsp");
		} else {
			rd = request.getRequestDispatcher("fail.jsp");
		}
		rd.forward(request, response);
	}
}
