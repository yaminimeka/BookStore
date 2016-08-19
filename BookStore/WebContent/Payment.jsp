<html>
	<head>
		<title>Payment page</title>
		<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">
		
	</head>
	<body>
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
<center><h2>Payment Page</h2></center>
			
	<center>
	<form action="/BookStore/PaymentSuccesfull.jsp" method='Post' >
		<table>
					<tr>
					<td>Select Card Type  </td>
					<td>
						<select id="card">
							<option>Discover Card</option>
							<option>Master Card</option>
							<option>Visa Card</option>
							<option>American Express</option>
						</select>
					</td>
					</tr>
					
					<tr>
						<td>Card Number  </td>
						<td><input type="text" id="cardNumber"   maxlength="16" onkeypress="return isNumber(event);"/>
					</tr>
					<tr>
						<td>Card Holder Name    </td>
						<td><input type="text" id="cardHolderName"/>
					</tr>
					<tr>
						<td>Security Code  </td>
						<td><input type="password" maxlength="3" id="cvv" onkeypress="return isNumber(event)"/>
					</tr>
				</table></br>
					
				<input type='button' value='Make Payment' onclick="checkForm()">
					</form>
				
			</center>

	

	</body>
	<script>
	function checkForm(){
		if(document.getElementById("cardNumber").value	==	""	||	document.getElementById("cardHolderName").value	==	""	||	document.getElementById("cvv").value	==	""	){
			alert("Please provide all necessary information");
			return false;
		}
		var	cardnumber	=	document.getElementById("cardNumber").value;
		var	cvv	=	document.getElementById("cvv").value;
		if(cardnumber.length<16){
			alert("Card Number Should have 16 numbers");
			return	false;
		}
		if(cvv.length<3){
			alert("CVV Should have 3 number");
			return	false;
		}
		document.forms[0].submit();
	}
	function isNumber(e){
	    e = e || window.event;
	    var charCode = e.which ? e.which : e.keyCode;
	    return /\d/.test(String.fromCharCode(charCode));
	}
	</script>
	
</html>