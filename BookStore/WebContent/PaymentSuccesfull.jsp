<!DOCTYPE html>
<html>
<head>
<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">

<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
		<div class="header">
	<center><h1 style="color:#11113F;font-size:40px;text-shadow:0 2px 3px #ccc">Online Book Store</h1></center>
<ul id="navbar" style="margin-left:32%">
	<li><a href="/BookStore/ViewPurchasedBookServlet">View My Books</a></li>
	<li><a href="/BookStore/ViewAllBooksCustomerServlet?f=0">View All Books</a></li>
	<li><a href="/BookStore/Logout">Log Out</a></li>
	
	
	
	<label style="text-align: right;margin-left:25%"><b> Welcome user <%=session.getAttribute("userName") %></b></label>
</ul>
<div style="clear:both"></div>
</div>
<form action="/BookStore/customerPage.html" method="post">
<center><h2>Payment was Successful</h2><br>
</form>

</body>
</html>