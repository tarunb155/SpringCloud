<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Love Calculator</title>
<style type="text/css">
.error{
color: red;
position:fixed;
text-align: left;
margin-left: 30px;
}
</style>

<script type="text/javascript">
function validateUser()
{
	var name=document.getElementById("nm").value;
	if(name.length<1)
		{
		alert("your name should have atleast 1 character");
		return false;
		}
	else
		{
		return true;
		}
	var userName=document.getElementById("unm").value;
	if(userName.length<1)
		{
		alert("your name should have atleast 1 character");
		return false;
		}
	else
		{
		return true;
		}	
	var pass=document.getElementById("pwd").value;
	if(pass.length<6)
		{
		alert("your name should have atleast 5 character");
		return false;
		}
	else
		{
		return true;
		}	
	}
</script>
</head>
<body>
	<h1 align="center">**********WELCOME TO REGISTRATION PAGE OF LOVE CALCULATOR APPLICATION***********</h1>
	<form:form action="registrationdetails" method="get"  modelAttribute="userreginfo" onsubmit="validateUser()">
		<div align="center">
			<p>
				<label for="nm">Name:</label> <form:input type="text" id="nm" path="name"/>
				<form:errors path="name" cssClass="error"/>
			</p>
			<p>
				<label for="unm">User Name:</label> <form:input type="text" id="unm" path="userName"/>
				<form:errors path="userName" cssClass="error"/>
			</p>
			<p>
				<label for="cnm">Crush Name:</label> <form:input type="text" id="cnm" path="crushName"/>
				<form:errors path="crushName" cssClass="error"/>
			</p>
			<p>
				<label for="pwd">Password:</label> <form:input type="password" id="pwd" path="password"/>
				<form:errors path="password" cssClass="error"/>
			</p>
			<p>
				<label >Country:</label>
				<form:select path="country">
				<form:option value="India" label="India"></form:option>
				<form:option value="Australia" label="Australia"></form:option>
				<form:option value="America" label="America"></form:option>
				<form:option value="Newzealand" label="Newzealand"></form:option>
				<form:option value="South Africa" label="South Africa"></form:option>
				<form:option value="England" label="England"></form:option>
				</form:select>
			</p>
			
			<p>
				<label>Hobbies:</label>
				Cricket<form:checkbox path="hobbies" value="cricket"/>
				Dancing<form:checkbox path="hobbies" value="dancing"/>
				Reading<form:checkbox path="hobbies" value="reading"/>
				Travelling<form:checkbox path="hobbies" value="travelling"/>
				Painting<form:checkbox path="hobbies" value="painting"/>
			</p>
		
			
			<p>
				<label>Gender:</label>
				Male<form:radiobutton path="gender" value="male"/>
				Female<form:radiobutton path="gender" value="female"/>
			</p>
			<p>
				<label>Age</label>
				<form:input path="age"/>
				<form:errors path="age" cssClass="error" />
			</p>
		
			<p>
				<label>Email</label>
				<form:input path="communicationDTO.email"/>
			</p>
			<p>
				<label>Phone</label>
				<form:input path="communicationDTO.phone"/>
			</p>
		
				<p>
				<label>Credit Card Number</label> 
				<form:input path="creditcardDTO"/>
			</p>
			<p>
				<label>Amount</label>
				<form:input path="amount" cssClass="error"/>
			</p>
			<p>
				<label>Currency</label>
				<form:input path="currency" cssClass="error"/>
			</p>
			<p>
				<label>Date</label>
				<form:input path="date" cssClass="error"/>
			</p>
				<p>
				<form:checkbox path="termsandcondition" id="check"/>
				<label>I am agreeing to all the terms and condition that this is for fun</label>
				<form:errors path="termsandcondition" cssClass="error" />
			</p>
			
			<p>
			<input type="submit" value="register">
			</p>
		
		</div>
		</form:form>
</body>
</html>