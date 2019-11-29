<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>			
		</tr>
		<c:forEach var="board" items="${boards }">
			<tr>
				<td>${board.id }</td>
				<td><a href="/board/detail/${board.id}">${board.title}</a></td>
				<td>${board.user.username }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/board/writeForm">글쓰기</a>
</body>
</html>