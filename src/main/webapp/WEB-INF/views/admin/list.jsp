<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>USERNAME</td>
			<td>EMAIL</td>
			<td>ROLE</td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><a href="/admin/user/${user.id}">${user.username}</a></td>
				<td>${user.email}</td>
				<td>${user.role}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>