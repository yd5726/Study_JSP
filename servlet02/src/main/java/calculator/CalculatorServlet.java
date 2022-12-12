package calculator;

import java.io.IOException;

/*import javax.servlet.RequestDispatcher;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		//Integer -> int : 자동 형변환
		int num2 = Integer.valueOf(request.getParameter("num2"));
		String operator = request.getParameter("operator");
		
		//비지니스 로직 : 연산처리
		//int calculated = calculate(num1,num2,operator);
		Calculator c = new Calculator(num1,num2,operator);
		String result = num1 + operator + num2 + "=" + c.getResult();
		//응답 화면에서 사용할 수 있도록 request에 담는다.
		request.setAttribute("calculated", result);	//null
		request.getSession().setAttribute("result", result);
		}catch(Exception e) {
//			RequestDispatcher rd = request.getRequestDispatcher("calcuoator_error");
//			rd.forward(request, response);
			request.setAttribute("error", e);
			request.getRequestDispatcher("calcuoator_error").forward(request, response);
		}
		
		//응답 화면
		//1. forward 방식 : 요청 url이 그대로 유지됨
//		RequestDispatcher rd = request.getRequestDispatcher("hello.jsp");
//		rd.forward(request, response);
		//2. redirect 방식 : 요청 url은 redirect된 url로 변경됨
//		response.sendRedirect("hello.jsp");
		
		//1. forward 방식
//		RequestDispatcher rd = request.getRequestDispatcher("calculator_forward");
//		rd.forward(request, response);
		//2. redirect 방식
		response.sendRedirect("calculator_redirect");
		
		/*
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>계산 결과</h2>");
		//out.printf("%d %s %d = %d",num1,operator,num2,calculated);
		out.printf("%d %s %d = %d",num1,operator,num2,c.getResult());
		out.printf("<div><a href='calculator.html'>이전 화면</a></div>");
		out.print("</html>");
		*/
	}
	/*
	int calculate(int num1, int num2, String operator){
		int result = 0;
		switch(operator){
			case "+":
				result = num1+num2;
				break;
			case "-":
				result = num1-num2;
				break;
			case "*":
				result = num1*num2;
				break;
			case "/":
				result = num1/num2;
				break;
		}
		return result;
	}//calculate()
	*/
}
