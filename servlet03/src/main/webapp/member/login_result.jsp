<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_result</title>
</head>
<body>
	<h2>login_result</h2>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		/*아이디, 비번 모두 입려고디어 있으면 로그인이 된 것으로 간주*/
		if(id.isEmpty() || pw.isEmpty()){
			// 아이디나 비밀번호의 입력이 없을 경우 다시 로그인 화면으로 연결
			// 바로~ 로그인으로 감
// 			response.sendRedirect("login.jsp");
		}else{
			//로그인 된 정보는 모든 페이지에서 접근할 수 있도록 세션에 담는다.
			session.setAttribute("id", id); /*지정한 (속성명, 값) 저장*/
			session.setAttribute("pw", pw); /*지정한 (속성명, 값) 저장*/
			// 바로~ 홈으로 감
// 			response.sendRedirect("../");
		}//if
	%>
	<jsp:useBean id="member" class="dto.MemberDTO" scope="session"/>
	<jsp:setProperty property="*" name="member"/>
<%-- 	<jsp:setProperty property="id" name="member"/> --%>
<%-- 	<jsp:setProperty property="pw" name="member"/> --%>
	<div>id : <jsp:getProperty property="id" name="member"/></div>
	<div>pw : <jsp:getProperty property="pw" name="member"/></div>
</body>
</html>