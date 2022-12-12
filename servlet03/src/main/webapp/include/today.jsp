<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat, java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>today</title>
</head>
<body>
	&nbsp;*^^*&nbsp;
	<%
		// 세션에 저장한 로그인 정보인 id를 확인
		// Object -> String
		String id = (String)session.getAttribute("id");
		
		if(id == null){
			//로그인 해야 함
			out.print("<a href='/jsp/member/login.jsp'>로그인</a>");	
			out.print("<a href='/jsp/member/join.jsp'>회원가입</a>");	
		}else{
			// 로그인 됨
			out.print("[ " + id + " ]");	
			out.print("[ <a href='member/logout.jsp'>로그아웃</a> ]");	
		}
	%>
	<!-- <div>[2022년 11월 15일]</div> -->
	<%
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		String today = df.format(new Date());
	%>
	[ <%=today%> ]
</body>
</html>