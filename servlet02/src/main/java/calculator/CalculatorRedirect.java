package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator_redirect")
public class CalculatorRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.printf("<div><a href='./'>홈으로</a></div>");
		out.printf("<div><a href='calculator.html'>이전 화면</a></div>");
		out.print("<hr>");
		
		out.print("<h2>계산 결과 - redirect 방식</h2>");
		//out.printf("%d %s %d = %d",num1,operator,num2,calculated);
		//out.printf("%d %s %d = %d",num1,operator,num2,c.getResult());
		out.printf("<div> %s </div>",request.getAttribute("calculated"));//null
		out.printf("<div> %s </div>",request.getSession().getAttribute("result"));
		out.print("</html>");
	}

}
