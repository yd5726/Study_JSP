package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.command.EmployeeDelete;
import employee.command.EmployeeInsert;
import employee.command.EmployeeSelect;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:80/servlet02/select.do
		String uri = request.getRequestURI(); // /servlet02/select.do
		String context = request.getContextPath(); // /servlet02
		uri = uri.substring(context.length());// /select.do
		
		String business ="", view="";
		if(uri.equals("/select.do")){
			business = "조회 요청에 대한 비지니스 로직";
			view = "select"; //조회 요청에 대한 응답화면
			
			// 비지니스로직
			EmployeeSelect command = new EmployeeSelect();
			command.execute(request, response);
			
			// 응답화면연결
			// insert/update/delete 처리가 실행되는 요청 후 화면 연결은 redirect 방식으로
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
			
		}else if(uri.equals("/insert.do")){
			business = "저장 요청에 대한 비지니스 로직";
			view = "select.do";
			
			// 비지니스로직
			EmployeeInsert command = new EmployeeInsert();
			command.execute(request, response);
			
			// 응답화면연결
			//RequestDispatcher rd = request.getRequestDispatcher(view);
			//rd.forward(request, response);
			
			// 프리젠테이션 로직
			response.sendRedirect(view);
		}else if(uri.equals("/update.do")){
			business = "수정 요청에 대한 비지니스 로직";
			view = "수정 요청에 대한 응답화면";
		}else if(uri.equals("/delete.do")){
			//business = "삭제 요청에 대한 비지니스 로직";
			view = "select.do";
			
			// 비지니스로직
			EmployeeDelete command = new EmployeeDelete();
			command.execute(request, response);
			
			// 프리젠테이션 로직
			response.sendRedirect(view);
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href='front.html'>front controller 패턴</a></div>");
		out.printf("<div>%s</div>",business);
		out.printf("<div>%s</div>",view);
		out.print("</body>");
		out.print("</html>");
		
	}

}
