package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ElDemoServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setAttribute("email", "nisarg@request.com");
	request.getSession().setAttribute("email", "nisarg@session.com");
	request.getServletContext().setAttribute("email", "nisarg@application.com");
	request.getRequestDispatcher("ELDemo.jsp").forward(request, response);
}
}