package com;
import java.io.*;

import java.sql.*;
import java.text.*;
import java.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;



import java.util.*;
import com.DBConnection;
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pwd = request.getParameter("pwd");
		String uname=request.getParameter("uname");
		
		Connection con=null;
		ResultSet rs;
		PreparedStatement ps;
		try {
			rs=null;
			con=DBConnection.getConnection();
			ps = con.prepareStatement("select * from bank_user where name = ? and pwd = ?");
			
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			HttpSession session=request.getSession();  
			session.setMaxInactiveInterval(30);
			if(rs.next()) {
				
		        session.setAttribute("name",rs.getString("name"));
		        session.setAttribute("acno", String.valueOf(rs.getInt("acno")));
		        session.setAttribute("bal", String.valueOf(rs.getInt("bal")));
		        System.out.println(rs.getString("name"));
		        System.out.println(rs.getString("acno"));
		        System.out.println(rs.getString("bal"));
		        request.getRequestDispatcher("home.jsp").forward(request, response);  
			}
			else {
				System.out.println("login failed");
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
