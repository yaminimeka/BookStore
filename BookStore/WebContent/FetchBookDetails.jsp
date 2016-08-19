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
		<center><h3>Update Page</h3>

<%

	ArrayList allUsers =(ArrayList) request.getAttribute("user");
	
%>

<table border="1">
<%-- 
<%
int count = 0;
int j;

for(int i = 0; i<(allUsers.size())/4; i++){
	%>
	<tr>
	<%
	for(j=0; j<4;j++)	
{
	 %>
	<td><input type ="text" value = <%= allUsers.get(count)%>></td>
	<%count  = count+1; %>

	
	
<%} %>
	</tr>
	<%}%>

 --%>
 <form method = "post" action = "UpdateServlet">
 <tr>
 <tr>
 <td>ISBN</td><td><input type ="text" name = "isbn" value = "<%=allUsers.get(0)%>" readonly="readonly" ></td>
 </tr>
  <tr>
  <td>TITLE</td><td><input type ="text" name= "title" value = "<%=allUsers.get(1).toString() %>"></td>
 </tr>
 <tr>
 <td>QUANTITY</td><td><input type ="text" name="quantity" value = "<%= Integer.parseInt(allUsers.get(2).toString())%>"></td>
 </tr>
 <tr>
 <td>PRICE</td><td><input type ="text" name= "price" value = "<%= Integer.parseInt(allUsers.get(3).toString())%>"></td>
 </tr>
 
 </tr>
  </table>

 <p><input type="submit" name="Update"></center>
</form>
	<%%>




</table>
</body>
</html>