<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/update" method="POST">
	<input type="hidden" value="${board.id}" name="id"/>
	<input type="hidden" name="_method" value="put"/>
		<table>
			<tr>
				<th>Title</th>
				<td><input type="text" name="title" value="${board.title}"/></td>
			</tr>
			<tr>
				<th>Content</th>
				<td>
				<textarea rows="5" cols="40" name="content">
				${board.content}
				</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정 완료" /></td>
			</tr>
		</table>
	</form>
</body>
</html>