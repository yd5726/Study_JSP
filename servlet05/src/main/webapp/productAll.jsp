<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productAll</title>
</head>
<body>
	<h2><a href="/servlet05/">홈으로</a></h2>
	<hr>
	<h3>전체 상품 정보 목록</h3>
	<table border='1'>
		<tr>
			<th>num</th>
			<th>name</th>
			<th>company</th>
			<th>price</th>
			<th>qty</th>
		</tr>
		<c:forEach items="${product_list}" var="dto">
			<tr>
				<td><a href="product_info.pc?num=${dto.num}">${dto.num}</a></td>
				<td>${dto.name}</td>
				<td>${dto.company}</td>
				<td><fmt:formatNumber value="${dto.price}"/></td>
				<td>${dto.qty}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>