<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>user</title>
</head>
<body>
	<h2><a href="/servlet05/">홈으로</a></h2>
	<hr>
	<h3>사용자 정보</h3>
	<ul>
		<li>아이디: user1</li>
		<li>이름: ${name}</li>
		<li>돈: ${money}</li>
	</ul>
	
	<h4>숫자포맷</h4>
	<ul>
		<li><fmt:formatNumber type="currency" value='${money}' groupingUsed="true"/></li>
	</ul>
</body>
</html>