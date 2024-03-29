package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.UserDataHandler;

import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {
	public int insertUser(UserBean userBean) {
		int i = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into users (name, email, password) values (?,?,?)");
			pstmt.setString(1, userBean.getName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ResultSet getAllUser() {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from users");
			ResultSet rsd = pstmt.executeQuery();
			return rsd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<UserBean> getAllUsers(){
		ArrayList<UserBean> usd = new ArrayList<UserBean>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from users");
			ResultSet rsd = pstmt.executeQuery();
			while(rsd.next())
			{
				UserBean userdata = new UserBean();
				userdata.setUserId(rsd.getInt(1));
				userdata.setName(rsd.getString(2));
				userdata.setEmail(rsd.getString(3));
				userdata.setUserType(rsd.getShort(5));
				usd.add(userdata);
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return usd;
	}
	public int insertUser(String name, String email, String password) {
		return 0;
	}

	public static boolean validate(UserBean userBean) {
		// int i = -1;
		boolean status = false;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("Select * from users where email=? AND Password=?");
			pstmt.setString(1, userBean.getEmail());
			pstmt.setString(2, userBean.getPassword());
			ResultSet rs = pstmt.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean User_Type(UserBean bean) {
		boolean type = false;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("Select User_Type from users where email=? AND Password=?");
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				type = rs.getBoolean(1);
				System.out.println(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}

	public static String User_name(UserBean userBean) {
		String name = "";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("Select Name from users where Email=? AND Password=?");
			pstmt.setString(1, userBean.getEmail());
			pstmt.setString(2, userBean.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	public static int User_id(UserBean userBean) {
		int id = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("Select User_id from users where email=? AND Password=?");
			pstmt.setString(1, userBean.getEmail());
			pstmt.setString(2, userBean.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
//				System.out.println(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public UserBean getUserById(int UserId) {
		try {
			Connection conn = DBConnection.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from users where User_Id = ?");
			pstmt.setInt(1, UserId);

			ResultSet rs = pstmt.executeQuery();// data
			rs.next(); // jump
			UserBean ub = new UserBean();

//			sb.setStudentId(rs.getInt("studentId"));
//			sb.setFirstName(rs.getString("firstName"));
//			sb.setEmail(rs.getString("email"));
//			sb.setPassword(rs.getString("password"));
			ub.setUserId(rs.getInt("User_id"));
			ub.setName(rs.getString("Name"));
			ub.setEmail(rs.getString("email"));
			ub.setPassword(rs.getString("Password"));
			return ub;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int UpdateUser(UserBean userBean) {
		int i = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update users set Name=?, email=?, Password=? where User_id=?");
			pstmt.setString(1, userBean.getName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());
			pstmt.setInt(4, userBean.getUserId());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}