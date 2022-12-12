<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>userAll</title>
</head>
<body>
	<h2><a href="/servlet05/">홈으로</a></h2>
	<hr>
	<h3>전체 사용자 이름 목록</h3>
	<ul>
		<c:forEach items="${list}" var="name">
			<li>${name}</li>
		</c:forEach>
	</ul>
	
	<h3>전체 사용자 정보 목록</h3>
	<table border='1'>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>관리자여부</th>
			<th>잔액</th>
		</tr>
		<c:forEach items="${user_list}" var="dto">
			<tr>
				<td><a href="user_info.ju?id=${dto.id}">${dto.id}</a></td>
				<td>${dto.name}</td>
				<td>${dto.email}</td>
				<td>${dto.admin}</td>
				<td>${dto.money}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>