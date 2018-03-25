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
	
</head>

<body style = "background-image: url(images/bg.jpg)">
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Namrata Bank</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="balance.jsp">Balance</a></li>
      <li><a href="transfer.jsp">Transfer</a></li>
      <li><a href="./trans">Transactions</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="./logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<h1 align="center"> 
		<%
		if (session != null) {
			if (session.getAttribute("bal") != null) {
				String b = (String) session.getAttribute("bal");
				out.print("Your Current account balance is  " + b );
			} else {
				response.sendRedirect("login.jsp");
				System.out.println("nothing");
				
			}
		}
		%>
 </h1>
</body>
</html>
