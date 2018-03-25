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
      <a class="navbar-brand" href="#">NAMRATA BANK</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Welcome</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Create Account
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="reg1.jsp">Old Account</a></li>
          <li><a href="reg.jsp">New Account</a></li>
          
        </ul>
      </li>
      <li><a href="#">Contact us</a></li>
      <li><a href="#">About us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<h1 align="center">LOGIN</h1>

<form class="form-horizontal" action="login">
  <div class="form-group">
    <label class="control-label col-sm-2" for="uname">User name</label>
    <div class="col-sm-7">
      <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-7"> 
      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-7">
      <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
      </div>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-7">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>

</body>
</html>
