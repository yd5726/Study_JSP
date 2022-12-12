package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.TestCommand;

@WebServlet("*.do")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.substring(path.length());
		
		if(uri.equals("/test.do")){
			// 비지니스 로직 처리
			TestCommand tc = new TestCommand();
			tc.execute(request, response);
			
			//응답 화면 연결: forward
			//redirect 하는 경우: DB에 insert,update,delete 하는 요청에 대한 처리를 하는 경우
			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
		}
	}

}
