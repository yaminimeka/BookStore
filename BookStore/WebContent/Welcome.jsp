

<!DOCTYPE html>
<html>	
	<head>
		<meta charset="utf-8">
		<title> Home  </title>
		<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">
		<form action="/BookStore/LoginPage.html" method="post">
	</head>
	<body>
	<div class="header">
	<center><h1 style="color:#11113F;font-size:40px;text-shadow:0 2px 3px #ccc">Online Book Store</h1></center>
<ul id="navbar" style="margin-left:22%">
	<li><a href="/BookStore/BookRegistration.jsp">Book Registration</a></li>
	<li><a href="/BookStore/ViewUsersServlet">View Users</a></li>
	<li><a href="/BookStore/ViewAllBooksCustomerServlet?f=1">View Books</a></li>
	<li><a href="/BookStore/UpdateBooks.jsp">Update Books</a></li>
	<li><a href="/BookStore/Logout">Log Out</a></li>
	
	
	
	<label style="text-align: right;margin-left:25%"><b> Welcome <%=session.getAttribute("userName") %></b></label>
</ul>
<div style="clear:both"></div>
</div>
		
		<div align ="center">
		</br></br>
	
	<p><b> 	     This Online System provides the customers the ease to find all the necessary books.</p>
	<p>  The customer can select the books required and he can purchase the books using his credit card details.</p>
	        

	</div>
	</form>
	</body>
</html>