<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.DBConnection" %>
<link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <link rel="import" href="front.html">
  <link rel="import" href="footer.html">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
function ctck()
{
	var sds = document.getElementById("dum");

}
function Check(){
	<% if(session == null){
		out.print("You need to login first ");
		response.sendRedirect("login.jsp");
		
	}
		%>
}
	
</script>	
</head>

<body style = "background-image: url(images/bg.jpg)">
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Namrata Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="update.jsp">Update Accounts</a></li>
      <li><a href="delete.jsp">Delete Accounts</a></li>
      <li><a href="transaction2.jsp">Delete Transactions</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="./logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<div>
	<h2 align="center">
    <%
		if (session != null) {
			
				out.print("Hello Admin");
		}
			 else {
				response.sendRedirect("login.jsp");
			}
		
	%>
    </h2>
</div>

<div class="container">
  <h2>Your Transactions</h2>
  <div class="table-responsive" style="background-color : #FAD7A0">          
  <table class="table table-hover table-condensed">
    <thead>
      <tr>
        <th>User name</th>
        <th>Account number</th>
      </tr>
    </thead>
    
    
    <tbody>
    <% Connection  con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from bank_user";
		ResultSet rset = stmt.executeQuery(sql);
			
			while(rset.next()){
				String name=rset.getString("name");
				String ac=rset.getString("acno");
				
				%>
				<tr>
        <td><%=name %></td>
        <td><%=ac %></td>
        <td><button type="submit" onClick = "/updt?acno">update</button></td>
      </tr>	
				
	<% } %>				
      
    </tbody>
  </table>
  </div>
</div>


</body>
</html>
