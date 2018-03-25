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
public class AdminLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pwd = request.getParameter("pwd");
		String id=request.getParameter("id");
		
		Connection con=null;
		ResultSet rs;
		PreparedStatement ps;
		try {
			rs=null;
			con=DBConnection.getConnection();
			ps = con.prepareStatement("select * from admin where id = ? and pwd = ?");
			
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			HttpSession session=request.getSession();  
			session.setMaxInactiveInterval(30);
			if(rs.next()) {
				
		        
		        request.getRequestDispatcher("admin_home.jsp").forward(request, response);  
			}
			else {
				System.out.println("login failed");
			//	PrintWriter out;
			//	out.println("login failed");
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
