<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product_info</title>
</head>
<body>
	<h2><a href="/servlet05/">홈으로</a></h2>
	<div><a href="productAll.pc">상품 전체 목록</a></div>
	<hr>
	<h3>상품 정보</h3>
	<table border='1'>
		<tr>
			<th>name</th>
			<td>${dto.name}</td>
		</tr>
		<tr>
			<th>company</th>
			<td>${dto.company}</td>
		</tr>
		<tr>
			<th>price</th>
			<td><fmt:formatNumber value="${dto.price}"/></td>
		</tr>
		<tr>
			<th>qty</th>
			<td>${dto.qty}</td>
		</tr>
	</table>
</body>
</html>