<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sum</title>
</head>
<body>
	<h2><a href="./">홈으로</a></h2>
	<%@ include file="include/today.jsp" %>
	<h2>스크립팅 기본 문법</h2>
	<div>1. 스크립트릿</div>
	<div>합 계산하기</div>
	<%
		int sum = 0;
		for(int i=1;i<=10;i++){
			sum += i;
		}
		String text = "나가라";
		
		//3. 선언
		num1 = 10;
		num2 = 20;
		operator = "*";
		int result = calculate();
	%>
	<hr>
	<div>2. 표현식</div>
	<%="가나다" %>
	<%=text %>
	<div>1~10까지의 합 : <%=sum %></div>
	<div><%="1~10까지의 합은 " + sum + " 입니다." %></div>
	<hr>
	<div>3. 선언</div>
	<%!
		int num1, num2;
		String operator;
		int calculate(){
			int result = 0;
			if(operator.equals("+")){
				result = num1 + num2;
			}else if(operator.equals("-")){
				result = num1 - num2;				
			}else if(operator.equals("*")){
				result = num1 * num2;				
			}else if(operator.equals("/")){
				result = num2 == 0 ? 0 : num1 / num2;				
			}
			return result;
		}//calculater()
	%>
	<div><%=num1%> <%=operator%> <%=num2%> = <%=calculate()%></div>
	<div><%=num1 + operator + num2 +"="+calculate()%></div>
	<hr>
	<div>4. 지시어</div>
</body>
</html>