<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out</title>
</head>
<body>
	<h2><a href="./">홈으로</a></h2>
	<%@ include file="include/today.jsp" %>
	<hr>
	<h2>출력하기</h2>
	<div>1 ~ 10까지 출력</div>
	<%
		for(int num=1;num<=10;num++){
	%>
			<%=num %>
	<%
		}
	%>
	<hr>
	<%
		for(int num=1;num<=10;num++){
			out.print(num); // 내장 객체 사용 (6.1 out : 출력과 관련된 내장객체 변수이다.)
		}
	%>
</body>
</html>