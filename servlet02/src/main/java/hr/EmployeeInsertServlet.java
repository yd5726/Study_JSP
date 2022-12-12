package hr;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDAO;
import dto.EmployeeDTO;

@WebServlet("/employee/emp_insert")
public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 입력한 정보를 DB에 저장: 비즈니스 로직
		//1.화면에서 입력한 정보를 수집
		EmployeeDTO dto = new EmployeeDTO();
		dto.setLast_name(request.getParameter("last_name"));
		dto.setFirst_name(request.getParameter("first_name"));
		dto.setEmail(request.getParameter("email"));
		dto.setJob_id(request.getParameter("job_id"));
		int dept = Integer.parseInt(request.getParameter("department_id"));
		dto.setDepartment_id(dept);
		dto.setSalary(Integer.valueOf(request.getParameter("salary")));
		
		//2.DB 연결 -> 저장처리 메소드 호출
		HrDAO dao = new HrDAO();
		dao.employee_insert(dto);
		
		//응답화면 연결
		//1.forward 방식
		//RequestDispatcher rd = request.getRequestDispatcher("emp_list");
		//rd.forward(request, response);
		//2.redirect 방식
		response.sendRedirect("emp_list");
		
	}

}
