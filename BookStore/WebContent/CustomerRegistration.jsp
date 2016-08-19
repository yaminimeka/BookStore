<html>
<head>
<link REL="StyleSheet" TYPE="text/css" HREF="/BookStore/css/stylesheet.css">
</head>
<body >
<center><h2>Customer Registration</h2></center>

<center>
<form name="custReg"action="/BookStore/CustomerServlet" method='Post'>
<table>
<tr>
<td>FirstName</td>
<td><input type='text' id='firstName' name='fname'   ><br /></td></tr>
<tr><td>LastName</td>
<td><input type='text' id='lastName' name='lname'  ><br /></td></tr>
<tr><td>Street Address</td>
<td><input type='text' id='addres' name='address'><br /></td></tr>
<tr><td>City</td>
<td><input type='text' id='city' name='city'><br /></td></tr>
<tr><td>State</td>
<td><select name='state' id='state' >
  <option value="select">Select</option>
  <option value="MO">MO</option>
  <option value="NJ">NJ</option>
  <option value="MD">MD</option>
  <option value="NY">NY</option>
  <option value="hg">VA</option>
  <option value="hh">ST</option>
  <option value="Mp">CA</option>
  <option value="ap">AZ</option>
</select><br /></td></tr>


<tr><td>Zip</td>
<td><input type='text' id='zip' name='zip' onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="5"><br /></td></tr>
<tr><td>Phone Number</td>
<td><input type='text' id='phone' name='phoneno' maxlength="15" onKeyup='addDashes(this)'><br /></td></tr>
</tr>
<tr>
<td>Password</td>
<td><input type='password' id='passwords' name="password"><br />
</td>
<!--<input id="input_4" class="form-textbox" maxlength="15" name="atn" size="25" onKeyup='addDashes(this)' />-->
</table></br></br>
<input type='button' onclick="checkForm()" value='Register'>
</form>
<form>

<input type='submit' value='Reset'>
</form>
</center>
</form>
</body>
<script>

function checkForm(){
	var	fname	=	document.getElementById("firstName").value;
	var	lname	=	document.getElementById("lastName").value;
	var	address	=	document.getElementById("addres").value;
	var	phoneno	=	document.getElementById("phone").value;
	var	password	=	document.getElementById("passwords").value;
	var	city	=	document.getElementById("city").value;
	var	state	=	document.getElementById("state").value;
	var	zip	=	document.getElementById("zip").value;
	
	if(fname == "" || lname == "" || address == "" || phoneno == "" || password == "" || city == "" || state == "" || zip == ""){
		alert("please provide all inputs");
		return false;
	}
	if(password.length < 6){
		//System.out.println(isbn.length);
		alert("Password must contain at least six characters!" );
		return	false;
	}
	if(.length < 6){
		//System.out.println(isbn.length);
		alert("Password must contain at least six characters!" );
		return	false;
	}
	 re = /[0-9]/;
	 if(!re.test(password)) {
       alert(" password must contain at least one number (0-9)!");
       return false;
     }
	 re = /[A-Z]/;
     if(!re.test(password)) {
       alert("Error: password must contain at least one uppercase letter (A-Z)!");

       return false;
     }
     if(zip.length != 5){
 		//System.out.println(isbn.length);
 		alert("zip must have only 5 digits!" );
 		return	false;
 	}
	else{
		document.forms["custReg"].submit();
	}
	
}
window.addDashes = function addDashes(f) {
    var r = /(\D+)/g,
        npa = '',
        nxx = '',
        last4 = '';
    f.value = f.value.replace(r, '');
    npa = f.value.substr(0, 3);
    nxx = f.value.substr(3, 3);
    last4 = f.value.substr(6, 4);
    f.value = npa + '-' + nxx + '-' + last4;
}

</script>
</html>
