package hr;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDAO;

@WebServlet("/employee/emp_update")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지니스 로직 : 선택한 사원정보를 DB에서 조회해온다.
		HrDAO dao = new HrDAO();
		
		//DB에서 선택한 사원정보를 수정하는 메소드 호출
		int id = Integer.parseInt(request.getParameter("id"));
		dao.employee_update(id);
		
		//응답화면 연결
		//1.forward 방식
		//RequestDispatcher rd = request.getRequestDispatcher("emp_list");
		//rd.forward(request, response);
		//2.redirect 방식
		response.sendRedirect("emp_list");
	}

}
