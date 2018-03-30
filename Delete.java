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
public class Delete extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ac = request.getParameter("ac");
		System.out.println(ac);
		Connection con=null;
		ResultSet rs;
		PreparedStatement ps;
		try {
			rs=null;
			con=DBConnection.getConnection();
			ps = con.prepareStatement("delete from bank_user where acno=?");
			
			ps.setString(1,ac);
			rs=ps.executeQuery();
		
			if(rs.next()) {
				
				PrintWriter out = response.getWriter();
				out.println("Account was deleted successfully");
		        request.getRequestDispatcher("admin_home.jsp").forward(request, response);  
			}
			else {
				System.out.println("not found account");
				PrintWriter out = response.getWriter();
				out.println("Account couldnot be deleted");
			//	PrintWriter out;
			//	out.println("login failed");
				request.getRequestDispatcher("admin_home.jsp").forward(request,response);
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
