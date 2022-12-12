<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
	<%
		// 로그인 정보를 삭제하기
		// session에 attribute로 저장한 값을 삭제 : removeAttribute
		session.removeAttribute("id");
		session.removeAttribute("pw");
		response.sendRedirect("../"); // 바로~ 홈으로
	%>
</body>
</html>