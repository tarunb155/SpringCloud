<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Home-Page</h1>
<h1>Hi ${username }</h1>
<h4>Authorities assigned are: ${roles}</h4>
<sec:authorize access='hasAuthority("trainer")'>
<a href="/springsecurity/trainer">Show Trainer's Dashboard</a>
</sec:authorize>
<sec:authorize access='hasAuthority("coder")'>
<a href="/springsecurity/coder">Show Coder's Dashboard</a>
</sec:authorize>
<br/>
<a href="/springsecurity/deleteUser?username=${username}">Delete Account</a>

&nbsp;
<a href="/springsecurity/changePassword?username=${username}">Change Password</a>
<br/>
<br/>
<br/>
<form:form action="logout" method="POST">
<input type="submit" value="logout">
</form:form>
</body>
</html>