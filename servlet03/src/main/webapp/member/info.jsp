<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>
</head>
<body>
	<div><a href="../">홈으로</a></div>
	<div><a href="join.jsp">회원가입</a></div>
	<h2>회원정보</h2>
	<%
		pageContext.setAttribute("pageInfo", "스마트");
		request.setAttribute("requestInfo", "웹&앱");
	%>
	<h3>회원정보 [<%=pageContext.getAttribute("pageInfo")%>]
			   [<%=request.getAttribute("requestInfo")%>]</h3>
	<%
		//request.setCharacterEncoding("UTF-8"); // 재사용을 위해 필터 만들기
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
	%>
	<div>이름: <%=name %></div>
	<div>성별: <%=gender %></div>
	<div>취미: 
	<%
		for(String h : hobby){
			out.print(h + "&nbsp;");
		}
	%>
	</div>
	<hr>
	<%
		// 회원가입 버튼 누른 후 바로~ 홈으로 감
		// forward 방식
		/* RequestDispatcher rd = request.getRequestDispatcher("../");
		rd.forward(request, response); */
		// redirect 방식
		response.sendRedirect("../");
	%>
</body>
</html>