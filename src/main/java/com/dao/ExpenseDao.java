package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.bean.CategoryBean;
import com.bean.ExpenseBean;
import com.util.DBConnection;

public class ExpenseDao {
	public ExpenseBean getExpenseById(int ExpenseId) {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select *from expense where Expense_ID=?");
			pstmt.setInt(1, ExpenseId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			ExpenseBean eb = new ExpenseBean();
			eb.setExpenseId(rs.getInt("Expense_ID"));
			eb.setCategoryId(rs.getInt("Category_ID"));
			eb.setUserId(rs.getInt("Uset_id"));
			eb.setSubcategoryId(rs.getInt("SubCategory_ID"));
			eb.setExpenseName(rs.getString("Expense_Name"));
			eb.setAmount(rs.getFloat("Amount"));
			return eb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int addExpense(ExpenseBean expenseBean)
	{
		int i = -1;
		try {
			System.out.println("userID"+ expenseBean.getUserId());
			System.out.println("CategoryID: "+ expenseBean.getCategoryId());
			System.out.println("SubCategory_ID: "+expenseBean.getSubcategoryId());
			System.out.println("ExpenseName: "+expenseBean.getExpenseName());
			System.out.println("Amount: "+expenseBean.getAmount());
			System.out.println(expenseBean.getDate());
			Connection conn = DBConnection.getConnection();
			System.out.println("Hello : "+expenseBean.getUserId()+"  "+expenseBean.getDate());
			PreparedStatement pstmt = conn.prepareStatement("insert into expense (User_id, Category_ID, SubCategory_ID, Expense_Name, Amount, Date) values (?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, expenseBean.getUserId());
			pstmt.setInt(2, expenseBean.getCategoryId());
			pstmt.setInt(3, expenseBean.getSubcategoryId());
			pstmt.setString(4, expenseBean.getExpenseName());
			pstmt.setFloat(5, expenseBean.getAmount());
			pstmt.setString(6, expenseBean.getDate());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Something Went Wrong in adding expense in ExpenseDao..");
			e.printStackTrace();
		}
		
		return i;
	}
	
	public ArrayList<ExpenseBean> getAllExpensebyUserId(int userid){
		ArrayList<ExpenseBean> expenseData = new ArrayList<ExpenseBean>();
		try {
			;
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select Date, category.Category_Name, sub_category.SubCategory_Name, Expense_ID, Expense_Name, Amount from expense JOIN category on category.Category_ID = expense.Category_ID JOIN sub_category ON sub_category.SubCategory_ID = expense.SubCategory_ID where expense.User_id = "+ userid + " order by expense.Expense_ID");
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {

				while (rs.next()) {
					ExpenseBean expenseBean = new ExpenseBean();
//					String date = rs.getString(1);
					expenseBean.setDate(rs.getString(1));
//					String categoryname = rs.getString(2);
					expenseBean.setCategoryName(rs.getString(2));
//					String subcategoryname = rs.getString(3);
					expenseBean.setSubcategoryName(rs.getString(3));
//					String expensename = rs.getString(5);
					expenseBean.setExpenseName(rs.getString(5));
//					float amount = rs.getFloat(6);
					expenseBean.setAmount(rs.getFloat(6));
//					int expenseid = rs.getInt(4);
					expenseBean.setExpenseId(rs.getInt(4));
					expenseData.add(expenseBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expenseData;
	}
}
