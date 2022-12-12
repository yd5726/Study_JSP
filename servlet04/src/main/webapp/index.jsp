<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='scope/scope_data.jsp'>데이터 저장 및 출력</a></div>
<div><a href='param/form_data.jsp'>파라미터 출력</a></div>
<div><a href='operator/calculator.jsp'>계산기</a></div>
<div><a href='array/array_data.jsp'>배열,자료구조,맵</a></div>
<div><a href='jstl/index.jsp'>JSTL</a></div>
<div>
	<!-- 절대경로,  path 설정 /el로 해둔 상태 -->
	<a href="/el/param/form_result.jsp?name=심청&gender=남">회원정보</a>
</div>
<div>
	<!-- 절대경로,  path 설정 /el과 상관 없이 적용된다?? c:url 덕분에!? -->
	<a href="<c:url value ='/param/form_result.jsp?name=심청&gender=남'/>">회원정보</a>
</div>
<div>
	<c:url value="/jstl/index.jsp" var="jstl"> <!-- jstl 변수를 선언해서 담았다. -->
		<c:param name="name" value="박문수"/> <!-- 값을 담은 url -->
	</c:url>
</div>
<div><a href="${jstl}">JSTL 링크</a></div> <!-- jstl 변수에 담긴 url로 이동한다. -->

<hr>

<h3>홈</h3>
</body>
</html>