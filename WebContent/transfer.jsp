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
function Check(){
	
	if(document.F1.mn.value <= 0)
	{
   		alert("Amount should be positive "); 
   		document.F1.amt.value=""
   		document.F1.amt.focus()	
   	return false
	}

}
function CheckAC(val){
	if(document.F1.ac.value == val){
		alert("can't send to the same account");
		document.F1.acno.value=""
		document.F1.amt.focus();
		return false;
	}
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
      <li><a href="balance.jsp">Balance</a></li>
      <li><a href="transfer.jsp">Transfer</a></li>
      <li><a href="./trans">Transactions</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="./logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<%int val = Integer.parseInt((String)session.getAttribute("acno"));
					System.out.println(val);%>
<form class="form-horizontal" action="tran" method="get">
  <div class="form-group">
    <label class="control-label col-sm-2" for="acno">Account no</label>
    <div class="col-sm-7">
      <input type="text" class="form-control" id="ac" name="acno" placeholder="Enter Account no" onChange="CheckAC('<%=val%>')">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="amt">Amount</label>
    <div class="col-sm-7"> 
      <input type="text" class="form-control" id="amt"  name="amt" placeholder="Enter Amount" onChange ="Check()">
    </div>
  </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-7">
      <button type="submit" class="btn btn-default">Transfer</button>
    </div>
  </div>
</form>



</body>
</html>
