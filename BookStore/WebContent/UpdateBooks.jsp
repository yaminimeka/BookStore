<!DOCTYPE html>
<html>
<head>
<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">
</head>
<center>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	
	<head><h2>Update Books</h2>		

<form method = "post" action = "/BookStore/FetchBookDetails">
<table>
<tr>
<td>ISBN</td>
<td><input type='text' name='isbn' onkeypress='return event.charCode >= 48 && event.charCode <= 57  || event.charCode == 45' maxlength="14" required><br /></tr></td>
</tr>
</table>
<INPUT TYPE='submit' VALUE='SUBMIT'>
</form>
</body>
</center>
</html>