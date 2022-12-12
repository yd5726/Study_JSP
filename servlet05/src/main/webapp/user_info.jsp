<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>
</head>
<body>
	<h2><a href="/servlet05/">홈으로</a></h2>
	<div><a href="userAll.ju">사용자 전체 목록</a></div>
	<hr>
	<h3>사용자 정보</h3>
	<table border='1'>
		<tr>
			<th>id</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>name</th>
			<td>${dto.name}</td>
		</tr>
		<tr>
			<th>email</th>
			<td>${dto.email}</td>
		</tr>
		<tr>
			<th>money</th>
			<td>${dto.money}</td>
		</tr>
	</table>
</body>
</html>