package com;
import java.io.*;

import java.sql.*;
import java.text.*;
import java.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.util.*;
import com.DBConnection;
public class Transfer extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int ac = Integer.parseInt(request.getParameter("acno"));
		int mn=Integer.parseInt(request.getParameter("amt"));
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		String dt = dateFormat.format(date);
		Connection con=null;
		ResultSet rs;
		PreparedStatement ps,ps1,ps2,ps3,ps4;
		try {
			rs=null;
			con=DBConnection.getConnection();
			ps = con.prepareStatement("select * from bank_user where acno=?");
			
			ps.setInt(1, ac);
			
			rs=ps.executeQuery();
			HttpSession session=request.getSession();  
			session.setMaxInactiveInterval(30);
			int s = Integer.parseInt((String)session.getAttribute("acno"));
			int bl =Integer.parseInt((String)session.getAttribute("bal"));
			String nm =(String)session.getAttribute("name");
			
			if(rs.next()) {
				int b = rs.getInt("bal");
				b = b+mn;
		        ps1=con.prepareStatement("update bank_user set bal = ? where acno= ?");
		        ps1.setInt(1, b);
		        ps1.setInt(2, ac);
		      int f=  ps1.executeUpdate();
		      
		      if(f>0)
		    	  	System.out.println("ps1 executed");
				bl=bl-mn;
				
				ps2=con.prepareStatement("update bank_user set bal = ? where acno = ?" );
				ps2.setInt(1,bl );
				ps2.setInt(2,s);
			int f2=	ps2.executeUpdate();
			String s2=String.valueOf(bl);
			session.setAttribute("bal", s2);
			if(f2>0)
	    	  	System.out.println("ps2 executed");
			
			
			String new_name = "T" + String.valueOf(s);
			System.out.println(new_name);			
			ps3=con.prepareStatement( "insert into " + new_name +"  values(?,?,?,?,?,?,?)");
			//ps3.setString(1, new_name);
			
			ps3.setString(1, nm);
			ps3.setInt(2, s);
			ps3.setString(3,(String)rs.getString("name"));
			ps3.setInt(4, ac);
			ps3.setInt(5, mn);
			ps3.setString(6, "Debit");
			ps3.setString(7, dt);
			int t=ps3.executeUpdate();
			
			String new_name2 = "T" + String.valueOf(ac);
			System.out.println(new_name2);	
			ps4=con.prepareStatement("insert into " +new_name2 +" values(?,?,?,?,?,?,?)" );
		//	ps4.setString(1, new_name2);
			ps4.setString(1, (String)rs.getString("name"));
			ps4.setInt(2, ac);
			ps4.setString(3,nm);
			ps4.setInt(4, s);
			ps4.setInt(5, mn);
			ps4.setString(6, "Credit");
			ps4.setString(7, dt);
			int t2=ps4.executeUpdate();
			
			if(t>0)
				System.out.print("reached table 1");
			if(t2>0)
					System.out.print("raeched table 2");
			
			if(f >0 && f2>0) {
				request.getRequestDispatcher("home.jsp").forward(request,response);
			}
			else {
				System.out.print("did not");
			}
				
				
			}
			else {
				System.out.println("transfer failed");
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
