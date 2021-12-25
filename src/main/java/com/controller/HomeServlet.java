package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ExpenseBean;
import com.dao.ExpenseDao;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		ExpenseDao expdao = new ExpenseDao();
		ArrayList<ExpenseBean> expenses = expdao.getAllExpensebyUserId(id);
		request.setAttribute("expenses", expenses);

		ArrayList<ExpenseBean> exp = expdao.getAllExpensebyUserId(id);// 2 food 2auto 1 travel

		HashMap<String, Float> expMap = new HashMap<String, Float>();// food->250+350 auto->250+100 travel->200

		for (ExpenseBean e : exp) {// f f a t a

			// {food:600,auto:350,travel:200}

			if (expMap.get(e.getCategoryName()) == null) {
				expMap.put(e.getCategoryName(), e.getAmount());
			} else {

				expMap.put(e.getCategoryName(), expMap.get(e.getCategoryName()) + e.getAmount());
			}
		}

		request.setAttribute("exp", exp);
		request.setAttribute("expMap", expMap);

		request.getRequestDispatcher("home.jsp").forward(request, response);

	}
}
