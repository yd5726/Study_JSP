<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
</head>
<body>
	<div>업체명: 한울직업전문학교</div>
	<div>주소: 서구 경열로 3</div>
	<!-- <div>연락처:062-1234-5678 이메일: admin@naver.com</div> -->
	<div>연락처: <%=request.getParameter("phone") %>
		 이메일: <%=request.getParameter("email") %>
	</div>
</body>
</html>