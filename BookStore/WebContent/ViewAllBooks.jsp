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
<body align ="center" >
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
<center><h3>Books List</h3>
<form method = "get" action="/BookStore/PurchaseServlet">
<%

	ArrayList allUsers =(ArrayList) request.getAttribute("user");
	
%>

<table border="1">
<tr>

<td>ISBN</td>
<td>Book Name</td>
<td>Total Number Of Books Available</td>
<td>Price per Each</td>
<td>Select</td>
</tr>
<%
int count = 0;
int j;
int	test	=	0;
for(int i = 0; i<(allUsers.size())/4; i++){
	%>
	<tr>
	<%
	for(j=0; j<4;j++)	
{
		
		if(j%4==3)
		{ %>
		<td>$ <%= allUsers.get(count)%></td>
		
		<%} else{ %>
		<td><%= allUsers.get(count)%></td>
		
		<%} %>
		<%count  = count+1; %>

		
		
	
	
<%} %>
<% System.out.println("isbn"+allUsers.get(count-4)); %>
 <td><input type="checkbox"  name="book" id="book<%=test %>" value="<%=allUsers.get(count-4)%>"></td>
	</tr>
	<%
test	=	test	+	1;	
}%>
	






</table>
<input type="hidden"  name="count" id="count" value="<%=test%>"></td>
<br>
<input type ="button" value="Purchase" onclick="checkBooks()">
</form>
</body>
<script>
function checkBooks(){
	var	count	=	document.getElementById("count").value;
	var	test	=	0;
	for(var	i	=0;	i	<	count-1;	i++)
	{
		if(!document.getElementById("book"+i).checked){
			test	=	0+test	;
		}
		else{
			
			test	=	1+test;
		}
		
	}
	if(test==0){
		alert("Please select atleast one book");
		return false;
		
	}else if(test>0){
		document.forms[0].submit();	
	}
	
	
}
</script>
</html>