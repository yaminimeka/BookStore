<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Details</title>
<center><h3>Customer Details</h3>
</head>
<body>
<%   

String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
int id = Integer.parseInt((request.getSession().getAttribute("id")).toString());

%>


<form action="/BookStore/LoginPage.html" >

<h2><p><b>Congragulations</b></p></h2>
<h3><p>Customer have been successfully registered and your details are below:</h3></p>
<label>ID is: <%= id %></label></br>
<label>FirstName is : <%= fname %></label></br>
<label>LastName is : <%= lname %></label><br></br>
<input type="submit" value="Back">
</form>
</center>

</body>
</html>