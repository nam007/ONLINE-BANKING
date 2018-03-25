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
public class Regis extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		int acno=Integer.parseInt(request.getParameter("acno"));
		
		Connection con=null;
		
		PreparedStatement ps,ps2;
		try {
			con=DBConnection.getConnection();
			ps = con.prepareStatement("Insert into bank_user values(?,?,?,?)");	
			
			ps.setString(1,uname);
			
			ps.setString(2,pwd);
			ps.setInt(3,acno);
			ps.setInt(4,0);
			int status=ps.executeUpdate();
			String tname = "T" + String.valueOf(acno);
			System.out.print(tname);
			String createTableSQL = "CREATE TABLE " + tname + "("
					
					+ "NAME VARCHAR(20) , "
					+ "acno VARCHAR(20), "
					
					+ "rec VARCHAR(20) , "
					+ "rac_ac VARCHAR(20), "
					+ "amt NUMBER(20) , "
					+ "type VARCHAR(10), "
					
					+ "dt varchar2(10) " 
					+ ")";
			
			ps2 = con.prepareStatement(createTableSQL);
		//	ps.setString(1, acno);
			boolean s=ps2.execute();
			if(s==true) {
				System.out.print("temporary table created ");
			}
			
			System.out.print(status);
			
			if(status>0)
			{	
				request.setAttribute("name", uname);
				request.setAttribute("acno", acno);
				request.setAttribute("bal", 0);
				request.getRequestDispatcher("home.jsp").forward(request,response);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
