<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <link rel="import" href="front.html">
  <link rel="import" href="footer.html">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<link href="style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
function ctck()
{
var sds = document.getElementById("dum");

}
</script>
	
</head>

<body style = "background-image: url(images/bg.jpg)">
<% if(session == null){
	out.print("You need to login first ");
	response.sendRedirect("login.jsp");
	
}
	%>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Namrata Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">AdminHome</a></li>
      <li><a href="update.jsp">Update Account</a></li>
      <li><a href="delete.jsp">Delete accounts</a></li>
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
			
				out.println("Hello admin"); 
		}
			 else {
				response.sendRedirect("login.jsp");
			}
		
	%>
	</h2>
</div>
<div class="footer">
  <p></p>
</div>
</body>
</html>
