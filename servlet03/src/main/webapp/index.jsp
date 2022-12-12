<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date, java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body>
	<h2><a href="/jsp/">홈으로</a></h2>
	<%@ include file="include/today.jsp" %>
	<div>JSP에서 선언할 수 있는 것들</div>
	<ul>
		<li>HTML 태그 선언</li>
		<li>★JSP 스크립팅 : JAVA 코드</li>
		<li>★JSP 표준 액션</li>
		<li>★EL</li>
		<li>★JSTL</li>
	</ul>
	<hr>
	<div><a href='/jsp/sum.jsp'>합 계산하기</a></div>
	<div><a href='/jsp/out.jsp'>출력하기</a></div>
	<div><a href='/jsp/calc/calculate.jsp'>계산하기</a></div>
	<!-- <div><a href='member/join.jsp'>회원가입</a></div> -->
	<!-- <div><a href='member/login.jsp'>로그인</a></div> -->
	<%-- <hr>
	&nbsp;*^^*&nbsp;
	<%
		// 세션에 저장한 로그인 정보인 id를 확인
		// Object -> String
		String id = (String)session.getAttribute("id");
		
		if(id == null){
			//로그인 해야 함
			out.print("<div><a href='member/login.jsp'>로그인</a></div>");	
			out.print("<div><a href='member/join.jsp'>회원가입</a></div>");	
		}else{
			// 로그인 됨
			out.print("[ " + id + " ]");	
			out.print("[ <a href='member/logout.jsp'>로그아웃</a> ]");	
		}
	%> --%>
	<hr>
	<%-- <%
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("YYYY년 MM월 DD일 E요일 a HH시 MM분 SS초");
		String now = df.format(date);
	%>
	<div>날짜정보: <%=date %></div>
	<div>현재: <%=now %></div>
	<hr> --%>
	<!-- <div>[2022년 11월 15일]</div>
	<hr> -->
	<!-- 지시어 -->
	<%-- <%@ include file="include/footer.jsp" %> --%>
	<!-- 지시어 말고 include 액션 -->
	<jsp:include page="include/footer.jsp">
		<jsp:param name="email" value="test@naver.com"/>
		<jsp:param name="phone" value="010.9852.3214"/>
	</jsp:include>
	<hr>
	
	<%
		//Ojbect -> int
		if(request.getAttribute("result") != null){
			int result = (int)request.getAttribute("result");
			out.print("계산 결과 ");
			out.print("result: " + result);	
		}
	%>
</body>
</html>