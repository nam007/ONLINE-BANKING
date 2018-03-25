package com;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.*;
import java.net.*;

import java.io.*;



import javax.servlet.*;
import javax.servlet.http.*;




import java.util.*;
import com.DBConnection;
public class Transaction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();  
		String acno = (String)session.getAttribute("acno");
		Statement ps;
		Connection con;
		ResultSet rs;
		try {
			rs=null;
			con=DBConnection.getConnection();
			String new_name = "T" + String.valueOf(acno);
			String sql = "select *  from  " + new_name;
			ps = con.createStatement();	
			rs=ps.executeQuery(sql);
			
			if(rs.next())
			{	
				request.setAttribute("X", rs);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/transaction.jsp");
		        rd.forward(request, response);
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
