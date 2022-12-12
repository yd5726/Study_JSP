<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<body>
	<h2>회원가입</h2>
	<form method="post" action="info.jsp">
		<div>이름 : <input type="text" name="name"></div>
		<div>성별 : <input type="radio" name="gender" value="남">남
				   <input type="radio" name="gender" value="여" checked>여
		</div>
		<div>취미 : <input type="checkbox" name="hobby" value="달리기"> 달리기
				   <input type="checkbox" name="hobby" value="드라마 시청"> 드라마 시청
				   <input type="checkbox" name="hobby" value="캠핑"> 캠핑
		</div>
		<input type="submit" value="회원가입">
	</form>
	
	
	<!-- 상대 경로 -->
	<%-- <%@ include file = "../include/today.jsp" %> --%>
	
	<!-- 절대 경로 -->
	<%-- <%@ include file = "/include/today.jsp" %> --%>
</body>
</html>