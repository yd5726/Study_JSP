<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h2>로그인</h2>
	<form method="post" action="login_result.jsp">
		<div>아이디: <input type="text" name="id"></div>
		<div>비밀번호: <input type="password" name="pw"></div>
		<input type="submit" value="로그인">
	</form>
</body>
</html>