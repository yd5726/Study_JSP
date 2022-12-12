package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet")
//@WebServlet("/Hello")
//@WebServlet({"/Hello","/first"})
//@WebServlet("/*")
//@WebServlet({"/first.do","/second.do"})
@WebServlet("*.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("HelloServlet Served at: ").append(request.getContextPath());
		System.out.println("사용자가 웹 브라우저에서 url을 요청 시 실행되는 곳");
		//인코딩
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//쓰기 작업
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h2>Hello~</h2>");
		writer.print("<div>응답화면 만들기</div>");
		writer.print("</body>");
		writer.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
