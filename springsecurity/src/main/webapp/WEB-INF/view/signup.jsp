<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sign up here!</h1>
<form:form action="process-signup" method="POST" modelAttribute="signupdto">
Username: <form:input path="username"/>
<br/>
Password: <form:input path="password"/>
<br/>
<input type="submit" value="signup">
</form:form>

</body>
</html>