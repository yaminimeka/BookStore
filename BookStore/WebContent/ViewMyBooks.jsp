<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body align = "center">
	<div class="header">
	<center><h1 style="color:#11113F;font-size:40px;text-shadow:0 2px 3px #ccc">Online Book Store</h1></center>
<ul id="navbar" style="margin-left:32%">
	<li><a href="/BookStore/ViewPurchasedBookServlet">View My Books</a></li>
	<li><a href="/BookStore/ViewAllBooksCustomerServlet?f=0">View All Books</a></li>
	<li><a href="/BookStore/Logout">Log Out</a></li>
	
	
	
	<label style="text-align: right;margin-left:25%"><b> Welcome user <%=session.getAttribute("userid") %></b></label>
</ul>
<div style="clear:both"></div>
</div>
<center><h3>Purchased Books</h3>
	
<form action="/BookStore/UserWelcome.jsp" method="post">
<%
ArrayList allBooks = (ArrayList) request.getAttribute("user");
	System.out.println(allBooks);
%>

<table border="1">
<tr>
<td>ISBN</td>
<td>Book Name</td>
<td>Quantity</td>
<td>Cost</td>


</tr>
<%
double totalcost	=	0;

for(int i = 0; i<allBooks.size()-1; i++){
	%>
	<tr>


		<td><%= allBooks.get(i)%></td>
		<td><%= allBooks.get(i+1)%></td>
		<td><%= allBooks.get(i+2)%></td>
		<td>$<%= allBooks.get(i+3)%></td>
		<%
totalcost	=	totalcost	+	Double.parseDouble(String.valueOf(allBooks.get(i+3)));		
i	=	i	+3;
} %>
		
		
	</tr>
	






</table></br>
<table><tr><td>&nbsp;</td><td>&nbsp;</td><td>Total Purchase Cost:</td><td><%=totalcost %></td></tr></table>

</form>
</body>
</html>