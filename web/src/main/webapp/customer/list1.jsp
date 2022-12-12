<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>list</title>

</head>
<body>
 	<h3>고객목록</h3>
	<table border='1'>
		<tr><th>고객명</th>
			<th>이메일</th>
			<th>전화번호</th>
		</tr>
	<c:forEach items='${list}' var='dto'>
		<tr><td>${dto.name}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>