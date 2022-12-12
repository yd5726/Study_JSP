package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청에 대한 실행");
		System.out.println("요청에 맞는 비즈니스 로직");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//응답할 화면
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>로그인 정보</h2>");
		out.printf("<div>아이디: %s<div>",id);
		out.printf("<div>비밀번호: %s<div>",pw);
		out.printf("<div><a href='login_form.html'>로그인 화면</a></div>");
		out.print("</body>");
		out.print("</html>");
	}
}
