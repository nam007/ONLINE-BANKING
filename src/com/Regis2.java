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
public class Regis2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		int acno=(Integer)Integer.parseInt(request.getParameter("acno"));
		
		Connection con=null;
		System.out.println(acno);
		int b=0;
		PreparedStatement ps,ps1,ps2;
		ResultSet rs;
		try {
			con=DBConnection.getConnection();
			Statement stmt;
			String sql = "select * from pre_user where acno = " + acno;
		//	ps1 = con.prepareStatement("select * from pre_user where acno = ?");	
		//	ps1.setInt(1, acno);
		//rs=ps1.executeQuery();
			stmt =con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				b=rs.getInt("bal");
				System.out.println("bal is" +  b);
			}
			
			
			ps = con.prepareStatement("Insert into bank_user values(?,?,?,?)");	
			
			ps.setString(1,uname);
			
			ps.setString(2,pwd);
			ps.setInt(3,acno);
			ps.setInt(4,b);
			
			String tname = "T" + String.valueOf(acno);
			System.out.print(tname);
			String createTableSQL = "CREATE TABLE " + tname + "("
					
					+ "NAME VARCHAR(20) , "
					+ "acno VARCHAR(20), "
					
					+ "rec VARCHAR(20) , "
					+ "rac_ac VARCHAR(20), "
					+ "amt NUMBER(20) , "
					+ "type VARCHAR(10), "
					
					+ "dt varchar2(20) " 
					+ ")";
			
			ps2 = con.prepareStatement(createTableSQL);
		//	ps.setString(1, acno);
			boolean s=ps2.execute();
			if(s==true) {
				System.out.print("temporary table created ");
			}
			
			int status=ps.executeUpdate();
			System.out.print(status);
			
			if(status>0)
			{	
				request.setAttribute("name", uname);
				request.setAttribute("acno", acno);
				request.setAttribute("bal", b);
				request.getRequestDispatcher("home.jsp").forward(request,response);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
