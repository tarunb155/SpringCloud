<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOVE CALCULATOR APP</title>
</head>
<body>
<h1 align="center">YOUR REGISTRATION DETAILS</h1>
<p>Name is ${userreginfo.name} </p>
<p>UserName is    ${userreginfo.userName}</p>
<p>CrushName is   ${userreginfo.crushName}</p>
<p>Password is	  ${userreginfo.password}</p>
<p>Country is	   ${userreginfo.country}</p>
<p>Hobbies is    
<c:forEach var="temp" items=" ${userreginfo.hobbies}">
<c:out value="${temp}"></c:out>
</c:forEach>
<br/>
 </p>
<p>Gender is      ${userreginfo.gender}</p>
<p>Age is      ${userreginfo.age}</p>
<p>Email is 	  ${userreginfo.communicationDTO.email}</p>
<p>Phone is		  ${userreginfo.communicationDTO.phone}</p>
<p>Your Credit Card Number is ${userreginfo.creditcardDTO}</p>
<p>Amount is       ${userreginfo.amount}</p>
<p>Currency is     ${userreginfo.currency}</p>
<p>Date:           ${userreginfo.date}</p>
<br/>
 ${userreginfo.userName} and ${userreginfo.crushName} are ${userreginfo.result}
 <br/>
 <a href="/spring-love-calculator/sendEmail">Send Result to your Email</a>
</body>
</html>