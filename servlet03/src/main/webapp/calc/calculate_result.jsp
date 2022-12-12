<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calculate_result</title>
</head>
<body>
	<h2><a href="../">홈으로</a></h2>
	<hr>
	<h2>calculate_result</h2>
	<%
	    int result = 0;
	    
	    if(request.getMethod().equals("POST")){
	    	//Stirng -> int
	        int num1 = Integer.parseInt(request.getParameter("num1"));
	        String operator = request.getParameter("operator");
	        int num2 = Integer.parseInt(request.getParameter("num2"));
	        
	        switch(operator){
	        case "+":
	            result = num1 + num2;
	            break;
	        case "-":
	            result = num1 - num2;
	            break;
	        case "*":
	            result = num1 * num2;
	            break;
	        case "/":
	            result = num1 / num2;
	            break;
	        }
	    }
	%>
	<%
		request.setAttribute("result", result);
	
		RequestDispatcher rd = request.getRequestDispatcher("../"); // go to home
		rd.forward(request, response);
	%>
</body>
</html>