<html>
<head>
<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">
</head>
<body >
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
		

<center><h2>Book Registration</h2></center>

<form method ='post' action=''>
<div align='right'>	
<!-- <input type='submit' name='act' value='Logout'> -->

</div>	
</form>

 
<form name="regForm"action='/BookStore/BookServlet' method='post'  > 
<center>

<table>
<tr>
<td>ISBN</td>
<td><input type='text' name='isbn' id='isbn' onkeypress='return event.charCode >= 48 && event.charCode <= 57  || event.charCode == 45' maxlength="14" required><br /></tr></td>
<td>BookTitle</td>
<td><input type='text' name='booktitle' id='booktitle'><br /></tr></td>
<td>Quantity</td>
<td><input type='text' name='quantity' id='quantity' onkeypress='return event.charCode >= 48 && event.charCode <= 57'><br /></tr></td>
<td>Price</td>
<td><input type='text' name='price' id='price' onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46'><br /></tr></td>
</tr>
</table></br></br>
<INPUT TYPE='button' VALUE='Submit' onclick="checkForm()" > <INPUT TYPE='button' VALUE='RESET' onclick="res()">
</form>

</center>
<script>

function res(){
	window.open("/BookStore/BookRegistration.jsp","_self");
}

function checkForm(){
	var	isbn	=	document.getElementById("isbn").value;
	var	booktitle	=	document.getElementById("booktitle").value;
	var	quantity	=	document.getElementById("quantity").value;
	var	price	=	document.getElementById("price").value;
		if(document.getElementById("isbn").value	==	""	||	document.getElementById("booktitle").value	==	"" ||	document.getElementById("price").value	==	""	||	document.getElementById("quantity").value	==	""	){
			alert("Please provide all necessary information");
			return false;
		}
	
	//	else if(isbn.length>13 || isbn.length<15 ){
		 if(isbn.length != 14){
			//System.out.println(isbn.length);
			alert("isbn Should have 14 numbers");
			return	false;
		}
		 if(quantity<=0){
			alert("quantity Should be greater than 0 ");
			return	false;
		}
		 re = /^[a-zA-Z]*$/;
	     if(!re.test(booktitle)) {
	       alert("Error: Title should accept only characters not numbers");

	       return false;
	     }
		 if(price<=0){
			alert("Please provide Price of the book ");
			return	false;
		}
		else{
			document.forms["regForm"].submit();
		}
		
	}
	
	</script>
</body>

	
</html>
