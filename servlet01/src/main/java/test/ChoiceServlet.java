package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/choice")
public class ChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		response.setContentType("text/html; charset=UTF-8");
				
		String gender = request.getParameter("gender");
		//String sports = request.getParameter("sports");
		String sports[] =  request.getParameterValues("sports");
		
		//응답할 화면
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>성별 선택 및 스포츠 선택 정보</h2>");
		out.printf("<div>성별: %s<div>",gender);
		//out.printf("<div>스포츠: %s<div>",sports);
		out.print("<div>스포츠: ");
		for(String s : sports){
			out.printf("%s &nbsp;",s);
		}//for
		out.print("<div>");
		out.printf("<div><a href='choice.html'>이전 화면</a></div>");
		out.print("</body>");
		out.print("</html>");
}

}
