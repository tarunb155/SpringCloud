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
	<c:if test="${param.error!=null}">
		<i style="color: red;">Invalid login or password</i>
	</c:if>
	<c:if test="${param.logout!=null}">
		<i style="color: red;">You are successfully logged out! Please
			sign in again</i>
	</c:if>
	<h1>Welcome to My Custom Login Page!!</h1>
	<form:form>
UserName <input type="text" name="username">
		<br />
		<br />
Password <input type="password" name="password">
		<br />
		<br />
		<input type="submit" value="Login">
	</form:form>
</body>
</html>