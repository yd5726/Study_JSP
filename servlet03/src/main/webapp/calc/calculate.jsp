<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calculate</title>
</head>
<body>
	<h2><a href="../">홈으로</a></h2>
	<hr>
	<h2>calculate</h2>
	<form method='post' action='calculate_result.jsp'>
		<div>
			<input type="text" name='num1'>
			<select name="operator">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
			<input type='text' name='num2'>
		</div>
		<div><input type='submit' value='계산하기'></div>
	</form>
</body>
</html>