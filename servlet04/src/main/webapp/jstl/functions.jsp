<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>functions</title>
</head>
<body>
	<div><a href='<c:url value="/"/>'>홈으로</a></div>
	<hr>
	<h2>함수 라이브러리</h2>
	<c:set var="title" value="   함수 라이브러리 FUNCTIONS"></c:set>
	<h4>[${title}]</h4>
	여기에    공백을        아무리 많이       줘도    한 개만 표현된다!
	<ul>
		<li>문자열의 길이: ${ fn: length(title) }</li><!--___함수_라이브러리_FUNCTIONS-->
		<li>문자열의 일부: ${ fn: substring(title,6,11) }]</li> <!--라이브러리--><!--]--> <!-- 3번째 파라미터(끝위치+1) 생략 불가 -->
		<li>공백 제거하기: [${ fn: trim(title) }]</li>  <!-- 양쪽 끝 공백 자르기 -->
	</ul>
	<c:set var='email' value='hong2022@naver.com'/>
	<h4>[${email}]</h4>
	<ul>
		<li>특정 문자열의 위치: ${ fn: indexOf(email, '@') }</li>
		<li>이메일 아이디: ${ fn: substring(email,0,8) }</li>
		
		<li>이메일 아이디 출력: ${ fn: substring( email,0,fn: indexOf(email,'@') ) }</li>
		<li>이메일 호스트 출력: ${ fn: substring( email, fn: indexOf(email,'@') + 1, fn: length(email) ) }</li>
		<li>fn: indexOf(email,'@') + 1 : ${fn: indexOf(email,'@') + 1 }</li>
		<li>fn: length(email) : ${fn: length(email)}</li>
		<li>문자열 변경(com -> co.kr): ${fn: replace(email, 'com', 'co.kr')} }</li>
		<li>문자열 변경(o -> e): ${fn: replace(email, 'o', 'e')} }</li>
		<li>대문자화: ${fn: toUpperCase(email)}</li>
		<li>소문자화: ${fn: toLowerCase(email)}</li>
		<li>특정 문자열(com) 포함 여부 확인: ${fn: contains(email,'com')}</li>
		<li>특정 문자열(co.kr) 포함 여부 확인: ${fn: contains(email,'co.kr')}</li>
		<li>
			특정 문자열(com) 포함 여부 확인(c:if 사용):
			<c:if test="${fn: contains(email,'com') }">
				com 있음
			</c:if>
		</li>
		<li>
			특정 문자열(co.kr) 포함 여부 확인(c:if 사용):
			<c:if test="${! fn: contains(email,'co.kr') }">
				co.kr 없음
			</c:if>
		</li>
	</ul>
	<hr>
	<h3>문자연결 및 분리</h3>
	<%
		String[] fruits = {"귤","배","감"};
	%>
	<c:set var="fruits" value="<%=fruits %>"></c:set>
	<ul>
		<li>문자 연결: ${fn: join(fruits, '+')}</li>
		<li>문자 연결 + 개행: ${fn: join(fruits, '<br>')}</li>
	</ul>
	<%
		String data = "java,oracle?html,css/jquery";
		String[] arr = data.split(",");
		request.setAttribute("subject", data);
	%>
	<ul>
		<li>문자 분리: 
			<c:forEach items="${fn: split(subject, ',/?')}" var="s">
			${s}
			</c:forEach>
		</li>
		<li>문자 분리 + div 태그(개행)
			<c:forEach items="${fn: split(subject, ',/?')}" var="s">
			<div>${s}</div>
			</c:forEach>
		</li>
	</ul>
	
	
	
</body>
</html>